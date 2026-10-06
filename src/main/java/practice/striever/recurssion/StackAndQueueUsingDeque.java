package practice.striever.recurssion;

import java.util.*;

public class StackAndQueueUsingDeque {

    // ================= STACK USING DEQUE (LIFO) =================
    public static class Stack {
        private Deque<Integer> dq = new LinkedList<>();

       
        public void push(int data) {
            dq.addLast(data);
        }

        
        public int pop() {
            if (dq.isEmpty()) return -1;
            return dq.removeLast();
        }

        
        public int peek() {
            if (dq.isEmpty()) return -1;
            return dq.getLast();
        }

        public boolean isEmpty() {
            return dq.isEmpty();
        }

        public void display() {
            if (dq.isEmpty()) {
                System.out.println("Stack is Empty");
                return;
            }
            System.out.println(dq + " <-- TOP");
        }
    }

    // ================= QUEUE USING DEQUE (FIFO) =================
    public static class Queue {
        private Deque<Integer> dq = new LinkedList<>();

        
        public void add(int data) {
            dq.addLast(data);
        }

        
        public int remove() {
            if (dq.isEmpty()) return -1;
            return dq.removeFirst();
        }

      
        public int peek() {
            if (dq.isEmpty()) return -1;
            return dq.getFirst();
        }

        public boolean isEmpty() {
            return dq.isEmpty();
        }

        public void display() {
            if (dq.isEmpty()) {
                System.out.println("Queue is Empty");
                return;
            }
            System.out.println("FRONT --> " + dq + " <-- REAR");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- TESTING STACK ---");
        Stack stack = new Stack();
        stack.display();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.display();

        System.out.println("\n--- TESTING QUEUE ---");
        Queue queue = new Queue();
        queue.display();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.display();
        System.out.println("Peek: " + queue.peek());
        System.out.println("Removed: " + queue.remove());
        queue.display();
    }
}