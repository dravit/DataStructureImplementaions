package concurrency.executorframework.CallableExample;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dravit on 7/1/2015.
 */
public class FactorialCalculator implements Callable<Integer> {
    private Integer number;
    public FactorialCalculator(Integer number) {
        this.number = number;
    }
    @Override
    public Integer call() throws InterruptedException {
        int result = 1;
        if (number == 0 || number == 1) {
            result = 1;
        }
        for(int i = 2; i < number; i++) {
            result*=i;
            TimeUnit.MILLISECONDS.sleep(20);
        }
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
        return result;
    }
}
