package codingQuestions.producer_consumer.stack;

/**
 * Created by dravi on 06-05-2018.
 */
public class TapAsProducer implements Runnable {

    StackAsBucket stackAsBucket;
    Object monitor;

    public TapAsProducer(StackAsBucket stackAsBucket, Object monitor) {
        this.stackAsBucket = stackAsBucket;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for(int i=0; i < 20; i++) {

            while(stackAsBucket.isFull()) {
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
                stackAsBucket.push(i);
                stackAsBucket.notifyAll();
            }
        }

    }
}
