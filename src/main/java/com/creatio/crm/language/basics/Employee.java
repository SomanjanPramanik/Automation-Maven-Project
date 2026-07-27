package com.creatio.crm.language.basics;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Employee class consisting of name, department, salary, yearsOfExperience
 */
public class Employee {
	/**
	 * these are fields they're more of a blue-print to the variables we're about to
	 * create in constructor
	 */
	private String empName;
	private String empDept;
	private int empExp;
	private float empSalary;

	/**
	 * we'll use constructor here!!!
	 * 
	 */
	Employee(String name, String dept, float salary, int exp) {
		/**
		 * without this key word java can not figure out where assign those values from
		 * parameters
		 */
		this.empName = name;
		this.empDept = dept;
		this.empSalary = salary;
		this.empExp = exp;
	}

	/**
	 * Here we'll call constructor each time an object of this class is created and
	 * by using constructor we're setting up the variables of the object inside of
	 * it
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        //creating 1st emp
		Employee emp1 = new Employee("somanjan pramanik", "Engineering", 40_000f, 0);
		// creating 2nd emp
		Employee emp2 = new Employee("somu Pramanik", "Engineering", 70_000f, 4);
		// creating 3rd emp
		Employee emp3 = new Employee("anurag Mishra", "Sales", 30_000f, 2);
		// creating 4th emp
		Employee emp4 = new Employee("bharath Reddy", "Board Member", 1_00_000f, 10);

		/**
		 * Filter employees with salary > 50000 Filter employees from "Engineering" department 
		 * Find the highest paid employee's name Get average salary of all
		 * employees Print all employee names in uppercase sorted alphabetically Filter
		 * employees with experience > 3 years AND salary > 40000
		 */
		 List<Employee> emplist = new LinkedList<Employee>();	
		 emplist.add(emp1);
		 emplist.add(emp2);
		 emplist.add(emp3);
		 emplist.add(emp4);
		 int i = 1;
		 for (Employee emp : emplist) {
			 System.out.println("Employee "+i);
			 System.out.println("[Name : "+emp.empName+"]->[Dept. : "+emp.empDept+"]->[Salary : "+emp.empSalary+"]->[Yrs. of experience : "+emp.empExp+"]");
			 i++;
		 }
		 //1st conquest :
		 List<Employee> empEnglist50k = emplist.stream().filter(emp -> emp.empDept.equals("Engineering")).filter(emp -> emp.empSalary>= 50_000f).collect(Collectors.toList());
		 System.out.println("----------------------------------------------------------------------------------------------------------------");
		 System.out.println("Employees with salary of 50,000 or more from 'Engineering' dept. : ");
		 int j = 1;
		 for (Employee emp : empEnglist50k) {
			 System.out.println("Employee "+j);
			 System.out.println("[Name : "+emp.empName+"]->[Dept. : "+emp.empDept+"]->[Salary : "+emp.empSalary+"]->[Yrs. of experience : "+emp.empExp+"]");
			 j++;
		 }
		 //2nd conquest :
		 System.out.println("----------------------------------------------------------------------------------------------------------------");
		 System.out.println("Employee with highest salary : ");
		 List<Employee> empSalaryHeirarchylist = emplist.stream().sorted(Comparator.comparing(emp -> emp.empSalary)).collect(Collectors.toList());
		 System.out.println(empSalaryHeirarchylist.get(empSalaryHeirarchylist.size()-1).empName);
		 System.out.print("The avg. salary of the employess : ");
		 Double avgSalary = emplist.stream().mapToDouble(emp -> emp.empSalary).average().orElse(0.0); //<-Literally googled it and sort part too
		 System.out.println(avgSalary);
		 //3rd conquest :
		 System.out.println("----------------------------------------------------------------------------------------------------------------");
		 System.out.println("Employee with names in uppercase sorted alphabetically Filter : ");
		 List<String> empNameSort = emplist.stream().map(emp -> emp.empName.toUpperCase()).sorted().collect(Collectors.toList());
		 System.out.println(empNameSort);
		 //4th conquest :
	     System.out.println("----------------------------------------------------------------------------------------------------------------");
	     System.out.println("Employees with experience > 3 years AND salary > 40000 : ");
	     List<Employee> empCustomList = emplist.stream().filter(emp -> emp.empExp > 3).filter(emp -> emp.empSalary>= 40_000f).collect(Collectors.toList());
	     int k = 1;
		 for (Employee emp : empCustomList) {
			 System.out.println("Employee "+k);
			 System.out.println("[Name : "+emp.empName+"]->[Dept. : "+emp.empDept+"]->[Salary : "+emp.empSalary+"]->[Yrs. of experience : "+emp.empExp+"]");
			 k++;
		 }
	}
}