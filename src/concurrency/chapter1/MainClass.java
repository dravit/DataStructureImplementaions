package concurrency.chapter1;

/**
 * Created by Dravit on 5/26/2015.
 */
public class MainClass {
    public static void main(String[] args) {
        Thread t = new Thread(new PrimeNumberGenerator());
        t.start();
        try {
            Thread.sleep(5);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}
