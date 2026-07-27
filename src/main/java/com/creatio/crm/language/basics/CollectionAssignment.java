package com.creatio.crm.language.basics;

import java.util.ArrayList;
import java.util.List;

public class CollectionAssignment {

	public static void main(String[] args) {
		/**
		 * ArrayList Assignment

Create an ArrayList of 5 course names
Print the total count
Print the first and last course
Remove one course and print the list again
Check if a specific course exists in the list using contains()


		 */
    List<String> courseName = new ArrayList<String>();
    courseName.add("AI ML");
    courseName.add("Automation Testing");
    courseName.add("Cloud computing");
    courseName.add("Embedded Sytem");
    courseName.add("Web dev");
    System.out.println(courseName.size());
    System.out.printf("1st course: %s || last course: %s%n",courseName.get(0),courseName.get(courseName.size()-1));
    System.out.println(courseName.remove(3));
    System.out.println(courseName);
    System.out.println(courseName.contains("Automation Testing"));
    
	}

}
