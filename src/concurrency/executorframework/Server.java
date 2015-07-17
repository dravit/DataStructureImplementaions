package concurrency.executorframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Dravit on 6/21/2015.
 */
public class Server {
    private ThreadPoolExecutor executor;
    public Server() {
        //executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        /**
         * This will create a fixed size thread pool and the task after that
         * size will be blocked if no thread is available in the pool and will
         * be resumed when thread becomes available.
         */
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }
    /**
     * Implement the executeTask() method.
     * It receives a Task object as a parameter and sends it to the executor.
     * First, write a message to the console indicating that a new task has arrived
     */
    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n",executor. getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor. getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor. getCompletedTaskCount());
    }
    public void endServer() {
        executor.shutdown();
    }
}
