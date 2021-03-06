package concurrency.executorframework.RunnigTaskPreiodically;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dravit on 7/4/2015.
 */
public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new Date());
        Task task = new Task("Task");
        /**
         * In this example, as your task is a Runnable object that is not parameterized, you have to parameterize
         * them with the ? symbol as a parameter.
         */
        /**
         * If any execution of this task
         * takes longer than its period, then subsequent executions
         * may start late, but will not concurrently execute.
         */
        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            System.out.printf("Main: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
            //Sleep the thread during 500 milliseconds.
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executor.shutdown();
            //Put the thread to sleep for 5 seconds to verify that the periodic tasks have finished.
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Main: Finished at: %s\n", new Date());

        }
    }
}
