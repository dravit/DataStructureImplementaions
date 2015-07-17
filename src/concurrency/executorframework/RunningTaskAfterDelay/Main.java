package concurrency.executorframework.RunningTaskAfterDelay;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dravit on 7/2/2015.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 1 - denotes the number of workers you want to have in pool.
         */
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new Date());
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task " + i);
            /**
             * To execute a task in this scheduled executor after a period of time, you have to use the schedule() method.
             * This method receives the following three parameters:
             * <i>1.</i> The task you want to execute
             * <i>2.</i> The period of time you want the task to wait before its execution
             * <i>3.</i> The unit of the period of time, specified as a constant of the TimeUnit class
             * You can also use the Runnable interface to implement the tasks, because the schedule() method of the
             * ScheduledThreadPoolExecutor class accepts both types of tasks.
             *
             * Finally, we can configure the behavior of the ScheduledThreadPoolExecutor class when you call the
             * shutdown() method and there are pending tasks waiting for the end of their delay time.
             * The default behavior is that those tasks will be executed despite the finalization of the executor.
             * We can change this behavior using the setExecuteExistingDelayedTasksAfterShutdownPolicy() method of
             * the ScheduledThreadPoolExecutor class. With false, at the time of shutdown(),
             * pending tasks won't get executed.
             * It's default value is true.
             */
            executor.schedule(task, i + 5, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Ends at: %s\n", new Date());
    }
}
