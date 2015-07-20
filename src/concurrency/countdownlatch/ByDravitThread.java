package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dravit on 6/19/15.
 */
public class ByDravitThread implements Runnable {
    private final CountDownLatch byDravitController;
    private final CountDownLatch helloController;
    private long localByDravitController;
    public ByDravitThread(CountDownLatch byDravitController, CountDownLatch helloController) {
        this.byDravitController = byDravitController;
        this.helloController = helloController;
        this.localByDravitController = byDravitController.getCount();
    }
    public void run() {
        printMessage();
    }
    private void printMessage() {
        while(localByDravitController > 0) {
            if(byDravitController.getCount() < localByDravitController) {
                System.out.print(" By Dravit\n");
                localByDravitController--;
                if(helloController.getCount() > 0) {
                    helloController.countDown();
                }
            }
        }
    }
}
