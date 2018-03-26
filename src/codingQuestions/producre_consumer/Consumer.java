package codingQuestions.producre_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by dravi on 3/15/2018.
 */
public class Consumer implements Runnable {

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Message message;

        try {
            while ((message = queue.take()).getMessageName() != "Exit") {
                System.out.println("Printing message " + message.getMessageName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
