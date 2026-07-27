package com.creatio.crm.language.basics;

public class class2 {
/**
 * This is a class
 * here; first a copy of another class is created by using {@link class1#class1() new class1()}}
 * This is not by inheritance
 * @throws NullPointerException
 * @author Somanjan Pramanik
 * here; class2 access all the data from class1 by creating a copy of it in an object
 */
	public static void main(String[] args) {
	class1 obj_name = new class1();
	System.out.println(obj_name.name);
	System.out.println(obj_name.empid);
	System.out.println(obj_name.havingDrivinglicense);
	obj_name.getAddress();
	}

}
