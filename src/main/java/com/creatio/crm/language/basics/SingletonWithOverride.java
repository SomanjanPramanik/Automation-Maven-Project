package com.creatio.crm.language.basics;

import java.util.Scanner;

public class SingletonWithOverride {
	/*
	 * Write the Singleton SingletonWithOverride class — from scratch, no hints:
	 * 
	 * Private static instance field 
	 * Private constructor (print"Connection established") 
	 * Public static getInstance() — standard null-check pattern 
	 * Method query(String sql) — prints "Executing: " + sql
	 * A main method that gets the instance twice and proves both references are the same object using ==
	 */
	private static SingletonWithOverride instance;
	private static int count = 0;
	private SingletonWithOverride(){
		System.out.println("Connection established");
		count++;
	}
	//I did some modification
	public static SingletonWithOverride getInstance() {
		if(instance == null) {
			instance = new SingletonWithOverride();
			return instance;
		}
		else {
			System.out.println("!!!Busy Connection!!!");
			System.out.println("Want to terminate (yes/no):");
			try (Scanner choice = new Scanner(System.in)) {
				String userChoice = choice.nextLine();
				 choice.close(); 
				 switch(userChoice) {
				 case("yes"):
					 count--;
				     System.out.print("New ");
				     instance = new SingletonWithOverride();
					 return instance;
				 default :
					 System.out.println("Previous Connection established");
					 return instance;
				 }
			}
		}
	}
	public void query(String sql) {
		System.out.println("Executing: "+ sql);
	}
	public static void main(String[] args) {
       SingletonWithOverride connect = SingletonWithOverride.getInstance();
       connect.query("sql");
       SingletonWithOverride connectSecond = SingletonWithOverride.getInstance();
       connectSecond.query("sql");
       System.out.println(connect == connectSecond);
	}

}
