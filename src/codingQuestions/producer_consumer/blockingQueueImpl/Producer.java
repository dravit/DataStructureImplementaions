package codingQuestions.producer_consumer.blockingQueueImpl;

import java.util.concurrent.BlockingQueue;

/**
 * Created by dravi on 3/15/2018.
 */
public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Message message;
        for (int i = 0; i < 100; i++) {
            message = new Message("Message " + i);
            try {
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message = new Message("Exit");
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
