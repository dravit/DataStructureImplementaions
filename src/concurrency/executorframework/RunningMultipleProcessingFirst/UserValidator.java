package concurrency.executorframework.RunningMultipleProcessingFirst;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dravit on 7/2/2015.
 */
public class UserValidator {
    private String name;
    public UserValidator(String name) {
        this.name = name;
    }
    public boolean validate(String name, String password) {
        Random random=new Random();
        try {
            long duration = (long)(Math.random() * 10);
            System.out.printf("Validator %s: Validating a user during %d seconds\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextBoolean();
    }
    public String getName() {
        return this.name;
    }
}
