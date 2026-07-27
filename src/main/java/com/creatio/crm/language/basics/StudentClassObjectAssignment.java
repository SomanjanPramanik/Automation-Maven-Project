package com.creatio.crm.language.basics;

public class StudentClassObjectAssignment extends Course{

	
/**
 * Build a class called Student with:

Fields: name, age, course, isPassed
Create 3 objects with different values
Print all 3 using dot notation

Bonus: Create a Course class with courseName and duration — link it inside Student
 */
    
	String name;
	int age;
	boolean ispassed;
	
    public static void main (String[] args) {
	StudentClassObjectAssignment student1= new StudentClassObjectAssignment();
	StudentClassObjectAssignment student2= new StudentClassObjectAssignment();
	StudentClassObjectAssignment student3= new StudentClassObjectAssignment();
	
	student1.name = "Somanjan";
	student1.age = 22;
	student1.ispassed = true;
	
	student2.name = "Sp";
	student2.age = 20;
	student2.ispassed = false;
	
	student3.name = "Sp369";
	student3.age = 22;
	student3.ispassed = true;
	
    System.out.printf("Name: %s, Age: %d, Course:%s, Status:%b%n",student1.name,student1.age,student1.course,student1.ispassed);
    System.out.printf("Name: %s, Age: %d, Course:%s, Status:%b%n",student2.name,student2.age,student2.course,student2.ispassed);
    System.out.printf("Name: %s, Age: %d, Course:%s, Status:%b%n",student3.name,student3.age,student3.course,student3.ispassed);
  }
}
