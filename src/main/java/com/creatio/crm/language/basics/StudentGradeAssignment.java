package com.creatio.crm.language.basics;

import java.util.ArrayList;
import java.util.List;

public class StudentGradeAssignment {

	
		/**
		 * Student Grade System Build a program that: 
		 * Part 1 Create a Student class with:
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
		String name;
		int age;
		String course;
		float score;
		List<String> remarks = new ArrayList<String>(); 
}
