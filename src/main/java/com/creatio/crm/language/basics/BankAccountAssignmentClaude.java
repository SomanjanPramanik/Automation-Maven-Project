package com.creatio.crm.language.basics;

public class BankAccountAssignmentClaude {

	public static void main(String[] args) {
		/*
		 * Create a class BankAccount with:
		 * 
		 * Fields: accountHolder, accountNumber, balance 
		 * Constructor to initialize all 3
		 * fields Methods:
		 * 
		 * deposit(float amount) → adds to balance 
		 * withdraw(float amount) → checks insufficient funds 
		 * getBalance() → returns current balance 
		 * printDetails() → prints all account info
		 * 
		 * Create 3 bank accounts using constructor and test all methods.
		 */
		//Acc1
		BankAccountClaude acc1 = new BankAccountClaude("Somanjan Pramanik",1234,50000.00f);
		acc1.deposit(50000.0f);
		acc1.printDetails();
		acc1.withdraw(20000.0f);
		acc1.printDetails();
		acc1.withdraw(80000.0f);
		acc1.withdraw(80000.0f);
		acc1.printDetails();
		acc1.getBalance();
		acc1.printDetails();
		System.out.println();
		//Acc2
		BankAccountClaude acc2 = new BankAccountClaude("Newlord 369",3669,40000.00f);
		acc2.deposit(50000.0f);
		acc2.printDetails();
		acc2.withdraw(20000.0f);
		acc2.printDetails();
		acc2.withdraw(800.0f);
		acc2.withdraw(9.0f);
		acc2.printDetails();
		acc2.getBalance();
		acc2.printDetails();
		System.out.println();
		//acc3
		BankAccountClaude acc3 = new BankAccountClaude("Sp 369",3669,60000.00f);
		acc3.deposit(50000.0f);
		acc3.printDetails();
		acc3.withdraw(20000.0f);
		acc3.printDetails();
		acc3.withdraw(80000.0f);
		acc3.withdraw(67.0f);
		acc3.printDetails();
		acc3.getBalance();
		acc3.printDetails();
	}

}
