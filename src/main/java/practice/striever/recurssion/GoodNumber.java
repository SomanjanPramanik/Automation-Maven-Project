package practice.striever.recurssion;

public class GoodNumber {
//	A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
//
//	For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
//	Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 10^9 + 7.
//
//	A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
//
//	 
//
//	Example 1:
//
//	Input: n = 1
//	Output: 5
//	Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
//	Example 2:
//
//	Input: n = 4
//	Output: 400
//	Example 3:
//
//	Input: n = 50
//	Output: 564908303
//	 
//
//	Constraints:
//
//	1 <= n <= 1015

	public static void main(String[] args) {
		System.out.println(getGoodNumber(50));
	}

	public static long getGoodNumber(int num) {
		
		int evenPosIndex = (num+1)/2;
		int oddPosIndex = num/2;
		
		return helper(num , evenPosIndex , oddPosIndex);
	
	}

	static long mod = 1_000_000_007L;

	private static long helper(long num, long evenPosIndex, long oddPosIndex) {
		long evenPow = pow(5 , evenPosIndex);
		long oddPow = pow(4 , oddPosIndex);
		return (evenPow * oddPow) % mod;
	}

	private static long pow(long base, long power) {
		if(power == 0) {
			return 1;
		}
		if(power == 1) {
			return base % mod;
		}
		
		long no = pow(base , power/2) % mod;
		long result = (no * no) % mod;
		
		if(power % 2 == 0) {
			return result;
		} else {
			return (base * result) % mod;
		}
	}
	

}
