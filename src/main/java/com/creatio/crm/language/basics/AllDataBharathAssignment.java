package com.creatio.crm.language.basics;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllDataBharathAssignment {
//EmployeeListData+StudentListData+ProductListData
	public static void main(String[] args) {
		// Employee1
		Map<String, String> Employee1 = new LinkedHashMap<String, String>();

		// E001 Alice Green 30 Female Engineering Software 75000 alice@exa 9876543213

		Employee1.put("EmpID", "E001");
		Employee1.put("Name", "Alice Green");
		Employee1.put("Age", "30");
		Employee1.put("Gender", "Female");
		Employee1.put("Department", "Engineering");
		Employee1.put("Position  ", "Software");
		Employee1.put("Salary", "75000");
		Employee1.put("Email", "alice@exa");
		Employee1.put("Contact ", "9876543213");

		// Employee2
		Map<String, String> Employee2 = new LinkedHashMap<String, String>();

		// E002 Bob Johns 35 Male Marketing Marketing 80000 bob@exa 9876543214

		Employee2.put("EmpID", "E002");
		Employee2.put("Name", "Bob Johns");
		Employee2.put("Age", "35");
		Employee2.put("Gender", "Male");
		Employee2.put("Department", "Marketing");
		Employee2.put("Position  ", "Marketing");
		Employee2.put("Salary", "80000");
		Employee2.put("Email", "bob@exa");
		Employee2.put("Contact ", "9876543214");

		// Employee3
		Map<String, String> Employee3 = new LinkedHashMap<String, String>();

		// E003 Carol White 28 Female Sales Sales Exec 65000 carol@exa 9876543215

		Employee3.put("EmpID", "E003");
		Employee3.put("Name", "Carol White");
		Employee3.put("Age", "28");
		Employee3.put("Gender", "Female");
		Employee3.put("Department", "Sales");
		Employee3.put("Position  ", "Sales Exec");
		Employee3.put("Salary", "65000");
		Employee3.put("Email", "carol@exa");
		Employee3.put("Contact ", "9876543215");
		// ---------------------------------------------------------------------------------------------
		// Student1
		Map<String, String> Student1 = new LinkedHashMap<String, String>();

		// John Doe 20 Male S12345 A Computer 3.8 john@exa 9.88E+09 123 Elm St
		Student1.put("Name", "John Doe");
		Student1.put("Age", "20");
		Student1.put("Gender", "Male");
		Student1.put("RollNum", "S12345");
		Student1.put("Grade ", "A");
		Student1.put("Major", "Computer");
		Student1.put("GPA", "3.8");
		Student1.put("Email", "john@exa");
		Student1.put("Contact ", "9.88E+09");
		Student1.put("Address", "123 Elm St");
		// Student2
		Map<String, String> Student2 = new LinkedHashMap<String, String>();

		// Jane Smith 21 Female S12346 B Mathematics 3.5 jane@exa 9.88E+09 456 Oak St

		Student2.put("Name", "Jane Smith");
		Student2.put("Age", "21");
		Student2.put("Gender", "Female");
		Student2.put("RollNum", "S12346");
		Student2.put("Grade ", "B");
		Student2.put("Major", "Mathematics");
		Student2.put("GPA", "3.5");
		Student2.put("Email", "jane@exa");
		Student2.put("Contact ", "9.88E+09");
		Student2.put("Address", "456 Oak St");
		// Student3
		Map<String, String> Student3 = new LinkedHashMap<String, String>();

		// Mike Brown 22 Male S12347 A Physics 3.9 mike@exa 9.88E+09 789 Pine St

		Student3.put("Name", "Mike Brown");
		Student3.put("Age", "22");
		Student3.put("Gender", "Male");
		Student3.put("RollNum", "S12347");
		Student3.put("Grade ", "A");
		Student3.put("Major", "Physics");
		Student3.put("GPA", "3.9");
		Student3.put("Email", "mike@exa");
		Student3.put("Contact ", "9.88E+09");
		Student3.put("Address", "789 Pine St");
		// ---------------------------------------------------------------------------------------------
		// Product1
		Map<String, String> Product1 = new LinkedHashMap<String, String>();

		// P001 Laptop Electronics $1200 50 Tech Supplies 2 years 4.5 15-01-2023
		// 15-01-2025
		Product1.put("ProductID", "P001");
		Product1.put("Name", "Laptop");
		Product1.put("Category", "Electronics");
		Product1.put("Price", "$1200");
		Product1.put("Stock", "50");
		Product1.put("Supplier", "Tech Supplies");
		Product1.put("Warranty", "2 years");
		Product1.put("Rating", "4.5");
		Product1.put("MfgDate", "15-01-2023");
		Product1.put("ExpiryDate", "15-01-2025");
		// Product2
		Map<String, String> Product2 = new LinkedHashMap<String, String>();

		// P002 Desk Chair Furniture $150 200 Office Depot 1 year 4 10-02-2023 N/A
		Product2.put("ProductID", "P002");
		Product2.put("Name", "Desk Chair");
		Product2.put("Category", "Furniture");
		Product2.put("Price", "$150");
		Product2.put("Stock", "200");
		Product2.put("Supplier", "Office Depot");
		Product2.put("Warranty", "1 years");
		Product2.put("Rating", "4");
		Product2.put("MfgDate", "10-02-2023");
		Product2.put("ExpiryDate", "N/A");
		// Product3
		Map<String, String> Product3 = new LinkedHashMap<String, String>();

		// P003 Coffee Maker Kitchen $75 100 Kitchen World 6 months 4.2 20-03-2023
		// 20-03-2024
		Product3.put("ProductID", "P003");
		Product3.put("Name", "Coffee Maker");
		Product3.put("Category", "Kitchen");
		Product3.put("Price", "$75");
		Product3.put("Stock", "100");
		Product3.put("Supplier", "Kitchen World");
		Product3.put("Warranty", "6 months");
		Product3.put("Rating", "4.2");
		Product3.put("MfgDate", "20-03-2023");
		Product3.put("ExpiryDate", "20-03-2024");
		// ---------------------------------------------------------------------------------------------
		// All Data in a list
		List<Map<String, String>> MasterList = new LinkedList<>();
		MasterList.add(Employee1);
		MasterList.add(Employee2);
		MasterList.add(Employee3);
		MasterList.add(Student1);
		MasterList.add(Student2);
		MasterList.add(Student3);
		MasterList.add(Product1);
		MasterList.add(Product2);
		MasterList.add(Product3);
		for (int i = 0; i < MasterList.size(); i++) {
			if (MasterList.get(i).containsValue("Office Depot")) {
				System.out.print(MasterList.get(i));
			}
		}

	}

}
