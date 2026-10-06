package practice.striever.recurssion;
import java.util.*;
import java.util.LinkedList;

public class QueueReverse {
	
	public static Queue<Integer> reverse(Queue<Integer> q) {
		if (q == null || q.isEmpty()) return q;
		Stack<Integer> stack = new Stack<>();
		while(!q.isEmpty()) {
			stack.push(q.remove());
		}
		while(!stack.isEmpty()) {
			q.add(stack.pop());
		}
		return q;
	}
	
	public static char firstNonRepeatedChar(String s) {
		if(s == null || s.length() == 0) {
			return '!';
		}
		
		Queue<Character> q = new LinkedList<>();
		int[] freq = new int[26];
		
		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			freq[c - 'a']++;
			q.add(c);
			while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
				q.remove();
			}
		}
		return q.isEmpty() ? '!' : q.peek();
	}
	
	public static int countDuplicateNums(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		int count = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			int index = Math.abs(arr[i]) - 1;
			if(index < arr.length) {
				if(arr[index] < 0) {
					count++;
				} else {
					arr[index] = -arr[index];
				}
			}
		}
		return count;
	}
	
	public static int countRepeatingNumber(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = arr[i] - 1;
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			int index = arr[i] % arr.length;
			arr[index] += arr.length;
		}
		int count = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			int freq = arr[i] / arr.length;
			if(freq > 1) {
				count++;
			}
		}
		return count;
	}
	
	public static int lastRepeatingNumber(int[] arr) {
		if (arr == null || arr.length < 2) return -1;
		HashMap<Integer, Integer> seen = new HashMap<>();
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			seen.put(arr[i], seen.getOrDefault(arr[i], 0) + 1);
		}
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			if(seen.get(arr[i]) > 1) {
				return arr[i];
			}
		}
		return -1;
	}
	
	public static int firstRepeatingNumber(int[] arr) {
		if (arr == null || arr.length < 2) return -1;
		HashMap<Integer, Integer> seen = new HashMap<>();
		for(int i = 0 ; i < arr.length ; i++) {
			seen.put(arr[i], seen.getOrDefault(arr[i], 0) + 1);
		}
		for(int i = 0 ; i < arr.length ; i++) {
			if(seen.get(arr[i]) > 1) {
				return arr[i];
			}
		}
		return -1;
	}
	
	public static int nonRepeatingFirstStreamNo(int[] arr) {
		if(arr == null || arr.length < 1) {
			return -1;
		}
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> freq = new HashMap<>();
		for(int i = 0 ; i < arr.length ; i++) {
			q.add(arr[i]);
			freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
			while(!q.isEmpty() && freq.get(q.peek()) > 1) {
				q.remove();
			}
		}
		return q.isEmpty() ? -1 : q.peek();
	}
	
	public static int[] prevGreatestElementIndex(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0];
		
		Stack<Integer> stack = new Stack<>();
		int[] newArr = new  int[arr.length];
		for(int i = 0 ; i < arr.length ; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				newArr[i] = -1;
			} else {
				newArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return newArr;
	}
	
	public static int[] nextGreatestElementIndex(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0];
		
		Stack<Integer> stack = new Stack<>();
		int[] newArr = new  int[arr.length];
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				newArr[i] = arr.length;
			} else {
				newArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return newArr;
	}
	
	public static int[] nextSmallestElementIndex(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0];
		
		Stack<Integer> stack = new Stack<>();
		int[] newArr = new  int[arr.length];
		for(int i = arr.length - 1 ; i >= 0 ; i--) {
			while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				newArr[i] = arr.length;
			} else {
				newArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return newArr;
	}

	public static int[] prevSmallestElementIndex(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0];
		
		Stack<Integer> stack = new Stack<>();
		int[] newArr = new  int[arr.length];
		for(int i = 0 ; i < arr.length ; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				newArr[i] = -1;
			} else {
				newArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return newArr;
	}
	
	public static int[] nextBiggestElement(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0];
		
		int[] newArr = new  int[arr.length];
		newArr[arr.length -1] = arr.length -1;
		for(int i = arr.length - 2 ; i>=0 ; i--) {
			if(arr[i] > arr[newArr[i+1]]) {
				newArr[i] = i;
			}
			else {
				newArr[i] = newArr[i+1];
			}
		}
		
		return newArr;
	}
	
	public static int[] prevBiggestElement(int[] arr) {
		if (arr == null || arr.length == 0) return new int[0];
		
		int[] newArr = new  int[arr.length];
		newArr[0] = 0;
		for(int i = 1 ; i < arr.length ; i++) {
			if (arr[i] > arr[newArr[i - 1]]) {
				newArr[i] = i; // নতুন বড় পেলে তার ইনডেক্স i
	        } else {
	        	newArr[i] = newArr[i - 1]; // আগের ম্যাক্সিমামের ইনডেক্সটাই ক্যারি কর
	        }		}
		
		return newArr;
	}


	public static void main(String[] args) {
		System.out.println("==================================================");
		System.out.println("          DSA QUEUE & STACK SUITE TESTS           ");
		System.out.println("==================================================");

		// 1. REVERSE QUEUE
		System.out.println("\n[1] REVERSE QUEUE");
		Queue<Integer> q = new LinkedList<>(Arrays.asList(10, 20, 30, 40));
		System.out.println("Original Queue  : [10, 20, 30, 40]");
		System.out.println("Reversed Queue  : " + reverse(q));
		System.out.println("Empty Queue Test: " + reverse(new LinkedList<>()));

		// 2. FIRST NON-REPEATING CHAR (STREAM)
		System.out.println("\n[2] FIRST NON-REPEATING CHAR");
		System.out.println("Stream 'abcxyzabc' -> Ans: " + firstNonRepeatedChar("abcxyzabc")); // Output: x
		System.out.println("Stream 'aabbcc'    -> Ans: " + firstNonRepeatedChar("aabbcc"));    // Output: !
		System.out.println("Stream 'z'         -> Ans: " + firstNonRepeatedChar("z"));         // Output: z
		System.out.println("Empty Stream ''    -> Ans: " + firstNonRepeatedChar(""));          // Output: !

		// 3. COUNT DUPLICATES (NEGATIVE INDEX MARKING)
		System.out.println("\n[3] DUPLICATE COUNT (NEGATIVE MARKING)");
		int[] dupArr = {1, 2, 3, 2, 1};
		System.out.println("Array [1, 2, 3, 2, 1] Count: " + countDuplicateNums(dupArr)); // Output: 2
		System.out.println("Empty Array [] Count       : " + countDuplicateNums(new int[] {})); // Output: 0

		// 4. COUNT REPEATING (MODULO MATH)
		System.out.println("\n[4] COUNT REPEATING (MODULO ARITHMETIC)");
		int[] multiDup = {1, 2, 3, 1, 1, 1, 2, 2, 3};
		System.out.println("Array [1, 2, 3, 1, 1, 1, 2, 2, 3] Count: " + countRepeatingNumber(multiDup)); // Output: 3
		System.out.println("Distinct Array [1, 2, 3, 4] Count       : " + countRepeatingNumber(new int[] {1, 2, 3, 4})); // Output: 0

		// 5. FIRST & LAST REPEATING NUMBER
		System.out.println("\n[5] FIRST & LAST REPEATING NUMBERS");
		int[] repArr = {1, 5, 3, 4, 5, 3, 6}; // 5 appears at idx 1, 3 appears at idx 2
		System.out.println("Array: " + Arrays.toString(repArr));
		System.out.println("First Repeating (Earliest 1st Appearance): " + firstRepeatingNumber(repArr)); // Output: 5
		System.out.println("Last Repeating (Latest Appearance)      : " + lastRepeatingNumber(repArr));  // Output: 3
		System.out.println("No Repeats [1, 2, 3]                    : " + firstRepeatingNumber(new int[] {1, 2, 3})); // Output: -1

		// 6. STREAM FIRST NON-REPEATING INT
		System.out.println("\n[6] STREAM FIRST NON-REPEATING NUMBER");
		System.out.println("Stream [1, 2, 3, 2, 1] -> Ans: " + nonRepeatingFirstStreamNo(new int[] {1, 2, 3, 2, 1})); // Output: 3
		System.out.println("Stream [7, 7, 7]       -> Ans: " + nonRepeatingFirstStreamNo(new int[] {7, 7, 7}));       // Output: -1
		System.out.println("Empty Stream []        -> Ans: " + nonRepeatingFirstStreamNo(new int[] {}));             // Output: -1

		// 7. MONOTONIC STACK INDICES (HISTOGRAM / BOUNDARY UTILITY)
		System.out.println("\n[7] MONOTONIC STACK (PREV/NEXT BOUNDARY INDICES)");
		int[] heights = {2, 1, 5, 6, 2, 3};
		System.out.println("Heights Array: " + Arrays.toString(heights));
		System.out.println("Prev Smallest Index (Boundary -1) : " + Arrays.toString(prevSmallestElementIndex(heights))); 
		// Output: [-1, -1, 1, 2, 1, 4]
		System.out.println("Next Smallest Index (Boundary  6) : " + Arrays.toString(nextSmallestElementIndex(heights))); 
		// Output: [1, 6, 4, 4, 6, 6]
		System.out.println("Prev Greatest Index (Boundary -1) : " + Arrays.toString(prevGreatestElementIndex(heights))); 
		// Output: [-1, 0, -1, -1, 3, 3]
		System.out.println("Next Greatest Index (Boundary  6) : " + Arrays.toString(nextGreatestElementIndex(heights))); 
		// Output: [2, 2, 3, 6, 5, 6]

		// 8. PREFIX & SUFFIX MAX INDICES (TRAIN WATER / RUNNING MAXIMUM)
		System.out.println("\n[8] PREFIX & SUFFIX MAX INDICES");
		int[] rain = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println("Elevation Array : " + Arrays.toString(rain));
		System.out.println("Prefix Max Index: " + Arrays.toString(prevBiggestElement(rain)));
		System.out.println("Suffix Max Index: " + Arrays.toString(nextBiggestElement(rain)));

	}
}