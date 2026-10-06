package practice.striever.recurssion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StreamRjonneFirstLastNonRepeating {

	// first bolle queue

	// last bolle stack

	// r stream na bolle pati freq Array mere check

	// first non repeating
	public char FirstNonRepeatingCharacter(String s) {
		char firstNonRepeat = ' ';

		// freq array r queue ek sathe check marbo

		int[] freq = new int[26]; // 0 - 25 letter
		Queue<Character> q = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freq[c - 'a']++;
			q.add(c);
			while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
				q.remove();
			}
			if (q.isEmpty()) {
				firstNonRepeat = '!';
			} else {
				firstNonRepeat = q.peek();
			}
		}

		return firstNonRepeat;
	}

	// last non repeating
	public char LastNonRepeatingCharacter(String s) {
		char lastNonRepeat = ' ';

		// freq array r queue ek sathe check marbo

		int[] freq = new int[26]; // 0 - 25 letter
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freq[c - 'a']++;
			stack.push(c);
			while (!stack.isEmpty() && freq[stack.peek() - 'a'] > 1) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				lastNonRepeat = '!';
			} else {
				lastNonRepeat = stack.peek();
			}
		}

		return lastNonRepeat;
	}

	public static void main(String[] args) {
		StreamRjonneFirstLastNonRepeating obj = new StreamRjonneFirstLastNonRepeating();
		System.out.println(obj.FirstNonRepeatingCharacter("aabccxyzb")); // Output: x
		System.out.println(obj.LastNonRepeatingCharacter("aabccxyzb")); // Output: z
	}

}
