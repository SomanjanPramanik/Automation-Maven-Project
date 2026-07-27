package com.creatio.crm.language.basics;

public class CommentsInJava {
/**
 * This is main method; form where JVM execution process starts.
 * This method is a dependency method. It depends on {@link #matters()}
 * @param This takes input of array of strings i.e. String[] or String... (input).
 * @return This doesn't return anything; only executes the program inside of it.
 * @author Somanjan Pramanik (somanjan1606@gmail.com).
 * @throws NullPointerException (No error should be expected). 
 * @deprecated It's advised not to use this method as it's soon to be removed. 
 */
	public static void main(String[] args) {   // see the strike through the main; it shows that the method is deprecated
		System.out.println("This method depends on 'matter' method");

	}
	public static void matters(String[] args) {
		System.out.println("Hi");

	}

}
