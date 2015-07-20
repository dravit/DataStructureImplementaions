package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dravit on 6/18/15.
 */
public class HelloThread implements Runnable {
    private final CountDownLatch helloController;
    private final CountDownLatch worldController;
    private long localHelloController;
    public HelloThread(CountDownLatch helloController, CountDownLatch worldController) {
        this.helloController = helloController;
        this.worldController = worldController;
        this.localHelloController = helloController.getCount();
    }
    public void run() {
        printMessage();
    }
    private void printMessage() {
        while(localHelloController > 0) {
            if(helloController.getCount() <= localHelloController) {
                System.out.print("Hello");
                localHelloController--;
                if(worldController.getCount() > 0) {
                    worldController.countDown();
                }
            }
        }
    }
}
