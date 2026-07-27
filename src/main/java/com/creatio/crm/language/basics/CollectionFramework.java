package com.creatio.crm.language.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionFramework {

	public static void main(String[] args) {
		// Array
		// BharathLec
		System.out.println("_________________________________________________________");
		System.out.println("*************************Array****************************");

		String[] studentName = new String[5];
		studentName[0] = "Somanjan";
		studentName[1] = "Sp";
		studentName[2] = "Sp369";
		studentName[3] = "Sp2026";
		studentName[4] = "Somanjan Pramanik";
		for (int i = 0; i < 5; i++) {
			System.out.println(studentName[i]);
		}
		System.out.println();
		System.out.println("_________________________________________________________");
		System.out.println("*************************List****************************");

		// ArrayList
		/**
		 * here I directly told java that these keywords are from these java packages
		 * and it recognize it
		 */
		// java.util.List<String> name = new java.util.ArrayList<String>();

		// But better way to do this is using import keyword to import packages and
		// classes from JRE library
		System.out.println("*************************ArrayList****************************");
		List<String> name = new ArrayList<String>();
		name.add("Somanjan");
		name.add("Sp369");
		name.add(null);
		name.add("Somanjan");
		System.out.println(name.size());
		System.out.println(name.get(0));
		System.out.println(name);
		System.out.println(name.remove("Somanjan"));
		/**
		 * First duplicate file gets removed As it will search for the first match in
		 * the list
		 */
		System.out.println(name);

		// LinkedList
		// Insertion order
		// Null values allowed
		// Duplicates allowed
		System.out.println("*************************LinkedList****************************");
		List<String> name1 = new LinkedList<String>();
		name1.add("Sp369");
		name1.add(null);
		name1.add("Somanjan");
		name1.add("Sp369");
		System.out.println(name1.size());
		System.out.println(name1.get(0));
		System.out.println(name1);
		System.out.println(name1.remove("Somanjan"));
		System.out.println();
		System.out.println("_________________________________________________________");
		System.out.println("*************************Set****************************");

		// HashSet
		// Random Order
		// Null values allowed
		// Duplicate values not allowed
		System.out.println("*************************HashSet****************************");
		Set<String> nameHashSet = new HashSet<String>();
		nameHashSet.add("Sp369");
		nameHashSet.add(null);
		nameHashSet.add("Somanjan");
		nameHashSet.add("Sp369");
		System.out.println(nameHashSet.size());
		// System.out.println(nameHashSet.get(0)); //No Index present here
		System.out.println(nameHashSet);
		System.out.println(nameHashSet.remove("Somanjan"));
		System.out.println(nameHashSet);

		// LinkedHashSet
		// Insertion order
		// Null values allowed
		// Duplicate values not allowed
		System.out.println("*************************LinkedHashSet****************************");
		Set<String> nameLinkedHashSet = new LinkedHashSet<String>();
		nameLinkedHashSet.add("Sp369");
		nameLinkedHashSet.add(null);
		nameLinkedHashSet.add("Somanjan");
		nameLinkedHashSet.add("Sp369");
		System.out.println(nameLinkedHashSet.size());
		// System.out.println(nameLinkedHashSet.get(0)); //No Index present here
		System.out.println(nameLinkedHashSet);
		System.out.println(nameLinkedHashSet.remove("Somanjan"));
		System.out.println(nameLinkedHashSet);

		// TreeSet
		// Ascending order
		// Null value not allowed
		// Duplicate values not allowed
		System.out.println("*************************TreeSet****************************");
		Set<String> nameTreeSet = new TreeSet<String>();
		nameTreeSet.add("Sp369");
		// nameTreeSet.add(null); //Null value not allowed: NullPointerException
		nameTreeSet.add("Somanjan");
		nameTreeSet.add("Sp369");
		nameTreeSet.add("Sp369");
		nameTreeSet.add("Sp369999");
		System.out.println(nameTreeSet.size());
		// System.out.println(nameTreeSet.get(0)); //No Index present here
		System.out.println(nameTreeSet);
		System.out.println(nameTreeSet.remove("Somanjan"));
		System.out.println(nameTreeSet);

		System.out.println();
		System.out.println("_________________________________________________________");
		System.out.println("*************************Map****************************");

		// HashMap
		// Random order of key
		// Null key and value both allowed
		System.out.println("*************************HashMap****************************");
		Map<Integer, String> nameHashMap = new HashMap<Integer, String>();
		// nameHashMap.add(null); //add() method not available for Map as it stores
		// key+value; use put() method
		nameHashMap.put(1, "Sp369");
		nameHashMap.put(2, "Somanjan");
		nameHashMap.put(2, "Sp369");
		nameHashMap.put(3, "Sp369");
		nameHashMap.put(null, "Sp369999");
		nameHashMap.put(4, null);
		System.out.println(nameHashMap.size());
		System.out.println(nameHashMap.get(2)); // No Index present here but key present
		System.out.println(nameHashMap);
		System.out.println(nameHashMap.remove(3));
		System.out.println(nameHashMap);

		// LinkedHashMap
		// Insertion order of key
		// Null value and key both allowed
		System.out.println("*************************LinkedHashMap****************************");
		Map<Integer, String> nameLinkedHashMap = new LinkedHashMap<Integer, String>();
		nameLinkedHashMap.put(1, "Sp369");
		nameLinkedHashMap.put(2, "Somanjan");
		nameLinkedHashMap.put(2, "Sp369");
		nameLinkedHashMap.put(3, "Sp369");
		nameLinkedHashMap.put(null, "Sp369999");
		nameLinkedHashMap.put(4, null);
		System.out.println(nameLinkedHashMap.size());
		System.out.println(nameLinkedHashMap.get(2)); // No Index present here but key present
		System.out.println(nameLinkedHashMap);
		System.out.println(nameLinkedHashMap.remove(3));
		System.out.println(nameLinkedHashMap);

		// TreeMap
		// Ascending order of key
		// Null key not allowed but null value is allowed
		System.out.println("*************************TreeMap****************************");
		Map<Integer, String> nameTreeMap = new TreeMap<Integer, String>();
		nameTreeMap.put(1, "Sp369");
		nameTreeMap.put(2, "Somanjan");
		nameTreeMap.put(2, "Sp369");
		nameTreeMap.put(3, "Sp369");
		// nameTreeMap.put(null,"Sp369999"); //Null Key not allowed
		nameTreeMap.put(4, null);
		System.out.println(nameTreeMap.size());
		System.out.println(nameTreeMap.get(2)); // No Index present here but key present
		System.out.println(nameTreeMap);
		System.out.println(nameTreeMap.remove(3));
		System.out.println(nameTreeMap);

		// Hashtable
		// Random order of key
		// Null key and null value both aren't allowed
		System.out.println("*************************Hashtable****************************");
		Map<Integer, String> nameHashtable = new Hashtable<Integer, String>();
		nameHashtable.put(1, "Sp369");
		nameHashtable.put(2, "Somanjan");
		nameHashtable.put(2, "Sp369");
		nameHashtable.put(3, "Sp369");
		// nameHashtable.put(null,"Sp369999"); //Null Key not allowed
		// nameHashtable.put(4,null); //Null value not allowed
		System.out.println(nameHashtable.size());
		System.out.println(nameHashtable.get(2)); // No Index present here but key present
		System.out.println(nameHashtable);
		System.out.println(nameHashtable.remove(3));
		System.out.println(nameHashtable);

	}

}
