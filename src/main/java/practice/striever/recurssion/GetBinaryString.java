package practice.striever.recurssion;

public class GetBinaryString {

	public static void main(String[] args) {
		printBinaryStringNo11(2);
		System.out.println();
		printBinaryStringNo00(2);
		System.out.println();
		printBinaryString(2);
	}
	public static void printBinaryStringNo11(int n) {
		String s ="";
		int index = 0;
		helper1(n , index, s);
	}
	
	public static void printBinaryStringNo00(int n) {
		String s ="";
		int index = 0;
		helper0(n , index, s);
	}
	
	public static void printBinaryString(int n) {
		String s ="";
		int index = 0;
		helper(n , index, s);
	}
	
	public static void helper1(int n, int index, String s) {
		
		//base
		if(index >= n) {
			
			System.out.println(s);
			return;
		}
		
		helper1(n , index+1 , s+"0");
		
		if (s.isEmpty() || s.charAt(index - 1) != '1') {
			helper1(n , index+1 , s+"1");
		}
	}
	
	public static void helper0(int n , int index , String s) {
		
		//base
		if(index == n) {
			System.out.println(s);
			return;
		}
		
		helper0(n , index+1 , s+"1");

		if(s.isEmpty() || s.charAt(index -1) != '0') {
			helper0(n , index+1 , s+"0");
		}
		
	}	

	public static void helper(int n , int index , String s) {
		
		//base
		if(index == n) {
			System.out.println(s);
			return;
		}
		
		helper(n , index+1 , s+"0");

		helper(n , index+1 , s+"1");
		
	}
	
}
