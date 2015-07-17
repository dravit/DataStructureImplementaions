package concurrency.countdownlatches;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dravit on 6/18/2015.
 */
public class WorldThread implements Runnable {
    public void run() {
        printMessage();
    }
    private void printMessage() {
        long localWorldController = HelloWorldPrinter.worldController.getCount();
        while(HelloWorldPrinter.worldController.getCount() > 0) {
            if(HelloWorldPrinter.worldController.getCount() < localWorldController) {
                System.out.print(" World\n");
                HelloWorldPrinter.helloController.countDown();
                localWorldController--;
            } else {
                try {
                    HelloWorldPrinter.helloController.await(100, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
