package practice.striever.recurssion;
import java.util.*;
public class ParenthesisCheck {

	public static void main(String[] args) {
			String[] testCases = {
				"()[]{}",       // 1. Standard Valid (Sequential) -> Expected: true
				"{[()]}",       // 2. Standard Valid (Nested) -> Expected: true
				"(([]){})",     // 3. Complex Nested Valid -> Expected: true
				"(",            // 4. Single Opening (Odd length) -> Expected: false
				")",            // 5. Single Closing (Odd length) -> Expected: false
				"))",           // 6. Only Closing Brackets -> Expected: false
				"((",           // 7. Only Opening Brackets -> Expected: false
				")(",           // 8. Even length, but start closing -> Expected: false
				"(]",           // 9. Wrong Match -> Expected: false
				"([)]",         // 10. Interleaved / Wrong Order -> Expected: false
				"())(",         // 11. Premature close then open -> Expected: false
				"{{{{}}}}"      // 12. Deeply Nested Valid -> Expected: true
			};

			boolean[] expected = {
				true, true, true, false, false, false, false, false, false, false, false, true
			};

			System.out.println("--- RUNNING TEST CASES ---");
			for (int i = 0; i < testCases.length; i++) {
				boolean result = check(testCases[i]);
				boolean passed = (result == expected[i]);
				System.out.println("Test " + (i + 1) + ": \"" + testCases[i] + "\" -> Output: " + result 
						+ " | Expected: " + expected[i] 
						+ " [" + (passed ? "PASSED" : "FAILED") + "]");
			
		}	

	}
	public static boolean check(String s) {
		
		if (s.length() % 2 != 0) {
		    return false;
		}
		
		HashMap<Character , Character> seen = new HashMap<>();
		seen.put(')', '(');
		seen.put('}', '{');
		seen.put(']', '[');
		Stack<Character> stack = new Stack<>();
		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			if(seen.containsKey(c)) {
				if(stack.isEmpty() || !stack.peek().equals(seen.get(c))) {
					return false;
				}else {
					stack.pop();
				}
			}else {
				stack.push(c);
			}
		}
		
		return stack.isEmpty();
	}
	

}
