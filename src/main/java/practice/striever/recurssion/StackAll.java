package practice.striever.recurssion;
import java.util.*;

public class StackAll {
	
	public static void sortStack(Stack<Integer> stack) {
		
		//base case
		if(stack.isEmpty()) {
			return;
		}
		
		int elementInHand = stack.pop();
		
		sortStack(stack);
		
		helperFunctionTomergeStack(stack , elementInHand);
		
	}
	
	private static void helperFunctionTomergeStack(Stack<Integer> stack, int elementInHand) {
		//base case
		if(stack.isEmpty() || elementInHand >= stack.peek()) {
			stack.push(elementInHand);
			return;
		}
		
		int takeOutTopElement = stack.pop();
		
		//Again try to add the inHandELement
		helperFunctionTomergeStack(stack, elementInHand);
		
		//After all trying at last add to stack at last
		stack.push(takeOutTopElement);
	}
	
	// Add element in last
	
	public static void pushLast(Stack<Integer> stack,int data) {
		
		//Base when empty then add
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		
		int elementInHand = stack.pop();
		
		pushLast(stack, data);
		
		stack.push(elementInHand);
		
	}
	
	//Reverse a String using stack
	public static String reverseString(String string) {
		Stack<Character> characters = new Stack<>();
		for(int i = 0 ; i < string.length(); i++) {
			characters.push(string.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!characters.isEmpty()) {
			
			sb.append(characters.pop());
			
		}
		
		return sb.toString();
		
	}
	
	// reverse a stack
	public static void reverseStack(Stack<Integer> stack) {
		
		//base
		if(stack.isEmpty()) {
			return;
		}
		
		int topElement = stack.pop();
		
		reverseStack(stack);
		
		pushTheCurrentToLast(stack ,topElement);
		
	}
	
	
	
	private static void pushTheCurrentToLast(Stack<Integer> stack, int topElement) {

		if(stack.isEmpty()) {
			stack.push(topElement);
			return;
		}
		
		int otherElement = stack.pop();
		
		pushTheCurrentToLast(stack, topElement);
	
		stack.push(otherElement);
	}
	
	//Next Greater Element
	public static int[] NGE(int[] arr) {
		int n = arr.length;
		int[] ngeStored = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		//bol6e next greater hole amake age dekhte hbe 
		
		for(int i = n-1 ; i>=0 ; i--) {
			while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			
			ngeStored[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		
		return ngeStored;
	}
	
	//Previous Greater Element
	public static int[] PGE(int[] arr) {
		int n = arr.length;
		int[] pgeStored = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		//bol6e prev greater hole amake pechone dekhte hbe 
		
		for(int i = 0 ; i< n ; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			
			pgeStored[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		
		return pgeStored;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(1);
        s.push(31);
        System.out.println(s);
        
        sortStack(s);
        
        System.out.println(s);
     
        pushLast(s, 36);
        
        System.out.println(s);
//        String sp = "sp369";
//        
//        System.out.println(reverseString(sp));
        
        reverseStack(s);
        
        System.out.println(s);
        
        int[] arr = {36, 1, 4, 1 , 31};
        
        System.out.println(Arrays.toString(NGE(arr)));
        
        System.out.println(Arrays.toString(PGE(arr)));
        
	}

}
