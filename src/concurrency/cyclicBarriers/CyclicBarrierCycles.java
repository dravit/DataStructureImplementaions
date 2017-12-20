package concurrency.cyclicBarriers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierCycles {

    static CyclicBarrier barrier;

    public static void main(String[] args) throws InterruptedException {
        barrier = new CyclicBarrier(3);         //This is the number of threads that must be
        // waiting (using await function of this barrier object) at barrier to re-trigger it.

        new Worker().start();
        Thread.sleep(1000);
        new Worker().start();
        Thread.sleep(1000);
        new Worker().start();
        Thread.sleep(1000);

        System.out.println("Barrier automatically resets.");

        new Worker().start();
        Thread.sleep(1000);
        new Worker().start();
        Thread.sleep(1000);
        new Worker().start();
    }

}


class Worker extends Thread {
    boolean interrupt = false;
    public Worker() {
    }

    public Worker(boolean interrupt) {
        this.interrupt = interrupt;
    }
    @Override
    public void run() {
        try {
            System.out.println("Find number of threads waiting at barrier"+CyclicBarrierCycles.barrier.getNumberWaiting());
            CyclicBarrierCycles.barrier.await();
            System.out.println("Let's play.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}