package codingQuestions.producer_consumer.blockingQueueImpl;

/**
 * Created by dravi on 3/15/2018.
 */
public class Message {

    private String messageName;

    public Message(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageName() {
        return messageName;
    }
}
