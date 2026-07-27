package com.creatio.crm.language.basics;

import java.util.Scanner;
import java.util.function.Predicate;

public class UsingPredicateFunction {

	/**
	 * Use Java's built-in Predicate<T> to:
	 * 
	 * Check if a number is even 
	 * Check if a String is longer than 5 characters 
	 * Check if a number is positive
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("Even no. check from 1 to 10");
		Predicate<Integer> check = a -> a % 2 == 0;
		for (int i = 1; i <= 10; i++) {
			System.out.printf(i + " : " + check.test(i));
			System.out.println();
		}

		System.out.println("-------------------------------------------------------------");

		System.out.print("Please enetr your name with a single space : ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		Predicate<String> check1 = checkname -> checkname.length() > 5;
		String[] fullname = name.split(" ");
		for (String eachname : fullname) {
			System.out.println(" Checking if " + eachname + " has more than 5 characters : " + check1.test(eachname));
		}

		System.out.println("-------------------------------------------------------------");

		System.out.print("Please enter a number :");
		float num = scan.nextFloat();
		scan.close();
		Predicate<Float> checkPositive = a -> a > 0;
		System.out.println(checkPositive.test(num));

		System.out.println("-------------------------------------------------------------");
	}

}
