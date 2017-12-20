package concurrency.countdownlatches;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Dravit on 6/16/2015.
 */
public class CountDownLatchDemo {
    public static void main(String args[]) {
        final CountDownLatch latch = new CountDownLatch(3);
        //this is the number of times countdown will be called on this countdown latch object.
        //A thread can call countdown multiple times which makes it different from CyclicBarriers.
        //for(int i=0; i<10; i++) {
            Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
            Thread alertService = new Thread(new Service("AlertService", 1000, latch));
            Thread validationService = new Thread(new Service("ValidationService", 1000, latch));
            cacheService.start(); //separate thread will initialize CacheService
            //latch.countDown(); This is the case which breaks countdown latch even all the services are not started
            alertService.start(); //another thread for AlertService initialization
            validationService.start();
        //}
        // application should not start processing any thread until all service is up
        // and ready to do there job.
        // Countdown latch is idle choice here, main thread will start with count 3
        // and wait until count reaches zero. each thread once up and read will do
        // a count down. this will ensure that main thread is not started processing
        // until all services is up.
        // count is 3 since we have 3 Threads (Services)
        try {
            latch.await();  //main thread is waiting on CountDownLatch to finish
            System.out.println("All services are up, Application is starting now");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}