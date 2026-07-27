package com.creatio.crm.language.basics;

/**
 * This is a class
 * here; first all properties of class1 are passed on to class1 by {@link class3#class3() extends class1()}}
 * This is by inheritance
 * @throws NullPointerException
 * @author Somanjan Pramanik
 * here; we don't need to create another object of different class [here class1]
 * but we do need to create an object of class3
 */
public class class3 extends class1{
		public static void main(String[] args) {
		class3 obj_name = new class3();
		System.out.println(obj_name.name);
		System.out.println(obj_name.empid);
		System.out.println(obj_name.havingDrivinglicense);
		obj_name.getAddress();
		}

}
