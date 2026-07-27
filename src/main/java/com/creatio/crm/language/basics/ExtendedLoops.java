package com.creatio.crm.language.basics;

import java.util.HashMap;
import java.util.Map;

public class ExtendedLoops {

	public static void main(String[] args) {
		//Extended for loop
		/*
		 * Create a HashMap with 5 countries and their capitals: India → New Delhi Japan
		 * → Tokyo USA → Washington France → Paris Brazil → Brasilia
		 * 
		 * Then using for-each loops:
		 * 
		 * Print all keys (countries) Print all values (capitals) Print both together
		 * like India : New Delhi Find and print the country whose capital contains
		 * letter "o"
		 */
		Map<String, String> country = new HashMap<String, String>();
		country.put("India", "New Delhi");
		country.put("Japan", "Tokyo");
		country.put("USA", "Washinton");
		country.put("Brazil", "Brasilia");
		country.put("France", "Paris");

		System.out.println("Countries:");
		for (String key : country.keySet()) {
			System.out.println(key);
		}

		System.out.println("The countries' capital: ");
		for (String key : country.keySet()) {
			System.out.println(country.get(key));
		}

		System.out.println("Countries along with it's capitals: ");
		for (String key : country.keySet()) {
			System.out.println(key + ":" + country.get(key));
		}

		System.out.println("Countries along with it's capitals containing 'o': ");
		for (String key : country.keySet()) {
			if (country.get(key).contains("o")) {
				System.out.println(key + ":" + country.get(key));
			}
		}
		
		//do while loop
		//first execute then checks conditions
		int i=0;
		do {
			if(i>=10) {
				break;
			}
			System.out.println("!!!!!!!Refresh the page!!!!!!!!"+i);
			i++;
		}while(i>0);
		

	}

}