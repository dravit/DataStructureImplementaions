package concurrency.countdownlatches;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dravit on 6/18/2015.
 */
public class HelloThread implements Runnable {
    
    public void run() {
        printMessage();
    }
    private void printMessage() {
        long localHelloController = HelloWorldPrinter.helloController.getCount();
        boolean firstTime = true;
        while(HelloWorldPrinter.helloController.getCount() > 0) {
            if(HelloWorldPrinter.helloController.getCount() < localHelloController || firstTime) {
                System.out.print("Hello");
                HelloWorldPrinter.worldController.countDown();
                localHelloController--;
                firstTime = false;
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
