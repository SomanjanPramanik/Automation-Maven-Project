package com.creatio.crm.language.basics;

public class ArrayAssignment {

	public static void main(String[] args) {
		/**
		 * Array Assignment 1D Array Create a String array of 5 student names
		 */
		String[] studentName = new String[5];
		studentName[0] = "Somanjan";
		studentName[1] = "Sp";
		studentName[2] = "Sp369";
		studentName[3] = "Sp2026";
		studentName[4] = "Somanjan Pramanik";
		for (int i = 0; i < 5; i++) {
			System.out.println(studentName[i]);
		}
		System.out.println();
		/**
		 * 2D Array Create a 2D array that stores a timetable like: Monday - Java - 2hrs
		 * Tuesday - Selenium - 3hrs Wednesday - Git - 1hr Print the full timetable
		 */
		String[][] timetable = new String[3][3];
		timetable[0][0] = "Monday";
		timetable[0][1] = "Java";
		timetable[0][2] = "2 hrs";
		timetable[1][0] = "Tuesday";
		timetable[1][1] = "Selenium";
		timetable[1][2] = "3 hrs";
		timetable[2][0] = "Wednesday";
		timetable[2][1] = "Git";
		timetable[2][2] = "1 hrs";
		for (int i = 0; i < 3; i++) {
			System.out.printf("%s->%s->%s", timetable[i][0], timetable[i][1], timetable[i][2]);
			System.out.println();
			System.out.println();
		}
		/**
		 * 3D Array Create a 3D array that stores: 2 batches 3 students each 2 details
		 * each (name, score)
		 */
		System.out.println();
		String[][][] BharathTechAcademy = new String[2][3][2];
		BharathTechAcademy[0][0][0] = "Somanjan";
		BharathTechAcademy[0][0][1] = "90%";
		BharathTechAcademy[0][1][0] = "Sp369";
		BharathTechAcademy[0][1][1] = "89%";
		BharathTechAcademy[0][2][0] = "Sp";
		BharathTechAcademy[0][2][1] = "96%";
		BharathTechAcademy[1][0][0] = "Sppp3699";
		BharathTechAcademy[1][0][1] = "91%";
		BharathTechAcademy[1][1][0] = "Sp3669";
		BharathTechAcademy[1][1][1] = "91%";
		BharathTechAcademy[1][2][0] = "Sp20263669";
		BharathTechAcademy[1][2][1] = "99%";
		String Batch_name;
		for (int batch = 0; batch < 2; batch++) {
			if (batch == 0) {
				Batch_name = "BharathTech Automation Training batch 1";
			} else {
				Batch_name = "BharathTech Automation Training batch 2";
			}
			for (int i = 0; i < 3; i++) {
				System.out.printf("%s-> name: %s score: %s%n", Batch_name, BharathTechAcademy[batch][i][0],
						BharathTechAcademy[batch][i][1]);
			}
		}
	}
}
