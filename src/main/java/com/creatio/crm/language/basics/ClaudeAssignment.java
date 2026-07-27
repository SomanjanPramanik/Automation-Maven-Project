package com.creatio.crm.language.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ClaudeAssignment {

	public static void main(String[] args) {
		/**
		 * Build a program that: Data:
		 * 
		 * Create 5 students using HashMap (name, subject1, subject2, subject3 scores)
		 * 
		 * Logic:
		 * 
		 * Calculate total score for each student Calculate average score for each
		 * student Use switch to assign grade:
		 * 
		 * 90+ → "A" 75-89 → "B" 60-74 → "C" below 60 → "F"
		 * 
		 * 
		 * Print full report card for each student
		 * 
		 * Collections:
		 * 
		 * Store all students in ArrayList Store only students who passed (average > 60)
		 * in a separate ArrayList Store all unique grades given in a TreeSet
		 */
		// Student1
		Map<String, String> student1 = new HashMap<String, String>();
		student1.put("Name", "Somanjan Pramanik");
		student1.put("Physics", "90");
		student1.put("Chemistry", "92");
		student1.put("Math", "97");
		// Student2
		Map<String, String> student2 = new HashMap<String, String>();
		student2.put("Name", "Sp 369");
		student2.put("Physics", "87");
		student2.put("Chemistry", "89");
		student2.put("Math", "95");
		// student3
		Map<String, String> student3 = new HashMap<String, String>();
		student3.put("Name", "newlord 369");
		student3.put("Physics", "70");
		student3.put("Chemistry", "65");
		student3.put("Math", "50");
		// student4
		Map<String, String> student4 = new HashMap<String, String>();
		student4.put("Name", "newlord2.0 369");
		student4.put("Physics", "79");
		student4.put("Chemistry", "83");
		student4.put("Math", "90");
		// student5
		Map<String, String> student5 = new HashMap<String, String>();
		student5.put("Name", "Somanjan2.0 369");
		student5.put("Physics", "93");
		student5.put("Chemistry", "95");
		student5.put("Math", "100");
		// Grade
		// Total Score

		List<Map<String, String>> studentDataList = new LinkedList<Map<String, String>>();
		studentDataList.add(student1);
		studentDataList.add(student2);
		studentDataList.add(student3);
		studentDataList.add(student4);
		studentDataList.add(student5);
		System.out.println("***************************************************************");
		for (int i = 0; i < studentDataList.size(); i++) {
			float totalScore = 0;
			for (String key : studentDataList.get(i).keySet()) {
				if (key.equals("Name")) {
					continue;
				}

				totalScore = totalScore + Float.parseFloat(studentDataList.get(i).get(key));
			}
			System.out.printf("%s's" + " total score out of 300: %f%n", studentDataList.get(i).get("Name"), totalScore);
			totalScore = 0;
		}
		System.out.println("***************************************************************");
		// Avg. Score
		List<Float> avgScorelist = new LinkedList<Float>();

		for (int i = 0; i < studentDataList.size(); i++) {
			float AvgScore = 0;
			for (String key : studentDataList.get(i).keySet()) {
				if (key.equals("Name")) {
					continue;
				}

				AvgScore = AvgScore + Float.parseFloat(studentDataList.get(i).get(key));

			}
			AvgScore = AvgScore / 3;
			avgScorelist.add(AvgScore);
			System.out.printf("%s's" + " Avg score: %f%n", studentDataList.get(i).get("Name"), AvgScore);
			AvgScore = 0;
		}
		System.out.println("***************************************************************");

		/**
		 * Use switch to assign grade:
		 * 
		 * 90+ → "A" 80-89 → "B" 70-79 → "C" 60-69 → "D" below 60 → "F"
		 */
		System.out.println(avgScorelist);
		for (int i = 0; i < avgScorelist.size(); i++) {
			int grade = avgScorelist.get(i).intValue() / 10;
			switch (grade) {
			case 10:
				System.out.println("Grade: A");
				break;
			case 9:
				System.out.println("Grade: A");
				break;
			case 8:
				System.out.println("Grade: B");
				break;
			case 7:
				System.out.println("Grade: C");
				break;
			case 6:
				System.out.println("Grade: D");
				break;
			default:
				System.out.println("Grade: F");
			}

		}
		System.out.println("***************************************************************");
		/*
		 * Print full report card for each student
		 * 
		 * List<Map<String, String>> studentDataList = new LinkedList<Map<String,
		 * String>>();
		 */
		System.out.println("All 5 students' report card is:");
		for (int i = 0; i < studentDataList.size(); i++) {
			float totalScore = 0;
			for (String key : studentDataList.get(i).keySet()) {
				if (key.equals("Name")) {
					continue;
				}

				totalScore = totalScore + Float.parseFloat(studentDataList.get(i).get(key));

			}
			float avgScore = totalScore / 3;
			System.out.printf("|Name: %s |" + "|Total score out of 300: %f ||Percentage: %f |",
					studentDataList.get(i).get("Name"), totalScore, avgScore);
			int grade = (int) avgScore / 10;
			switch (grade) {
			case 10:
				System.out.println("Grade: A |");
				break;
			case 9:
				System.out.println("Grade: A |");
				break;
			case 8:
				System.out.println("Grade: B |");
				break;
			case 7:
				System.out.println("Grade: C |");
				break;
			case 6:
				System.out.println("Grade: D |");
				break;
			default:
				System.out.println("Grade: F |");
			}
			totalScore = 0;
		}
		System.out.println("***************************************************************");
		/*
		 * Store all students in ArrayList 
		 * Store only students who passed (average > 85)
		 * in a separate ArrayList Store all unique grades given in a TreeSet
		 */
		System.out.println("All Students Data:"+studentDataList);
		System.out.println("***************************************************************");
		List<String> studentAbove85prcnt = new ArrayList<String>();
		Set<String> uniqueGrade = new TreeSet<String>();
		for (int i = 0; i < studentDataList.size(); i++) {
			float totalScore = 0;
			for (String key : studentDataList.get(i).keySet()) {
				if (key.equals("Name")) {
					continue;
				}

				totalScore = totalScore + Float.parseFloat(studentDataList.get(i).get(key));

			}
			float avgScore = totalScore / 3;
			if (avgScore > 85.00) {
				studentAbove85prcnt.add(studentDataList.get(i).get("Name"));
			}
			int grade = (int) avgScore / 10;
			switch (grade) {
			case 10:
				uniqueGrade.add("A");
				break;
			case 9:
				uniqueGrade.add("A");
				break;
			case 8:
				uniqueGrade.add("B");
				break;
			case 7:
				uniqueGrade.add("C");
				break;
			case 6:
				uniqueGrade.add("D");
				break;
			default:
				uniqueGrade.add("F");

		}
			}
		System.out.println("Students Above 85 percentage:"+studentAbove85prcnt);
		System.out.println("***************************************************************");
		System.out.println("Unique Grades Student acuired:"+uniqueGrade);

	}
}
