package practice.striever.recurssion;
import java.util.logging.Logger;
public class QueueUsingArray {

	public static class CircularQueue {
		
		private static final Logger logger = Logger.getGlobal();
		
		int[] arr;
		int front;
		int rear;
		int size;

		public CircularQueue(int n) {
			this.arr = new int[n];
			this.front = -1;
			this.rear = -1;
			this.size = n;
		}

		// isEmpty
		public boolean isEmpty() {
			return (front == -1 && rear == -1);
		}

		// Add
		public void enqueue(int data) {
			if (this.isEmpty()) {
				front++;
				rear++;
				arr[rear] = data;
				return;
			}
			if (front == (rear + 1) % size) {
				logger.warning("WARNING : Queue is Full");
				return;
			}
			rear = (rear + 1) % size;
			arr[rear] = data;
		}

		// remove
		public int dequeue() {
			if (this.isEmpty()) {
				logger.warning("WARNING : Queue is Empty");
				return -1;
			} else {
				int data = arr[front];
				if (front == rear) {
					front = rear = -1;
				} else {
					front = (front + 1) % size;
				}

				return data;
			}
		}

		// peek
		public int peek() {
			if (this.isEmpty()) {
				logger.warning("WARNING : Queue is Empty");
				return -1;
			} else {
				return arr[front];
			}
		}

		// getMin
		public int getMin() {
			if (this.isEmpty()) {
				logger.warning("WARNING : Queue is Empty");
				return -1;
			}
			int min = Integer.MAX_VALUE;
			int i = front;
			while(true) {
				min = Math.min(min , arr[i]);
				if(i == rear) {
					break;
				}
				i = (i+1)%size;
			}
			return min;
		}

		// isFull
		public boolean isFull() {
			if (this.isEmpty()) {
				logger.warning("WARNING : Queue is Empty");
				return false;
			}
			return (front == (rear + 1) % size);
		}

		// display
		public void display() {
			if (this.isEmpty()) {
				logger.warning("WARNING : Queue is Empty");
				return;
			}
			System.out.print("[ Front ");
			int i = front;
			while(true) {
				System.out.print(" -> "+arr[i]);
				if(i == rear) {
					break;
				}
				i = (i+1)%size;
			}
			System.out.println(" <- Rear ]");
		}
	}

	public static void main(String[] args) {
		CircularQueue q = new CircularQueue(4);
		q.display(); // queue empty
		q.enqueue(15);
		q.enqueue(5);
		q.enqueue(25);
		q.display(); // [ Front  ->15 ->5 ->25 <- Rear ]
		System.out.println("Min: " + q.getMin()); // 5

		System.out.println("Dequeued: " + q.dequeue()); // 15 out
		q.enqueue(2);  // 0 নম্বর ইনডেক্সে র‍্যাপ করল
		q.enqueue(40); // কিউ ফুল
		q.enqueue(99); // warning display
		q.display();   // [ Front  ->5 ->25 ->2 ->40 <- Rear ]
		System.out.println("Min after wrap: " + q.getMin()); // 2
		System.out.println("isFull: " + q.isFull()); // true
	}

}
