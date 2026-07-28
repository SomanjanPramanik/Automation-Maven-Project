package com.creatio.crm.language.basics;

public class DatabaseConnection {
		/*
		 * Write the Singleton DatabaseConnection class — from scratch, no hints:
		 * 
		 * Private static instance field 
		 * Private constructor (print"Connection established") 
		 * Public static getInstance() — standard null-check pattern 
		 * Method query(String sql) — prints "Executing: " + sql
		 * A main method that gets the instance twice and proves both references are the same object using ==
		 */
		private static DatabaseConnection instance;
		private DatabaseConnection(){
			System.out.println("Connection established");
		}
		public static DatabaseConnection getInstance() {
			if(instance == null) {
				instance = new DatabaseConnection();
				return instance;
			}
			else {
				return instance;
			 }
		}
		public void query(String sql) {
			System.out.println("Executing: "+ sql);
		}
		public static void main(String[] args) {
			DatabaseConnection connect = DatabaseConnection.getInstance();
   	        connect.query("sql");
            DatabaseConnection connectSecond = DatabaseConnection.getInstance();
		    connectSecond.query("sql");
		    System.out.println(connect == connectSecond);
		}
}
