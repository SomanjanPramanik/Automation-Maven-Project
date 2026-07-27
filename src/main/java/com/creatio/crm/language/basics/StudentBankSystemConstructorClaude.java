package com.creatio.crm.language.basics;

public class StudentBankSystemConstructorClaude {

	public static void main(String[] args) {
//		Create these files:
//			Student.java
//			Fields: name, age, course, feesPaid, feesTotal
//			Constructor to initialize all fields
//			getRemainingFees() → returns feesTotal - feesPaid
//			isPassed(float avgScore) → returns true if avgScore > 40
//			printProfile() → prints all student info
//
//			StudentBank.java
//
//			Fields: studentName, accountNumber, balance
//			Constructor to initialize all fields
//			payFees(float amount) → deducts from balance, prints confirmation
//			deposit(float amount) → adds to balance
//			getBalance() → returns balance
//			printStatement() → prints full bank statement
//
//			StudentBankSystem.java — main class
//
//			Create 3 students using constructor
//			Create 3 bank accounts using constructor
//			Each student pays their fees through their bank account
//			Print full profile + bank statement for each student
//			Print which students still have remaining fees
		StudentConstructorClaude stduent1 = new StudentConstructorClaude("Somanjan Pramanik",22,"Automation Testing",50000.f,94.5f);
		System.out.println(stduent1.getRemainingFees());
		System.out.println(stduent1.isPassed());
		stduent1.printProfile();
		StudentBankConstructorClaude stduentbank1 = new StudentBankConstructorClaude("Somanjan Pramanik",1234,50000.00f);
		stduentbank1.payFees(20000.f);
		stduentbank1.payFees(60000.f);
		stduentbank1.getBalance();
		stduentbank1.deposit(16000.f);
		stduentbank1.getBalance();
		stduentbank1.printDetails();
		
	}

}
