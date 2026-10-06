package practice.striever.recurssion;

//Recursive Implementation of atoi()
//
//Problem Statement: Implement the function myAtoi(s) which converts the given string s to a 32-bit signed integer (similar to the C/C++ atoi function).
//
//Steps to Implement: 1. First, ignore any leading whitespace characters ' ' until the first non-whitespace character is found.
//2. Check the next character to determine the sign. If it’s a '-', the number should be negative. If it’s a '+', the number should be positive. If neither is found, assume the number is positive.
//3. Read the digits and convert them into a number. Stop reading once a non-digit character is encountered or the end of the string is reached. Leading zeros should be ignored during conversion.
//4. The result should be clamped within the 32-bit signed integer range: [-2147483648, 2147483647]. If the computed number is outside this range, return -2147483648 if the number is less than -2147483648, or return 2147483647 if the number is greater than 2147483647.
//5. Finally, return the computed number after applying all the above steps.
//
//Examples
//Example 1:
//Input:
// s = " -12345"  
//Output:
// -12345  
//Explanation:
//  
//Ignore leading whitespaces.  
//The sign '-' is encountered, indicating the number is negative.  
//Digits 12345 are read and converted to -12345.
//
//Example 2:
//Input:
// s = "4193 with words"  
//Output:
// 4193  
//Explanation:
//  
//Read the digits 4193 and stop when encountering the first non-digit character (w).

public class AtoiFunction {

	public static void main(String[] args) {
		System.out.println(myAtoi(" -12345 "));
	}

	static int myAtoi(String string) {
		
		// trim korbo
		String stringTrim = string.trim();
		int index = 0;
		//edge case 
		if(stringTrim.isEmpty()) {
			return 0;
		}
		
		int sign = 1;
		
		if(stringTrim.charAt(index) == '-') {
			sign = -1;
			index++;
		}
		else if(stringTrim.charAt(index) == '+') {
			index++;
		}
		
		return (int) helper(stringTrim , index , sign , 0);
	}

	static long helper(String string, int index, int sign, long result) {

		// Base :
		if (index >= string.length() || !Character.isDigit(string.charAt(index))) {

			return sign * result;

		}
		
		int digit = string.charAt(index) - '0';
		
		result = result*10 + digit;
		
		
		// jdi boro hoi

		if (sign == 1 && result > Integer.MAX_VALUE) {

			return Integer.MAX_VALUE;

		}
		
		//jdi choto hoi 
		
		if (sign == -1 && result > Integer.MAX_VALUE) {

			return Integer.MIN_VALUE;

		}

		return helper(string, index+1, sign, result);

	}

}
