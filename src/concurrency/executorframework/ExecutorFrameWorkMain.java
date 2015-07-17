package concurrency.executorframework;

/**
 * Created by Dravit on 6/21/2015.
 */
public class ExecutorFrameWorkMain {
    public static void main(String[] args) {
        Server server = new Server();
        for (int i=0; i<100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
