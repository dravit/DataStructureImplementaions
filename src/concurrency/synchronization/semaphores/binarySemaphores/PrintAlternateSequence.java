package concurrency.synchronization.semaphores.binarySemaphores;

import java.util.concurrent.Semaphore;

class ThreadPrinter implements Runnable {
    int counter;
    Semaphore ins, outs;

    ThreadPrinter(int counter, Semaphore ins, Semaphore outs) {
        this.counter = counter;
        this.ins = ins;
        this.outs = outs;
    }

    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            try {
                System.out.println("available permits are::::  "+ins.availablePermits());
				ins.acquire();
				System.out.println("thread "+Thread.currentThread().getName()+" is excuting");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // wait for permission to run
            System.out.println("" + counter);
            System.out.println("avaialable permits of out are:::::;;  "+outs.availablePermits());
            outs.release();  // allow another thread to run
            counter += 2;
        }
    }
}


public class PrintAlternateSequence {

	public static void main(String args[]){
		Semaphore a = new Semaphore(1);  // first thread is allowed to run immediately
		Semaphore b = new Semaphore(0); // second thread has to wait
		ThreadPrinter tp1 = new ThreadPrinter(1, a, b);
		ThreadPrinter tp2 = new ThreadPrinter(2, b, a);
		
		Thread t1=new Thread(tp1,"firstThread");
		Thread t2=new Thread(tp2,"secondThread");
		t1.start();
		t2.start();
		
	}
	}