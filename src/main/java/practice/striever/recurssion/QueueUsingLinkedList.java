package practice.striever.recurssion;

public class QueueUsingLinkedList {
	
	public static class Node {
		Node next;
		int data;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
	
	public static class Queue {
		Node head;
		Node tail;
		int size;
		
		// isEmpty
		public boolean isEmpty() {
			return (head == null && tail == null);
		}
		
		// add
		public void enqueue(int data) {
			Node newNode = new Node(data);
			size++;
			if(this.isEmpty()) {
				head = newNode;
				tail = newNode;
				return;
			}
			
			tail.next = newNode;
			tail = tail.next;
			
		}
		
		// remove 
		public int dequeue() {
			if(this.isEmpty()) {
				System.out.println("WARNING : Queue is Empty");
				return -1;
			}
			int data = head.data;
			size--;
			if(head == tail) {
				head = tail = null;
			}
			else {
				head = head.next;
			}
			return data;
		}
		
		// peek
		public int peek() {
			if(this.isEmpty()) {
				System.out.println("WARNING : Queue is Empty");
				return -1;
			}
			return head.data;
		}
		
		// size
		public int size() {
			return this.size;
		}
		
		// display
		public void display() {
			if(this.isEmpty()) {
				System.out.println("WARNING : Queue is Empty");
				return;
			}
			Node temp = head;
			System.out.print("Queue : head --> ");
			while(temp!=null) {
				System.out.print("[ "+temp.data+" ] ---> ");
				temp = temp.next;
			}
			System.out.println(" null");
		}
		
		// getMin
		public int getMin() {
			if(this.isEmpty()) {
				System.out.println("WARNING : Queue is Empty");
				return -1;
			}
			int min = Integer.MAX_VALUE;
			Node temp = head;
			while(temp!=null) {
				min = Math.min(min, temp.data);
				temp = temp.next;
			}
			return min;
		}

	}


	public static void main(String[] args) {
		Queue q = new Queue();

		// 1. Khali queue-te check (Underflow test)
		System.out.println("--- TEST 1: EMPTY QUEUE OPERATIONS ---");
		System.out.println("isEmpty: " + q.isEmpty());
		System.out.println("Dequeue: " + q.dequeue());
		System.out.println("Peek: " + q.peek());
		System.out.println("Min: " + q.getMin());
		q.display();

		// 2. Elements enqueue kora
		System.out.println("\n--- TEST 2: ENQUEUE & MIN TRACKING ---");
		q.enqueue(25);
		q.enqueue(10);
		q.enqueue(40);
		q.enqueue(5);
		q.display(); // [ 25 ] ---> [ 10 ] ---> [ 40 ] ---> [ 5 ] ---> null
		System.out.println("Size: " + q.size());
		System.out.println("Peek (Front element): " + q.peek()); // 25
		System.out.println("Min: " + q.getMin()); // 5

		// 3. Dequeue operations
		System.out.println("\n--- TEST 3: DEQUEUE OPERATIONS ---");
		System.out.println("Dequeued: " + q.dequeue()); // 25 beriye gelo
		System.out.println("Dequeued: " + q.dequeue()); // 10 beriye gelo
		q.display(); // [ 40 ] ---> [ 5 ] ---> null
		System.out.println("Peek after dequeue: " + q.peek()); // 40
		System.out.println("Min after dequeue: " + q.getMin()); // 5
		System.out.println("Current Size: " + q.size()); // 2

		// 4. Puro queue khali kora (head == tail boundary reset test)
		System.out.println("\n--- TEST 4: DRAINING TO FULL RESET ---");
		System.out.println("Dequeued: " + q.dequeue()); // 40 beriye gelo
		System.out.println("Dequeued: " + q.dequeue()); // 5 beriye gelo (head ar tail reset to null)
		q.display();
		System.out.println("isEmpty after complete drain: " + q.isEmpty()); // true

		// 5. Reset-er por abar notun data enqueue kora
		System.out.println("\n--- TEST 5: RE-ENQUEUE AFTER RESET ---");
		q.enqueue(99);
		q.enqueue(11);
		q.display(); // [ 99 ] ---> [ 11 ] ---> null
		System.out.println("Peek: " + q.peek()); // 99
		System.out.println("Min: " + q.getMin()); // 11
		System.out.println("Final Size: " + q.size()); // 2
	}

}
