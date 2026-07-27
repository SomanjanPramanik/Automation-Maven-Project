package com.creatio.crm.language.basics;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpressionInCollection {

	public static void main(String[] args) {
		
		/**
		 * Create a list of 6 students with different ages and scores 
		 * Using Lambda + Predicate:
		 * 
		 * Filter students with score > 80 
		 * Filter students who are above 20 years old
		 * Filter students who are BOTH above 20 AND score > 80
		 * 
		 * Using Streams API:
		 * 
		 * Print all student names in uppercase 
		 * Find the average score of all students
		 * Find the highest scoring student's name 
		 * Sort students by score (ascending)
		 * and print
		 */
		
		// All student details...
		List<List<String>> students = new LinkedList<List<String>>();

		// student1
		List<String> student1 = new LinkedList<String>();
		student1.add("Somu");// name
		student1.add(String.valueOf(20)); // age
		student1.add(String.valueOf(87)); // score
		// Adding in map
		students.add(student1);

		// student2
		List<String> student2 = new LinkedList<String>();
		student2.add("Som");// name
		student2.add(String.valueOf(21)); // age
		student2.add(String.valueOf(82)); // score
		// Adding in map
		students.add(student2);

		// student3
		List<String> student3 = new LinkedList<String>();
		student3.add("Somanjan");// name
		student3.add("22"); // age
		student3.add("88"); // score
		// Adding in map
		students.add(student3);

		// student4
		List<String> student4 = new LinkedList<String>();
		student4.add("Sp369");// name
		student4.add("21"); // age
		student4.add("89"); // score
		// Adding in map
		students.add(student4);

		// student5
		List<String> student5 = new LinkedList<String>();
		student5.add("newlord");// name
		student5.add("20"); // age
		student5.add("67"); // score
		// Adding in map
		students.add(student5);

		// student6
		List<String> student6 = new LinkedList<String>();
		student6.add("SomanjanNew");// name
		student6.add("22"); // age
		student6.add("90"); // score
		// Adding in map
		students.add(student6);

		// Using Predicate and lambda expressions
		System.out.println("Students scoring above 80 : ");
		for (List<String> student : students) {
			int score = Integer.parseInt(student.get(2));
			//checking
			Predicate<Integer> scoreAbove80 = scoreOfStudent -> scoreOfStudent > 80;
			if (scoreAbove80.test(score)) {
				System.out.println(student.get(0));
			}

		}

		System.out.println(
				"--------------------------------------------------------------------------------------------");

		System.out.println("Students having age above 20 : ");
		for (List<String> student : students) {
			int age = Integer.parseInt(student.get(1));
			//checking
			Predicate<Integer> ageAbove80 = ageOfStudent -> ageOfStudent > 20;
			if (ageAbove80.test(age)) {
				System.out.println(student.get(0));
			}

		}

		System.out.println(
				"--------------------------------------------------------------------------------------------");

		System.out.println("Students having age above 20 as well scoring above 80 : ");
		for (List<String> student : students) {
			// checking score
			int score = Integer.parseInt(student.get(2));
			Predicate<Integer> scoreAbove80 = scoreOfStudent -> scoreOfStudent > 80;
			// checking age
			int age = Integer.parseInt(student.get(1));
			Predicate<Integer> ageAbove80 = ageOfStudent -> ageOfStudent > 20;
			// checking both
			if (scoreAbove80.test(score) && ageAbove80.test(age)) {
				System.out.println(student.get(0));
			}

		}
		
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		
		System.out.println("-------- Stream API --------");
		
		students.stream().map(student -> student.get(0).toUpperCase()).forEach(System.out::println);
				
		System.out.println("--------------------------------------------------------------------------------------");
		
		double avg = students.stream().mapToInt(student -> Integer.parseInt(student.get(2))).average().getAsDouble();
		System.out.println("Average score: " + avg);
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		int highestMark = students.stream().mapToInt(student -> Integer.parseInt(student.get(2))).max().getAsInt();
		System.out.println("highest Mark : "+ highestMark);
		
		System.out.println("--------------------------------------------------------------------------------------");
		
		students.stream()
        .sorted((a, b) -> Integer.parseInt(a.get(2)) - Integer.parseInt(b.get(2)))
        .forEach(s -> System.out.println(s.get(0) + " : " + s.get(2)));
	}

}
