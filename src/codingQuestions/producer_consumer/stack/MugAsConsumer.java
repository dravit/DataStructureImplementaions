package codingQuestions.producer_consumer.stack;

/**
 * Created by dravi on 06-05-2018.
 */
public class MugAsConsumer implements Runnable {

    StackAsBucket stackAsBucket;
    Object monitor;

    public MugAsConsumer(StackAsBucket stackAsBucket, Object monitor) {
        this.stackAsBucket = stackAsBucket;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread started");
        while(true) {
            while(stackAsBucket.isEmpty()) {
                synchronized (stackAsBucket) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "Going to wait");
                        stackAsBucket.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (stackAsBucket) {
                stackAsBucket.pop();

                stackAsBucket.notifyAll();
            }
        }
    }
}
