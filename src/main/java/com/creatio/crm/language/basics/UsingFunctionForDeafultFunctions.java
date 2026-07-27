package com.creatio.crm.language.basics;

import java.util.Scanner;
import java.util.function.Function;

public class UsingFunctionForDeafultFunctions {

	/**
	 * Use Java's built-in Function<T, R> to:
	 * 
	 * Convert a String to its length 
	 * Convert celsius to fahrenheit 
	 * Convert a String to uppercase
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		
		System.out.print("Please enter your first name : ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
//		scan.close();
		Function<String,Integer> stringLength = anyString -> anyString.length(); 
		System.out.println("Length of your first name is : "+stringLength.apply(name));
		
		System.out.println("-----------------------------------------------------------------------------");
		
		System.out.print("Please enter your surrondings temp. in °c : ");
		float temp = scan.nextFloat();
		Function<Float,Float> tempConvert = tempInC -> 9*tempInC/5 + 32;
		System.out.println(tempConvert.apply(temp));
//		scan.close();
		
		System.out.println("-----------------------------------------------------------------------------");
		
		scan.nextLine();
		System.out.print("Please enter your name : ");
		String nameLow = scan.nextLine();
		scan.close();
		Function<String,String> stringUp = StringLow -> StringLow.toUpperCase(); 
		System.out.println("your name in uppercase : "+stringUp.apply(nameLow));
		

	}

}
