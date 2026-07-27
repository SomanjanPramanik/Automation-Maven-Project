package com.creatio.crm.language.basics;

public class MethodAssignmentCalculatorClaude {
	public static void main(String[] args) {
//		Assignment 1 — Methods Basic
//		Create a class Calculator with these methods:
//
//		add(int a, int b) → returns sum
//		subtract(int a, int b) → returns difference
//		multiply(int a, int b) → returns product
//		divide(int a, int b) → returns result (handle division by zero!)
//		power(int base, int exp) → returns base^exp
//
//		Call all methods in main and print results.
		MethodAssignmentCalculatorClaude obj = new MethodAssignmentCalculatorClaude();
		System.out.println(obj.add(6,9));
		System.out.println(obj.subtract(6,9));
		System.out.println(obj.divide(6,0));
		System.out.println(obj.divide(6,2));
		System.out.println(obj.divide(6,4));
		System.out.println(obj.multiply(6,9));
		System.out.println(obj.power(6,0));
		System.out.println(obj.power(2,2));
	}
//	add(int a, int b) → returns sum
	int add(int a, int b) {
		System.out.printf("Addition of %d and %d : ",a,b);
		return (a+b);
	}
//	subtract(int a, int b) → returns difference
	int subtract(int a, int b) {
		System.out.printf("Substraction of %d and %d : ",a,b);
		return (a-b);
	}
//	multiply(int a, int b) → returns product
	int multiply(int a, int b) {
		System.out.printf("Multiplication of %d and %d : ",a,b);
		return (a*b);
	}
//	divide(int a, int b) → returns result (handle division by zero!)
	int divide(int a, int b) {
		if (b==0) {
			System.err.println("!!!!!!!!! Numbers can't be divided by 0 !!!!!!!!!");
			return 0;
		}
		else {
			if(a%b!=0) {
				System.out.println("Remainder:"+(a%b));
				System.out.printf("Division of %d and %d : ",a,b);
			}
			else {
				System.out.printf("Division of %d and %d : ",a,b);
			}
			return (a/b);
		}
		
		
	}
//	power(int base, int exp) → returns base^exp
	int power(int a, int b) {
		System.out.printf("%d of Power %d : ",a,b);
		return (int)Math.pow(a,b);
	}
}
