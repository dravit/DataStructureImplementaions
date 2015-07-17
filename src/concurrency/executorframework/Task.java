package concurrency.executorframework;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dravit on 6/21/2015.
 */
public class Task implements Runnable {
    private Date initDate;
    private String name;
    public Task(String name) {
        this.initDate = new Date();
        this.name = name;
    }
    public void run(){
        System.out.printf("%s: Task %s: Created on: %s\n",Thread. currentThread().getName(),name,initDate);
        System.out.printf("%s: Task %s: Started on: %s\n",Thread. currentThread().getName(),name,new Date());
        /**
         * Noe put task to sleep for a random period
         */
        try {
            Long duration = (long)(Math.random() * 10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n",Thread.currentThread().getName(),name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.printf("%s: Task %s: Finished on: %s\n",Thread. currentThread().getName(),name,new Date());
    }
}
