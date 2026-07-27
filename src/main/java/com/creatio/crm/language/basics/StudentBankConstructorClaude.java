package com.creatio.crm.language.basics;

public class StudentBankConstructorClaude {
//	Fields: studentName, accountNumber, balance
//	Constructor to initialize all fields
//	payFees(float amount) → deducts from balance, prints confirmation
//	deposit(float amount) → adds to balance
//	getBalance() → returns balance
//	printStatement() → prints full bank statement
	String studentName ="";
	int accountNumber = 0;
	float balance = 0.0f;
	StudentBankConstructorClaude(String givenname, int givenaccountNumber, float givenbalance){
		studentName =givenname;
		accountNumber = givenaccountNumber;
		balance = givenbalance;
	}
//	payFees(float amount) → deducts from balance, prints confirmation
	public float payFees(float amount) {
		if(amount>balance) {
			System.out.println("!!!!Insufficient Balance!!!!");
			return 0;
		}
		balance = balance - amount;
		System.out.println("You've paid:$"+amount);
		System.out.println("Balance in your Account:"+balance);
		return balance;
	}
//	deposit(float amount) → adds to balance
	public void deposit(float amount) {
		balance = balance + amount;
	}
//	getBalance() → returns balance
	public void getBalance() {
		if(balance == 0) {
			System.out.println("!!!!Alert!!!!");
		}
		System.out.println("Balance in your account :$"+balance);
	}
//	printStatement() → prints full bank statement
	public void printDetails() {
		System.out.println("Account Details:");
		System.out.println("[Account Holder's name:"+studentName+"] [Account Number:"+accountNumber+"] [Balance:$"+balance+"]");
	}
}
