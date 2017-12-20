package concurrency.questions;

/**
 * This class is used to print odd Even numbers using two different threads
 * One thread will always print odd numbers and another will always print even number.
 * Printing of numbers should always be sequential
 */
public class PrintOddEvenNumbers extends Thread {

    volatile static private int i = 1;
    private final Object lock;

    PrintOddEvenNumbers(Object lock) {
        this.lock = lock;
    }

    public static void main(String ar[]) {
        Object obj = new Object();
        // This constructor is required for the identification of wait/notify
        // communication
        PrintOddEvenNumbers odd = new PrintOddEvenNumbers(obj);
        PrintOddEvenNumbers even = new PrintOddEvenNumbers(obj);
        odd.setName("Odd");
        even.setName("Even");
        odd.start();
        even.start();
    }

    @Override
    /**
     * In run method the idea is to start iterating the numbers and if it is divisible by 2 it is even
     * and if thread name that is doing this is also even than print the value with that thread,
     * After printing put itself into wait state.
     * Once in wait another thread will be able to get the lock and print the odd number with same conditions
     * and notify the previously waiting thread and release the lock.
     */
    public void run() {
        while (i <= 10) {
            if (i % 2 == 0 && "Even".equals(Thread.currentThread().getName())) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - "
                            + i);
                    i++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (i % 2 == 1 && "Odd".equals(Thread.currentThread().getName())) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " - "
                            + i);
                    i++;
                    lock.notify();
                }
            }
        }
    }
}