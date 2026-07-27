package com.creatio.crm.language.basics;

public class FunctionalInterfaceImplement {

	public static void main(String[] args) {
		/**
		 * Create a functional interface MathOperation with 
		 * method operate(int a, int b). Implement it using lambda for: add, subtract, multiply, divide. Call all
		 * 4 and print results.
		 */
		
		MathOperation add = (a,b)-> System.out.println(a + b); 
		MathOperation sub = (a,b)-> System.out.println(a - b);
		MathOperation mul = (a,b)-> System.out.println(a * b);
		add.operate( 1, 2 );
		sub.operate( 1, 2 );
		mul.operate( 2, 3 );
		try {
			MathOperation div = (a,b)-> System.out.println(a / b);
			div.operate(1, 0 );
		}catch(Exception e) {
			System.err.println("!!!ERROR!!! : "+e);
		}
		
		

	}

}
