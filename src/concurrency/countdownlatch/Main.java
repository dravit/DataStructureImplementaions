package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dravit on 6/18/15.
 */
public class Main {
    public static void main(String[] args) {
        CountDownLatch helloController = new CountDownLatch(100);
        CountDownLatch worldController = new CountDownLatch(100);
        CountDownLatch byDravitController = new CountDownLatch(100);
        HelloThread helloThread = new HelloThread(helloController, worldController);
        WorldThread worldThread = new WorldThread(worldController, byDravitController);
        ByDravitThread byDravitThread = new ByDravitThread(byDravitController, helloController);
        Thread hThread = new Thread(helloThread);
        Thread wThread = new Thread(worldThread);
        Thread bdThread = new Thread(byDravitThread);
        hThread.start();
        wThread.start();
        bdThread.start();
    }
}
