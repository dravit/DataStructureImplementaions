package concurrency.synchronization.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Dravit on 7/7/2015.
 */
public class PrintQueue {
    /**
     * The constructor for this class accepts an optional fairness parameter. When set true, under contention,
     * locks favor granting access to the longest-waiting thread. Otherwise this lock does not guarantee any particular
     * access order. Programs using fair locks accessed by many threads may display lower overall
     * throughput (i.e., are slower; often much slower) than those using the default setting, but have smaller
     * variances in times to obtain locks and guarantee lack of starvation. Note however, that fairness of locks
     * does not guarantee fairness of thread scheduling. Thus, one of many threads using a fair lock may obtain
     * it multiple times in succession while other active threads are not progressing and not currently holding the
     * lock. Also note that the untimed tryLock() method does not honor the fairness setting. It will succeed if
     * the lock is available even if other threads are waiting.
     */
    private final Lock queueLock = new ReentrantLock(true);

    public void printJob(Object document) {
        /**
         *  At the beginning of the critical section, we have to get the control of the lock using the lock() method.
         *  When a thread (A) calls this method, if no other thread has the control of the lock, the method gives
         *  the thread (A) the control of the lock and returns immediately to permit the execution of the critical
         *  section to this thread. Otherwise, if there is another thread (B) executing the critical section
         *  controlled by this lock, the lock() method puts the thread (A) to sleep until the thread (B) finishes
         *  the execution of the critical section.
         */
        queueLock.lock();
        try
        {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds");
            Thread.sleep(duration);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            /**
             * At the end of the critical section, we have to use the unlock() method to free the control of the
             * lock and allow the other threads to run this critical section. If you don't call the unlock() method
             * at the end of the critical section, the other threads that are waiting for that block will be waiting
             * forever, causing a deadlock situation. If you use try-catch blocks in your critical section, don't
             * forget to put the sentence containing the unlock() method inside the finally section
             */
            queueLock.unlock();
        }
    }
}
