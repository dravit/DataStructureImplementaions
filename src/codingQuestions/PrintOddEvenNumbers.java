package codingQuestions;

/**
 * This class is used to print odd Even numbers using two different threads
 * One thread will always print odd numbers and another will always print even number.
 * Printing of numbers should always be sequential
 */
public class PrintOddEvenNumbers implements Runnable {

    volatile static private int i = 1;
    private final Object lock;

    private PrintOddEvenNumbers(Object lock) {
        this.lock = lock;
    }

    public static void main(String ar[]) {
        Object obj = new Object();
        // This constructor is required for the identification of wait/notify
        // communication
        PrintOddEvenNumbers printOddEvenNumbers = new PrintOddEvenNumbers(obj);
        Thread oddThread = new Thread(printOddEvenNumbers);
        Thread evenThread = new Thread(printOddEvenNumbers);
        oddThread.setName("Odd");
        evenThread.setName("Even");
        oddThread.start();
        evenThread.start();
    }

    /**
     * In run method the idea is to start iterating the numbers and if it is divisible by 2 it is even
     * and if thread name that is doing this is also even than print the value with that thread,
     * After printing put itself into wait state.
     * Once in wait another thread will be able to get the lock and print the odd number with same conditions
     * and notify the previously waiting thread and release the lock.
     */
    @Override
    public void run() {
        while (i <= 10) {
            if (i <= 10 && i % 2 == 0 && "Even".equals(Thread.currentThread().getName())) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - "
                            + i);
                    i++;
                    try {
                        lock.wait();        //In case of wait this thread will release the
                        //ownership of the monitor so that another thread can acquire that ownership
                        //but thread will continue to wait until another thread notifies this thread
                        //using monitor
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (i <= 10 && i % 2 == 1 && "Odd".equals(Thread.currentThread().getName())) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - "
                            + i);
                    i++;
                    lock.notify();//This notify will notify the waiting thread.
                }
            }
        }
    }
}