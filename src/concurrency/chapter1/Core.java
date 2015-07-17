package concurrency.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dravit on 5/27/2015.
 */
public class Core {
    public static void main(String[] args) {
        Unsafe unsafeThread = new Unsafe();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(unsafeThread);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
