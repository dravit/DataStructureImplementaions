package concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dravit on 6/18/15.
 */
public class VideoConference implements Runnable {
    private final CountDownLatch controller;
    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }
    public void arrive(String name) {
        System.out.printf("%s has arrived", name);
        controller.countDown();
        System.out.printf(" VideoConference: Waiting for %d participants.\n", controller.getCount());
    }
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            controller.await();
            System.out.println("All Participants have arrived");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
