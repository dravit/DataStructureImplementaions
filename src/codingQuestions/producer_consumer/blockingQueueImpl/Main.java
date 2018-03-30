package codingQuestions.producer_consumer.blockingQueueImpl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by dravi on 3/15/2018.
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
