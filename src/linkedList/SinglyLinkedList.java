package linkedList;

/**
 * Singly Linked List implementation 
 * @author Dravit Gupta
 */
public class SinglyLinkedList {

	/**
	 * Starting node of the list.
	 */
	private Node head;
	private int size;
	
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
	
	public void addFirst(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
		} else {
			n.next = head;
			head = n;
		}
		size++;
	}
	
	public void addAtPosition(int data, int pos) {
		if(pos == -1 || pos > size+1)
			System.out.println("Target position is not valid !");
		
		if(pos == 1) {
			addFirst(data);
		} else if(pos == size+1) {
			addLast(data);
		} else {
			Node prevNode = head;
			int count = 1;
			while(count < pos-1) {
				prevNode = prevNode.next;
				count++;
			}
			Node n = new Node(data);
			n.next = prevNode.next;
			prevNode.next = n;
			size++;
		}
	}
	
	public void addLast(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
		} else {
			Node currentNode = head;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = n;
		}
		size++;
	}
	
	public void deleteFirst() {
		if(head == null)
			System.out.println("List is empty !");
		
		Node firstNode = head;
		head = head.next;
		firstNode = null;
		size--;
	}
	
	public void deleteAtPosition(int pos) {
		if(pos == -1 || pos > size)
			System.out.println("Target position is not valid !");
		
		if(pos == 1) {
			deleteFirst();
		} else if(pos == size) {
			deleteLast();
		} else {
			Node prevNode = head;
			int count = 1;
			while(count < pos-1) {
				prevNode = prevNode.next;
				count++;
			}
			Node deleteNode = prevNode.next;
			prevNode.next = deleteNode.next;
			deleteNode = null;
			size--;
		}
	}

	public void deleteLast() {
		if(head == null)
			System.out.println("List is empty !");
		
		Node currentNode = head;
		while(currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
		size--;
	}
	
	public int findNthFromLast(int nthNode) {
		if(nthNode == -1 || !(size-nthNode > 0))
			throw new IllegalArgumentException("Invalid nth node.");
		
		int reqNode = size-nthNode;
		int count = 1;
		Node currenNode = head;
		while(count++ < reqNode) {
			currenNode = currenNode.next;
		}
		return currenNode.data;
	}
	
	public void insertInSortedList(int data) {
		if(head == null)
			addFirst(data);
		
		Node n = new Node(data);
		Node NextNode = head;
		Node currentNode = head;
		while(NextNode.next != null && NextNode.data < data) {
			currentNode = NextNode;
			NextNode = NextNode.next;
		}
		n.next = NextNode;
		currentNode.next = n;
	}
	
	public int countNodes() {
		if(head == null)
			return 0;
		
		int count = 1;
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
			count++;
		}
		
		return count;
	}

	/**
	 * Swap nodes without swaping values of those nodes.
	 * @param data1
	 * @param data2
	 */
	public void swapNodes(int data1, int data2) {
		if(head == null || size == 1) {
			System.out.println("List is empty or only one node present!!");
			return;
		}
		Node node1 = null;
		Node node1Prev = null;
		Node node2 = null;
		Node node2Prev = null;
		Node start = head;
		if(start.data == data1) {
			node1Prev = null;
			node1 = start;
		}
		if(start.data == data2) {
			node2Prev = null;
			node2 = start;
		}
		while(start.next != null) {
			if(start.next.data == data1) {
				node1Prev = start;
				node1 = start.next;
			}
			if(start.next.data == data2) {
				node2Prev = start;
				node2 = start.next;
			}
			start = start.next;
		}

		if(node1 != null && node2 != null) {
			if(node1Prev == null) {
				head = node2;
			}
			if(node2Prev == null) {
				head = node1;
			}
			Node tempNext = node2.next;
			if(node1Prev != null)
				node1Prev.next = node2;
			node2.next = node1.next;

			if(node2Prev != null)
				node2Prev.next = node1;
			node1.next = tempNext;
		}
	}

	public int getMiddleNode() {
		if(head == null) {
			System.out.println("List is empty!!");
			return 0;
		}
		if(size == 1) {
			return head.data;
		}

		int middle = Math.floorDiv(size, 2) + 1;
		int count = 1;
		Node start = head;
		while(count++ < middle) {
			start = start.next;
		}
		return start.data;
	}

	public void reverseList() {
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current.next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if(head == null)
			return "[]";
		
		StringBuilder list = new StringBuilder();
		list.append("[").append(head.data);
		Node temp = head;
		while(temp.next != null) {
			list.append(" -> ").append(temp.next.data);
			temp = temp.next;
		}
		list.append("]");
		return list.toString();
	}
	
	private static final class Node {
		private int data;
		private Node next;
		
		private Node(int data) {
			this.data = data;
			next = null;
		}
	}
}
