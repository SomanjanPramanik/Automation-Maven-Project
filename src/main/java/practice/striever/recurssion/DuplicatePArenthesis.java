package practice.striever.recurssion;

import java.util.HashMap;
import java.util.Stack;

public class DuplicatePArenthesis {

	public static boolean check(String s) {
		
		HashMap<Character, Character> seen = new HashMap<>();
		
		seen.put(')', '(');
		
		seen.put('}', '{');
		
		seen.put(']', '[');
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			
			int count = 0;
			
			if (seen.containsKey(c)) {
			
				while (!stack.isEmpty() && stack.peek() != seen.get(c)) {
					
					count++;
					
					stack.pop();
				
				}
				
				if(!stack.isEmpty()) {
				
					stack.pop();
					
				}
				
				if (count < 1) {
					return true;
				}
			} 
			else {
				
				stack.push(c);
			
			}
		
		}
		
		return false;

	}

	public static void main(String[] args) {
		String[] testCases = {
			"((a+b))",          // 1. True  (Duplicate outer brackets)
			"(a+(b+c))",        // 2. False (Valid nested, NO duplicate)
			"((a+b)+((c+d)))",  // 3. True  (Duplicate around (c+d))
			"((a+b)+(c+d))",    // 4. False (Valid independent pairs)
			"(a+b)",            // 5. False (Normal valid)
			"()",               // 6. True  (Empty duplicate/redundant)
			"(((a)))"           // 7. True  (Multiple duplicates)
		};

		boolean[] expected = { true, false, true, false, false, true, true };

		System.out.println("--- DUPLICATE PARENTHESES TEST ---");
		for (int i = 0; i < testCases.length; i++) {
			boolean result = check(testCases[i]);
			boolean passed = (result == expected[i]);
			System.out.println("Test " + (i + 1) + ": " + testCases[i] 
					+ " -> Output: " + result 
					+ " | Expected: " + expected[i] 
					+ " [" + (passed ? "PASSED" : "FAILED") + "]");
		}
	}

}
