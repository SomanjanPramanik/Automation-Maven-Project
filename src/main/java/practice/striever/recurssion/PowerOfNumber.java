package practice.striever.recurssion;

public class PowerOfNumber {

	public static void main(String[] args) {
			System.out.println(pow(2 , -2));
	}
	
	static double pow(double n , int pow) {
		
		if( pow < 0) {
			pow = -pow;
			n = 1/n;
		}
		
		//base
		if( pow == 0) {
			return 1;
		}
		else if(pow == 1) {
			return n;
		}
		
		double m = pow(n , pow/2);
				
		if(pow%2 == 0) {
			return m*m;
		}
		else {
			return n*m*m;
		}
	}

}
