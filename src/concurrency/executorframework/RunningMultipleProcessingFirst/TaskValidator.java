package concurrency.executorframework.RunningMultipleProcessingFirst;

import java.util.concurrent.Callable;

/**
 * Created by Dravit on 7/2/2015.
 */
public class TaskValidator implements Callable<String> {
    private UserValidator validator;
    private String user;
    private String password;
    public TaskValidator(UserValidator validator, String user, String password){
        this.validator = validator;
        this.password = password;
        this.user = user;
    }
    public String call() throws Exception {
        if (!validator.validate(user, password)) {
            System.out.printf("%s: The user has not been found\n",validator.getName());
            throw new Exception("Error validating user");
        }
        System.out.printf("%s: The user has been found\n",validator. getName());
        return validator.getName();
    }
}
