package com.creatio.crm.language.basics;

import java.util.ArrayList;
import java.util.List;

public class StudentGradeDataAssignment {

	public static void main(String[] args) {
		/**
		 * Student Grade System Build a program that: Part 1 Create a Student class
		 * with:
		 * 
		 * name, age, course, score Add a second ArrayList for storing each student's
		 * remarks (like "Good", "Excellent", "Needs Improvement")
		 * 
		 * Part 2
		 * 
		 * Create 5 students Each student should have at least 2 remarks in their
		 * remarks list
		 * 
		 * Part 3 — Logic
		 * 
		 * Print each student with all their remarks Print only students with score
		 * above 80 Print only students who have remark "Excellent"
		 * 
		 * Part 4
		 * 
		 * Remove all remarks of the lowest scoring student Print their remarks list
		 * after removal — should be empty
		 */
		StudentGradeAssignment student1 = new StudentGradeAssignment(); // student1
		student1.name = "Somanjan";
		student1.age = 22;
		student1.course = "bhratTech: Automation";
		student1.score = 87.67f;
		student1.remarks.add("Good");
		student1.remarks.add("Excellent");
		StudentGradeAssignment student2 = new StudentGradeAssignment(); // student2
		student2.name = "Sp369";
		student2.age = 21;
		student2.course = "bhratTech: Automation";
		student2.score = 79.67f;
		student2.remarks.add("Not Good");
		student2.remarks.add("Needs improvement");
		StudentGradeAssignment student3 = new StudentGradeAssignment(); // student3
		student3.name = "Anurag";
		student3.age = 24;
		student3.course = "bhratTech: Automation";
		student3.score = 67.67f;
		student3.remarks.add("Not Good");
		student3.remarks.add("Needs improvement");
		StudentGradeAssignment student4 = new StudentGradeAssignment(); // student4
		student4.name = "Devi";
		student4.age = 25;
		student4.course = "bhratTech: Automation";
		student4.score = 84.67f;
		student4.remarks.add("Good");
		student4.remarks.add("Excellent");
		StudentGradeAssignment student5 = new StudentGradeAssignment(); // student5
		student5.name = "Binks";
		student5.age = 23;
		student5.course = "bhratTech: Automation";
		student5.score = 82.67f;
		student5.remarks.add("Good");
		student5.remarks.add("Excellent");
		// All Students object in another ArrayList
		List<StudentGradeAssignment> Students = new ArrayList<StudentGradeAssignment>();
		Students.add(student1);
		Students.add(student2);
		Students.add(student3);
		Students.add(student4);
		Students.add(student5);
		// print
		for (int i = 0; i < Students.size(); i++) {
			System.out.printf("|name: %s |age: %d|course: %s|score: %.2f|remarks: %s , %s%n", Students.get(i).name,
					Students.get(i).age, Students.get(i).course, Students.get(i).score, Students.get(i).remarks.get(0),
					Students.get(i).remarks.get(1));

		}
		// students with score above 80
		System.out.println("students with score above 80");
		for (int j = 0; j < Students.size(); j++) {
			if (Students.get(j).score > 80) {
				System.out.printf("name: %s%n", Students.get(j).name);
			}
		}
		// students who have remark "Excellent"
		System.out.println("students with Excellent remark");
		for (int j = 0; j < Students.size(); j++) {
			if (Students.get(j).remarks.contains("Excellent")) {
				System.out.printf("name: %s%n", Students.get(j).name);
			}
		}
		// Remove all remarks of the lowest scoring student Print their remarks list
		// after removal — should be empty
		System.out.println("Removing all remarks of the lowest scoring student Print their remarks list");
		// FInding lowest score
		float lowestScore = Students.get(0).score;
		for (int j = 0; j < Students.size(); j++) {
			if (lowestScore > Students.get(j).score) {
				lowestScore = Students.get(j).score;
			}
		}
		for (int j = 0; j < Students.size(); j++) {
			if (Students.get(j).score == lowestScore) {
				System.out.printf("remarks: %s , %s%n", Students.get(j).remarks.get(0), Students.get(j).remarks.get(1));
				Students.get(j).remarks.clear();
			}
		}
		// print
		for (int i = 0; i < Students.size(); i++) {
			if (Students.get(i).remarks.isEmpty()) {
				System.out.printf("|name: %s |score: %.2f|remarks: EMPTY%n", Students.get(i).name,
						Students.get(i).score);
			} else {
				System.out.printf("|name: %s |remarks: %s , %s%n", Students.get(i).name, Students.get(i).remarks.get(0),
						Students.get(i).remarks.get(1));
			}
		}
	}
}
