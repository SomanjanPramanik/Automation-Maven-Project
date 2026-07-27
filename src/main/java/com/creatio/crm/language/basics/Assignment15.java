package com.creatio.crm.language.basics;

import java.util.Scanner;

public class Assignment15 {
	/**
	 * 1. String input = " I Love Dogs "; Print All 2 Letter word combinations from
	 * this and 2 chars should not have same letter
	 * 
	 * A phrase is a palindrome if, after converting all uppercase letters into
	 * lowercase letters and removing all non-alphanumeric characters, it reads the
	 * same forward and backward. Alphanumeric characters include letters and
	 * numbers. Given a string s, return true if it is a palindrome, or false
	 * otherwise.
	 * 
	 * Example 1: Input: s = "A man, a plan, a canal: Panama" Output: true
	 * Explanation: "amanaplanacanalpanama" is a palindrome.
	 * 
	 * Example 2: Input: s = "race a car" Output: false Explanation: "raceacar" is
	 * not a palindrome.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("1.");

		String input = " I Love Dogs ";
		String inputWithNoSpace = input.replace(" ", "");
		String[] inputAllLetters = inputWithNoSpace.split("");
		for (int i = 0; i < inputAllLetters.length; i++) {
			for (int j = 0; j < inputAllLetters.length; j++) {
				if (!inputAllLetters[i].equals(inputAllLetters[j])) {
					System.out.print(inputAllLetters[i] + inputAllLetters[j] + " ");
				}
			}
		}
		System.out.println("");

		System.out.println("2.");

		System.out.println("Wanna check if the word/sentence you'll put is palindrome or not : ");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		scan.close();
		String wordLetterOnly = word.replaceAll("[^\\p{L}]", "");
		String wordLetterNoSpace = wordLetterOnly.replace(" ", "").toLowerCase();
		String[] wordEachLetter = wordLetterNoSpace.split("");
		String reverseWord1 = "";
		for (int i = wordEachLetter.length - 1; i >= 0; i--) {

			reverseWord1 = reverseWord1 + wordEachLetter[i];

		}
		System.out.println("In reverse 🙃: " + reverseWord1);
		if (wordLetterNoSpace.equals(reverseWord1)) {
			System.out.println("WOW! palindrome found.👈");
		} else {
			System.out.println("Buddy! no palindrome found here.😅");
		}

	}

}
