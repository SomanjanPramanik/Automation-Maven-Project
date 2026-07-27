package com.creatio.crm.language.basics;

public class DataTypesAssignment {

	public static void main(String[] args) {
		/**
		 * Stores your name (String), age (int), height (double), student or not
		 * (boolean) Prints them in one sentence like: "My name is Somanjan, I am 20
		 * years old, 175.5cm tall and I am a student: true"
		 */
		String name = "Somanjan Pramanik";
		int age = 22;
		double height = 165.123456;
		boolean student = true;
		System.out.printf("My name is %s, I am %d years old, %.2f tall and I am a student:%b", 
				name, 
				age, 
				height,
				student);

	}

}
