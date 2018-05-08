package codingQuestions.producer_consumer.stack;

/**
 * Created by dravi on 06-05-2018.
 */
public class Main {

    public static void main(String[] args) {
        StackAsBucket stackAsBucket = new StackAsBucket(10);

        Object monitor = new Object();

        TapAsProducer tapAsProducer = new TapAsProducer(stackAsBucket, monitor);
        MugAsConsumer mugAsConsumer = new MugAsConsumer(stackAsBucket, monitor);

        new Thread(tapAsProducer, "Producer").start();
        new Thread(mugAsConsumer, "Consumer").start();
    }


}
