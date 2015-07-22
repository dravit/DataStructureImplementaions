package concurrency.executorframework.RunningMultipleProcessingFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Dravit on 7/2/2015.
 */
public class Main {
    public static void main(String[] args) {
        String userName = "test";
        String password = "test";
        UserValidator ldapValidator=new UserValidator("LDAP");
        UserValidator dbValidator=new UserValidator("DataBase");
        TaskValidator ldapTask=new TaskValidator(ldapValidator, userName, password);
        TaskValidator dbTask=new TaskValidator(dbValidator,userName,password);
        List<TaskValidator> taskList=new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);
        ExecutorService executor=(ExecutorService) Executors. newCachedThreadPool();
        String result;
        try {
            /**
             *  The invokeAny() method of the ThreadPoolExecutor class receives a list of tasks,
             *  launches them, and returns the result of the first task that finishes without throwing an exception.
             *  This method returns the same data type that the call() method of the tasks you launch returns.
             *  In this case, it returns a String value.
             *  So, we have two tasks that can return the true value or throw an Exception exception.
             *  You can have the following four possibilities:
             *  <i>1.</i> Both tasks return the true value. The result of the invokeAny() method is the name of the
             *  task that finishes in the first place.
             *  <i>2.</i> The first task returns the true value and the second one throws Exception.
             *  The result of the invokeAny() method is the name of the first task.
             *  <i>3.</i> The first task throws Exception and the second one returns the true value.
             *  The result of the invokeAny() method is the name of the second task.
             *  <i>4.</i>Both tasks throw Exception. In that case, the invokeAny() method throws  an
             *  ExecutionException exception
             */
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n",result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.printf("Main: End of the Execution\n");
    }
}
