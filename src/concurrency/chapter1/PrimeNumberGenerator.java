package concurrency.chapter1;

/**
 * Created by Dravit on 5/26/2015.
 */
public class PrimeNumberGenerator implements Runnable {
    public void run() {
        generatePrimeNo();
    }

    public void generatePrimeNo() {
        long start = 3;
        while(true) {
            start++;
            boolean isPrime = true;
            for(int i = 2; i < start; i++) {
                if(i % 2 == 0) {
                    continue;
                }
                if(start % 2 == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) {
                System.out.println("Prime >> "+start);
            }
            if(Thread.interrupted()) {
                System.out.println("Exiting as thread is interrupted");
                return;
            }
        }
    }
}
