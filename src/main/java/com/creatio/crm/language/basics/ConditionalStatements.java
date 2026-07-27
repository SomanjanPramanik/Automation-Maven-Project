package com.creatio.crm.language.basics;

public class ConditionalStatements {

	public static void main(String[] args) {
//		String name = "Sp";
//		int i = 0;
//		while(i>=0) {
//			if(i>10) {
//				break;
//			}
//			System.out.println(name+"."+i);
//			i++;
//		}

		// Print a multiplication table of any number the user chooses (hardcode the
		// number)
		int num = 12;
		for (int i = 1; i <= 20; i++) {
			int tableNum = num * i;
			System.out.println(num + "*" + i + "=" + tableNum);
		}
		// Start with score = 100. Keep subtracting random penalty (5, 10, or 15) until
		// score hits 0 or below. Print score after each penalty
		int finalScore = 100;
		while (finalScore > 0) {
			if (finalScore <= 0) {
				break;
			} else if (finalScore >= 75) {
				finalScore = finalScore - 15;
				System.out.println(finalScore);
			} else if (finalScore <= 75 && finalScore >= 50) {
				finalScore = finalScore - 10;
				System.out.println(finalScore);
			} else {
				finalScore = finalScore - 5;
				System.out.println(finalScore);
			}
		}
		// Take a day number (1-7) and print the day name:
		// 1 → Monday
		// 2 → Tuesday
		// and so on...
		// Any other number → "Invalid day"
		int day;
		day = 0;
		switch (day) {
		case 1:
			System.out.println("Sunday");
			break;
		case 2:
			System.out.println("Monday");
			break;
		case 3:
			System.out.println("Tuesday");
			break;
		case 4:
			System.out.println("Wednesday");
			break;
		case 5:
			System.out.println("Thrusday");
			break;
		case 6:
			System.out.println("Friday");
			break;
		case 7:
			System.out.println("Saturday");
			break;
		default:
			System.out.println("There's only 7 days in week\n!!!!!!!Invalid input!!!!!!!");

		}
		/**
		 * Loop through numbers 1-20:
		 * 
		 * Skip all even numbers (continue) Stop the loop when you hit 15 (break) Print
		 * only the numbers that actually get printed
		 */
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				continue;
			} else if (i == 15) {
				break;
			} else {
				System.out.println("[" + i + "]");
			}
		}
		/**
		 * Build a number guessing game:
		 * 
		 * Secret number = 69 Keep asking user to guess using while loop If guess < 69 →
		 * print "Too low" If guess > 69 → print "Too high" If correct → print "You got
		 * it!" and break
		 */
		int secretNumber = 69;
		int guessNum;
		guessNum= 10;
		while(guessNum>-1) {
			if(guessNum == secretNumber) {
				System.out.println("You got it!");
				break;
			}
			else if (guessNum>secretNumber) {
				System.out.println("Too high");
			}
			else {
				System.out.println("Too low");
			}
			guessNum++;
		}

	}
}
