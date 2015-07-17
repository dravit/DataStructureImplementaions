package concurrency.countdownlatches;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Dravit on 6/18/2015.
 */
public class HelloWorldPrinter {
    protected volatile static CountDownLatch helloController = new CountDownLatch(3);
    protected volatile static CountDownLatch worldController = new CountDownLatch(3);
    protected volatile static CountDownLatch dravitController = new CountDownLatch(3);
    public static void main(String[] args) {
        CountDownLatch helloController = new CountDownLatch(200);
        HelloThread helloThread = new HelloThread();
        WorldThread worldThread = new WorldThread();
        Thread hThread = new Thread(helloThread);
        Thread wThread = new Thread(worldThread);
        hThread.start();
        wThread.start();
    }
}
