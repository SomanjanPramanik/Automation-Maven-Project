package com.creatio.crm.language.basics;
import java.util.Arrays;
public class Assignment13 {

	public static void main(String[] args) {
		/*
		 * Assignment: Write a program to perform the following tasks: 
		 * 1. Count the total number of words in the sentence. 
		 * 2. Print the sentence words in reverse order. 
		 * 3. Convert the first character of each word to upper-case and print
		 * original sentence
		 * 
		 * String sentence = "Java programming is fun and challenging";
		 * 
		 * Assignment: Write a program to search for all occurrences of a “Java” word in
		 * the paragraph and print their indexes. 
		 * 1. Divide into multiple words 
		 * 2. Find total number of occurrences 
		 * 3. Print count and Indexes of the word
		 * 
		 * String paragraph = "Java is a popular programming language. Java is used for
		 * web development, mobile applications, and more."; 
		 * 
		 * Assignment: Write a program
		 * to print * in triangle pattern 1. If I will pass int rows = 5 then it should
		 * print triangle with 5 Rows
		 *
		 *   *
		 *  **
		 * ***
		 *****
		 */
		//A-1
		//1.
		String sentence = "Java programming is fun and challenging";
		String[] words = sentence.split(" ");
		System.out.println("total number of words in the sentence : "+words.length);
		//2.
		for(int i = words.length-1; i >= 0 ; i--) {
		System.out.print(words[i]);                     //challenging and fun is programming Java 
		System.out.print(" ");
		}
		System.out.println();
		for(int i = sentence.length()-1; i >= 0 ; i--) {
			System.out.print(sentence.charAt(i));       //gnignellahc dna nuf si gnimmargorp avaJ
		}
		System.out.println();
		//3.
		for(int i = 0;  i < words.length;  i++) {
		  words[i] = words[i].substring(0,1).toUpperCase()+words[i].substring(1);
		}
		for(int i = 0;  i < words.length;  i++) {
			System.out.print(words[i]+" ");
		}
		System.out.println();
		
		// A-2
		String paragraph1 = "Java is a popular programming language. Java is used for web development, mobile applications, and more.";
		String[] paragraph = paragraph1.split(" ");
		int count = 0;
		int[] atindex = new int[paragraph.length];
		for (int i = 0; i < paragraph.length; i++) {
			if (paragraph[i].contains("Java")) {
				atindex[count] = i;
				count++;
			}
		}
		System.out.println(" Occurred : " + count + " times");
		System.out.println(" At index :" + Arrays.toString((Arrays.copyOf(atindex, count))));
		
		//A-3
		
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println(" Height of the triangle : ");
		int lenthOfTraingle = input.nextInt();
		input.close();
		for(int i = 0; i < lenthOfTraingle ; i ++) {
			for(int j = 0; j < lenthOfTraingle ; j ++) {
				if(j>=lenthOfTraingle-1-i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
