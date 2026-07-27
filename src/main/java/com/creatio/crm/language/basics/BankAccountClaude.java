package com.creatio.crm.language.basics;

public class BankAccountClaude {
	String accHolder ="";
	int accNum = 0;
	float accBalance = 0.0f;
	BankAccountClaude(String accountHolder, int accountNumber, float balance) {
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
		accHolder = accountHolder;
		accNum = accountNumber;
		accBalance = balance;
	}
	 //deposit(float amount) → adds to balance 
	public void deposit(float amount) {
		
		accBalance = accBalance+amount;
	}
	//withdraw(float amount) → checks insufficient funds 
	public float withdraw(float amount) {
		if(amount>accBalance) {
			System.err.println("!!!!!Insufficient funds!!!!!");
			return 0;
		}
		accBalance = accBalance-amount;
		return accBalance;
	}
	//getBalance() → returns current balance
	public void getBalance() {
		if(accBalance == 0) {
			System.out.println("!!!!Alert!!!!");
		}
		System.out.println("Balance in your account :$"+accBalance);
	}
	//printDetails() → prints all account info
	public void printDetails() {
		System.out.println("Account Details:");
		System.out.println("[Account Holder's name:"+accHolder+"] [Account Number:"+accNum+"] [Balance:$"+accBalance+"]");
	}
}