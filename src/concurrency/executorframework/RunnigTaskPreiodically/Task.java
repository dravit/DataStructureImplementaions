package concurrency.executorframework.RunnigTaskPreiodically;

import java.util.Date;

/**
 * Created by Dravit on 7/4/2015.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
    }
}
