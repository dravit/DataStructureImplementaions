package concurrency.synchronization.multipleConditions;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Dravit on 7/8/2015.
 * This class has six attributes:
 * A LinkedList<String> attribute named buffer that will store the shared data
 * An int type named maxSize that stores the length of the buffer
 * A ReentrantLock object called lock that controls the access to the blocks of code that modify the buffer
 * Two Condition attributes named lines and space
 * A boolean type called pendingLines that will indicate if there are lines in the buffer
 */
public class Buffer {
    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    /**
     *  It receives String as a parameter and tries to store it in the buffer.
     *  First, it gets the control of the lock. When it has it, it then checks if there is empty
     *  space in the buffer. If the buffer is full, it calls the await() method in the space condition
     *  to wait for free space. The thread will be woken up when another thread calls the signal()
     *  or signalAll() method in the space Condition. When that happens, the thread stores the line in
     *  the buffer and calls the signallAll() method over the lines condition. As we'll see in a moment,
     *  this condition will wake up all the threads that were waiting for lines in the buffer.
     * @param line
     */
    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                space.await();
            }
            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * It returns the first string stored in the buffer. First, it gets the control of the lock.
     * When it has it, it checks if there are lines in the buffer. If the buffer is empty, it calls the
     * await() method in the lines condition to wait for lines in the buffer. This thread will be woken
     * up when another thread calls the signal() or signalAll() method in the lines condition. When it
     * happens, the method gets the first line in the buffer, calls the signalAll() method over the space
     * condition and returns String.
     * @return
     */
    public String get() {
        String line = null;
        lock.lock();
        try {
            while ((buffer.size() == 0) && (hasPendingLines())) {
                lines.await();
            }
            if (hasPendingLines()) {
                line = buffer.poll();
                System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    public boolean hasPendingLines() {
        return pendingLines || buffer.size() > 0;
    }
}
