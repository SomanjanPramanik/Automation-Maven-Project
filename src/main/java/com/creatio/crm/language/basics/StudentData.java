package com.creatio.crm.language.basics;

import java.util.ArrayList;
import java.util.List;

public class StudentData extends StudentManagement {
	/**
	 * ArrayList of Students
	 * 
	 * Create an ArrayList of 5 Student objects Print all students with their
	 * details
	 */
	public static void main(String[] args) {
		StudentData stdnt1 = new StudentData(); // 1st student
		stdnt1.name = "Somanjan";
		stdnt1.age = 22;
		stdnt1.course = "bhratTech: Automation";
		stdnt1.score = 87.67f;
		StudentData stdnt2 = new StudentData(); // 2nd student
		stdnt2.name = "Sp369";
		stdnt2.age = 21;
		stdnt2.course = "bhratTech: Automation"; // 3rd student
		stdnt2.score = 79.67f;
		StudentData stdnt3 = new StudentData();
		stdnt3.name = "Anurag";
		stdnt3.age = 24;
		stdnt3.course = "bhratTech: Automation";
		stdnt3.score = 67.67f;
		StudentData stdnt4 = new StudentData(); // 4th student
		stdnt4.name = "Devi";
		stdnt4.age = 25;
		stdnt4.course = "bhratTech: Automation";
		stdnt4.score = 84.67f;
		StudentData stdnt5 = new StudentData(); // 5th student
		stdnt5.name = "Binks";
		stdnt5.age = 23;
		stdnt5.course = "bhratTech: Automation";
		stdnt5.score = 82.67f;
		List<StudentData> stdntArray = new ArrayList<StudentData>();
		stdntArray.add(stdnt1);
		stdntArray.add(stdnt2);
		stdntArray.add(stdnt3);
		stdntArray.add(stdnt4);
		stdntArray.add(stdnt5);
		stdntArray.add(stdnt5);
		stdntArray.remove(stdnt5);
		for (int i = 0; i < stdntArray.size(); i++) {
			System.out.printf("Name: %s, Age: %d, Course: %s, Score: %.2f%n", stdntArray.get(i).name,
					stdntArray.get(i).age, stdntArray.get(i).course, stdntArray.get(i).score);
		}
		/**
		 * Print total number of students → stdntArray.size() Print first and last
		 * student Check if a student exists → contains()
		 */
		System.out.printf("The total no. of students is %d%n", stdntArray.size());
		System.out.printf("The 1st student: %s & the last student: %s%n", stdntArray.get(0).name,
				stdntArray.get(stdntArray.size() - 1).name);
		System.out.printf("Is Binks there in the list: %b%n", stdntArray.contains(stdnt5));
	}
}
