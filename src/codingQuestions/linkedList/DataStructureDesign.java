package codingQuestions.linkedList;

/**
 * Created by guptdbh on 01/05/2018.
 */

/**
 * <b>Problem Statement : Design a data structure which can do following operations :</b>
 * <ul>
 *     <li>add() in O(n)</li>
 *     <li>getMinimum() in O(1)</li>
 *     <li>deleteMinimum() in O(1)</li>
 * </ul>
 * <h4>Solution : </h4>
 * <ul>
 *     <li>Maintain a linkedlist with elements in increasing order</li>
 *     <li>Move head to next position in case of delete Min operation</li>
 *     <li>Return First element in case of get Min Operation</li>
 * </ul>
 */
public class DataStructureDesign {

    Node start;

    public void addElement(int data) {
        Node newNode = new Node(data);
        if(start == null) {
            start = newNode;
            return;                         //Code will exit from here
        }
        if(data < start.data) {
            newNode.next = start;
            start = newNode;
            return;                         //Code will exit from here
        }
        Node prev = start;
        Node ptr = start.next;
        while(ptr != null) {
            if(data < ptr.data) {
                newNode.next = ptr;
                prev.next = newNode;
                return;                     //Code will exit from here
            } else {
                prev = ptr;
                ptr = ptr.next;
            }
        }
        prev.next = newNode;                //This will come only if the element will be highest in list.
    }

    public int deleteMinimum() {
        Node deletedNode = start;
        deletedNode.next = null;
        start = start.next;
        return deletedNode.data;
    }

    public int getMinimum() {
        return start.data;
    }

    @Override
    public String toString() {
        if(start != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(start.data);
            Node ptr = start.next;
            while(ptr != null) {
                sb.append(" --> ");
                sb.append(ptr.data);
                ptr = ptr.next;
            }
            return sb.toString();
        }
        return "Data Structure is Empty";
    }

    public static void main(String[] args) {
        DataStructureDesign dsd = new DataStructureDesign();
        dsd.addElement(1);
        dsd.addElement(4);
        dsd.addElement(3);
        dsd.addElement(2);
        dsd.addElement(1);
        dsd.addElement(3);
        dsd.addElement(5);
        dsd.addElement(1);
        dsd.addElement(2);
        dsd.addElement(3);
        System.out.println(dsd.toString());
        System.out.println(dsd.deleteMinimum());
        System.out.println(dsd.toString());
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
