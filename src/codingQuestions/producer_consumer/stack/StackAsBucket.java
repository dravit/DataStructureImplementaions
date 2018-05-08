package codingQuestions.producer_consumer.stack;

/**
 * Created by dravi on 06-05-2018.
 */
public class StackAsBucket {

    int arr[];
    int size;
    volatile int top = -1;

    public StackAsBucket(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public void push(int i) {
        try {
            top++;
            System.out.println("Item "+ i + " added at top : " + top);
            arr[top] = i;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void pop() {
        try {
            int poppedItem = arr[top];
            System.out.println("Item " + poppedItem + " Popped from top : " + top);
            top--;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isFull() {
        return (top == (size - 1));
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
