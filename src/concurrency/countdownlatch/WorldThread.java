package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dravit on 6/18/15.
 */
public class WorldThread implements Runnable {
    private final CountDownLatch worldController;
    private final CountDownLatch byDravitController;
    private long localWorldController;
    public WorldThread(CountDownLatch worldController, CountDownLatch byDravitController) {
        this.worldController = worldController;
        this.byDravitController = byDravitController;
        this.localWorldController = worldController.getCount();
    }
    public void run() {
        printMessage();
    }
    private void printMessage() {
        while(localWorldController > 0) {
            if(worldController.getCount() < localWorldController) {
                System.out.print(" World");
                localWorldController--;
                if(byDravitController.getCount() > 0) {
                    byDravitController.countDown();
                }
            }
        }
    }
}
