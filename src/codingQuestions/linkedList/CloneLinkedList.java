package codingQuestions.linkedList;

/**
 * Created by guptdbh on 10/04/2018.
 */
/**
 * <b>Problem Statement : Clone a linked list with next and random pointer.</b>
 * <br />
 * <p>Below algo will provide solution in O(2N) ~ O(N) of time complexity and O(n) space</p>
 * <b>Solution Steps : </b>
 * <h4>First Iteration on original nodes</h4>
 * <ul>
 *      <li>Create copy of every node(e.g 1 --> 1xx)</li>
 *      <li>Change original node next (1 -- next --> 2) to new node (1 -- next --> 1xx)</li>
 *      <li>New node's next to original node's next (1xx -- next --> 2)</li>
 * </ul>
 * <h4>Second Iteration on original nodes</h4>
 * <ul>
 *      <li>Find original node's random (1 -- random --> 3)</li>
 *      <li>Assign copied node random to original node's random next (1xx -- random --> 3.next(3xx))</li>
 *      <li>Change next pointer of new node to next.next (1xx -- next --> 2.next(2xx))</li>
 * </ul>
 */
public class CloneLinkedList {

    private static class Node {
        Node(String data) {
            this.data = data;
        }
        private String data;
        private Node next;
        private Node random;
    }

    private static void cloneList(Node head) {
        if(head == null) {
            System.out.println("Head Not present");
            return;
        }

        //Insert a copy node in between
        Node currentNode = head;
        while(currentNode != null) {
            Node currentNodeNext = currentNode.next;
            Node clonedNode = new Node(currentNode.data+"XX");
            clonedNode.next = currentNodeNext;
            currentNode.next = clonedNode;
            currentNode = currentNodeNext;
        }

        //Clone random pointers
        currentNode = head;
        Node newHead = currentNode.next;
        while(currentNode != null) {
            Node randomNode = currentNode.random;
            Node nextPointer = currentNode.next.next;
            currentNode.next.random = randomNode.next;
            if(currentNode.next.next == null) {
                currentNode.next.next = null;
            } else {
                currentNode.next.next = currentNode.next.next.next;
            }

            currentNode = nextPointer;
        }
        printList(newHead);
    }

    public static void main(String[] args) {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");
        Node node8 = new Node("8");
        Node node9 = new Node("9");
        node1.next = node2;
        node1.random = node3;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.next = node6;
        node5.random = node2;
        node6.next = node7;
        node6.random = node8;
        node7.next = node8;
        node7.random = node9;
        node8.next = node9;
        node8.random = node1;
        node9.next = null;
        node9.random = node5;

        printList(node1);
        cloneList(node1);
    }

    private static void printList(Node head) {
        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.data + "(" + currentNode.random.data + ")" + " ---> ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
