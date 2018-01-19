package codingQuestions;

public class QueueImplementation {

    private int size;
    private int [] queueArray;
    private int totalItems;
    private int front;
    private int rear;

    public int getTotalItems() {
        return totalItems;
    }

    public int getFront() {
        return front;
    }

    public QueueImplementation(int size) {
        this.size = size;
        this.queueArray = new int[size];
        this.totalItems = 0;
        this.front = 0;
        this.rear = 0;
    }

    public void offer(int item) {
        totalItems++;
        queueArray[rear] = item;
        rear++;
    }

    public int poll() {
        int removedItem = queueArray[front];
        totalItems--;
        front++;
        return removedItem;
    }

    public int peek(){
        return peek(0);
    }

    public int peek(int index){
        return queueArray[front + index];
    }

    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation(10);
        queue.offer(10);
        queue.offer(9);
        queue.offer(8);
        queue.offer(7);
        queue.offer(6);
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);
        System.out.println("Total items in queue => " + queue.getTotalItems());
        System.out.println("Peeking 1 => "+ queue.peek());
        queue.poll();
        System.out.println("Total items in queue 2 => " + queue.getTotalItems());
        System.out.println("Peeking 2 => "+ queue.peek());
        System.out.println("Peeking 3 => "+ queue.peek(1));
    }
}
