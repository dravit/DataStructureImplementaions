package concurrency.executorframework.RunningTaskAfterDelay;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Dravit on 7/2/2015.
 */
public class Task implements Callable<String> {
    public String name;

    public Task(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
        return "Hello, world";
    }
}
