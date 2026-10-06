package practice.striever.recurssion;

import java.util.*;

public class MyLinkedList {

	private static class Node {
		int data;
		Node next = null;

		public Node(int data) {

			this.data = data;

		}
	}

	int size;

	Node head;

	Node tail;

	public void addElement(int data) {

		Node newNode = new Node(data);

		size++;

		if (tail == null) {
			head = tail = newNode;
			return;
		}

		tail.next = newNode;
		tail = newNode;

	}

	public int removeElement() {

		if (head == null) {
			System.out.println("Empty List ; nothing to delete");
			return Integer.MIN_VALUE;
		}

		if (head == tail) {
			size--;
			int data = head.data;
			tail = null;
			head = null;
			return data;
		}

		Node temp = head;

		while (temp.next != tail) {
			temp = temp.next;
		}

		int data = tail.data;
		tail = temp;
		temp.next = null;
		size--;
		return data;

	}

	public void reverseList() {

		if (head == null || head == tail) {
			System.out.println("Either 1 element or zero elemnt exists in the list");
		}

		Node prev = null;
		Node curr = head;
		tail = head;
		Node next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
	}

	public int indexOf(int data) {

		if (head == null) {
			return -1;
		}
		Node temp = head;
		return searchData(data, 0, temp);

	}

	private int searchData(int data, int i, Node temp) {
		// baseCase
		if (temp == null) {
			return -1;
		}

		if (temp.data == data) {
			return i;
		}

		return searchData(data, i + 1, temp.next);
	}

	public void printList() {
		if (head == null) {
	        System.out.println("Empty list");
	        return;
	    }
		
		HashMap<Node, Integer> seen = new HashMap<>();
		Node temp = head;
		int i = 1;
		while(temp!=null) {
			
			if(seen.containsKey(temp)) {
				int repeatNodeindex = seen.get(temp);
				System.out.print("[ node: "+repeatNodeindex+" | value: "+temp.data+" (repeated!!!)]");
				System.out.println();
				return;
			}
			else {
				seen.put(temp , i);
				System.out.print("[ node: "+i+" | value: "+temp.data+" ]->");
				temp = temp.next;
				i++;
			}
			
		}
		System.out.println("null");
	
	}
	

	public int removeElementFromLastN(int n) {

		if (head == null) {
			return -1;
		}
		if (head == tail) {
			System.err.println("Only one element here ; deleting it!!!");
			int data = head.data;
			head = tail = null;
			size--;
			return data;
		}

		if (size < n) {
			return -1;
		}

		size--;
		Node fast = head;
		Node slow = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			Node deletedNode = head;
			int data = head.data;
			head = head.next;
			deletedNode.next = null;
			deletedNode = null;
			return data;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		Node deletedNode = slow.next;
		if (deletedNode == tail) {
			tail = slow;
		}
		slow.next = slow.next.next;
		int data = deletedNode.data;
		deletedNode.next = null;
		deletedNode = null;

		return data;

	}
	public void deleteList() {
	    head = null;
	    tail = null;
	    size = 0;
	}
	
	public void makeCircularToNthNodefromLast(int NthNode) {
		
		if (this.isCircular() == true) { 
	        System.out.println("list is already circular !!!");
	        return; 
	    }
		
		if(head== null || head==tail ) {
			System.out.println("Either 0  or 1 elemet exist in this node");
			return;
		}
		
		if(NthNode == 1) {
			System.out.println("for make list circular take 2 or more elements");
			return;
		}
		Node slow = head;
		Node fast = head;
		
		for(int i = 0 ; i < NthNode ; i++) {
			fast = fast.next;
		}
		
		if (NthNode > size || NthNode <= 0) {
	        System.out.println("Invalid N value");
	        return;
	    }
		
		if(NthNode == size) {
			
			tail.next = head;
			return;
		}
		
		while(fast!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		tail.next = slow;
		
	}
	
	private boolean isCircular() {
		
		if(head == null || head == tail) {
			System.out.println("Either 0 or 1 element exist in the list");
			return false;
		}
		
		Node slow = head;
		Node fast = head; 
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isPalindrome() {
		if(head == null || head == tail) {
			return true;
		}
		
		if(this.isCircular()) {
			return false;
		}
			Node slow = head;
			Node fast = head;
			while(fast != null && fast.next != null) {
		        fast = fast.next.next;
		        slow = slow.next;
		    }
			
			//slow half e thakbe r fast tail e 
			Node curr = slow;
			Node prev = null;
			Node next;
			while(curr!=null) {
				next = curr.next;
				curr.next = prev;
				
				prev = curr;
				curr = next; 
			}
			
			boolean isPalindrome = true;
			Node firstCopy = head;
			Node secondCopy = tail;
			while(secondCopy != null) { 
				if(firstCopy.data != secondCopy.data) {
					isPalindrome = false;
					break;
				}
				firstCopy = firstCopy.next;
				secondCopy = secondCopy.next;
			}
			
			curr = tail; 
			Node restorePrev = null;
			Node nextNode;

			while (curr != null) {
			    nextNode = curr.next;
			    curr.next = restorePrev;
			    restorePrev = curr;
			    curr = nextNode;
			}
			
		return isPalindrome;
	}
	
	public void removeLoop() {
		
		Node slow = head;
		Node fast = head;
		boolean isExist = false;
		while(fast != null && fast.next != null) {
			slow= slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				isExist = true;
				break;
			}
		}
		
		if(!isExist) {
			System.out.println("No loop exist in the list");
			return;
		}
		
		slow = head;
		
		if(slow == fast) {
			while(fast.next != slow) {
				fast = fast.next;
			}
			
			fast.next = null;
			return;
		}
		
		Node prev = null;
		while(slow != fast) {
			prev = fast;
			fast = fast.next;
			slow = slow.next;
		}
		prev.next = null;
	}
	
	public Node mergeSort(Node head) {
		//base : 1 element
		if(head == null || head.next == null) {
			return head;
		}
		
		Node mid = mid(head);
		Node rightHalf = mid.next;
		mid.next = null;
		
		Node leftside = mergeSort(head);
		Node rightside =mergeSort(rightHalf);
		return merge(leftside , rightside);
	}
	
	
	private Node merge(Node leftside, Node rightside) {
		Node temp = new Node(-1);
		Node i = leftside;
		Node j = rightside;
		Node k = temp;
		
		while(i != null && j != null) {
			
			if(i.data <= j.data) {
				k.next = i;
				k = k.next;
				i = i.next;
			} else {
				k.next = j;
				k = k.next;
				j = j.next;
			}
			
		}
		
		if(i!=null) {
			k.next = i;
		}
		else if(j!=null) {
			k.next = j;
		}
	
		return temp.next;
	}

	private Node mid(Node head) {
		Node slow = head;
		Node fast = head.next;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public void zigzag() {
		
		if(head == null || head.next == null || head.next.next == null) {
			System.out.println("Not enpugh element for make a zigzag");
			return;
		}
		
		// 1 find mid (1st half last node)
		
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		Node midnext = slow.next;
		
		slow.next = null;
		
		//2 reverse from tail to mid-1
		
		Node prev = null;
		Node curr = midnext;
		Node next;
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = next;
		}
		
		//3 zig zag
		
		Node lefthead = head;
		Node righthead = prev;
		Node nextLeft;
		Node nextRight; 
		
		while(lefthead != null && righthead != null) {
			nextLeft = lefthead.next;
			lefthead.next = righthead;
			nextRight = righthead.next;
			righthead.next = nextLeft;
			
			lefthead = nextLeft;
			righthead = nextRight;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList li = new MyLinkedList();
		li.addElement(9);
		li.printList();
		li.addElement(2);
		li.printList();
		li.addElement(7);
		li.printList();
		li.addElement(1);
		li.printList();
		System.out.println();
		li.head = li.mergeSort(li.head);
		li.printList();
		System.out.println();
		li.zigzag();
		li.printList();
	}

}
