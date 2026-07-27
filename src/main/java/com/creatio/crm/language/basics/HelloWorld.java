package com.creatio.crm.language.basics;

import java.util.logging.Logger;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.print("Hi Sp");
		System.out.println();
		System.out.println("Hello World");
		System.out.printf("my age is %d and my name is %s.%n",21,"Somanjan");
		System.out.format("Here's the pie approx value %.2f",3.14159);
		System.out.println();
		//System.out.write(65);
		//System.out.println("Test");
		System.err.println("Error while changing ASCII into character");
		Logger.getLogger("Mylogger").info("Error while changing ASCII into character");
	}

}
