package com.creatio.crm.language.basics;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionCombinedAssignmentClaude {
	/**
	 * Setup — Create these classes with HashMaps:
	 * 
	 * Product — name, price, category, stock, supplier 
	 * Customer — name, email, city, membershipType (Gold/Silver/Bronze) 
	 * Order — orderID, customerName, productName, quantity, totalPrice
	 */
	public static void main(String[] args) {
		// Product1
		Map<String, String> Product1 = new LinkedHashMap<String, String>();

		// Laptop Electronics $1200 50 Tech Supplies
		Product1.put("Name", "Laptop");
		Product1.put("Category", "Electronics");
		Product1.put("Price", "60000");
		Product1.put("Stock", "50");
		Product1.put("Supplier", "Tech Supplies");
		// Product2
		Map<String, String> Product2 = new LinkedHashMap<String, String>();

		// Desk Chair Furniture $150 200 Office Depot

		Product2.put("Name", "Desk Chair");
		Product2.put("Category", "Furniture");
		Product2.put("Price", "5000");
		Product2.put("Stock", "200");
		Product2.put("Supplier", "Office Depot");

		// Product3
		Map<String, String> Product3 = new LinkedHashMap<String, String>();

		// Coffee Maker Kitchen $75 100 Kitchen World
		Product3.put("Name", "Coffee Maker");
		Product3.put("Category", "Kitchen");
		Product3.put("Price", "475");
		Product3.put("Stock", "100");
		Product3.put("Supplier", "Kitchen World");

		// ************************************************************************************
		// Customer1
		Map<String, String> Customer1 = new LinkedHashMap<String, String>();

		// Mike Brown mike@exa Kolkata 90xx890 Gold 
		Customer1.put("Name", "Mike Brown");
		Customer1.put("email", "mike@exa");
		Customer1.put("City", "Kolkata");
		Customer1.put("Phone No.", "90xx890");
		Customer1.put("Membership", "Gold");
		// Customer2
		Map<String, String> Customer2 = new LinkedHashMap<String, String>();

		//Joy Smith Smith@exa Mumbai 96xx790 Silver 
		Customer2.put("Name", "Joy Smith");
		Customer2.put("email", "Smith@exa");
		Customer2.put("City", "Mumbai");
		Customer2.put("Phone No.", "96xx790");
		Customer2.put("Membership", "Silver");

		// Customer3
		Map<String, String> Customer3 = new LinkedHashMap<String, String>();

		//Sp369 Sp369@exa Pune 97xx790 Bronze 
		Customer3.put("Name", "Sp369");
		Customer3.put("email", "Sp369@exa");
		Customer3.put("City", "Pune");
		Customer3.put("Phone No.", "97xx790");
		Customer3.put("Membership", "Bronze");
		// ************************************************************************************
		// orderID, customerName, productName, quantity, totalPrice
		// Order1
		Map<String, String> Order1 = new LinkedHashMap<String, String>();

		// Previous Data
		Order1.put("orderID", "O0003669G");
		Order1.put("customerName", "Mike Brown");
		Order1.put("productName", "Laptop");
		Order1.put("quantity", "2");
		Order1.put("totalPrice", "120000");
		// Order2
		Map<String, String> Order2 = new LinkedHashMap<String, String>();

		// Previous Data
		Order2.put("orderID", "O0016789E");
		Order2.put("customerName", "Joy Smith");
		Order2.put("productName", "Desk Chair");
		Order2.put("quantity", "5");
		Order2.put("totalPrice", "25000");
		// Order3
		Map<String, String> Order3 = new LinkedHashMap<String, String>();

		// Previous Data
		Order3.put("orderID", "O000CfM2345");
		Order3.put("customerName", "Sp369");
		Order3.put("productName", "Coffee Maker");
		Order3.put("quantity", "1");
		Order3.put("totalPrice", "475");
		
		// All Data in a list
		List<Map<String, String>> MasterList = new LinkedList<>();
		MasterList.add(Order1);
		MasterList.add(Order2);
		MasterList.add(Order3);
		MasterList.add(Customer1);
		MasterList.add(Customer2);
		MasterList.add(Customer3);
		MasterList.add(Product1);
		MasterList.add(Product2);
		MasterList.add(Product3);

		/**
		 * Print only products where stock < 100 
		 * Print only customers from "Mumbai"
		 * Print only orders where totalPrice > 500
		 */
		System.out.print("products where stock < 100:");
		for (int i = 0; i < MasterList.size(); i++) {
			if (MasterList.get(i).containsKey("Stock")) {
				if(Integer.parseInt(MasterList.get(i).get("Stock")) < 100) {
					System.out.printf("[%s]",MasterList.get(i).get("Name"));
				}
			}
	}
		System.out.println();
		System.out.print("only customers from Mumbai: ");
		for (int i = 0; i < MasterList.size(); i++) {
			if (MasterList.get(i).containsKey("Membership")) {
				if(MasterList.get(i).get("City").contains("Mumbai")) {
					System.out.printf("[%s]",MasterList.get(i).get("Name"));
				}
			}
	}
		System.out.println();
		System.out.print("orders where totalPrice > 500: ");
		for (int i = 0; i < MasterList.size(); i++) {
			if (MasterList.get(i).containsKey("totalPrice")) {
				if(Integer.parseInt(MasterList.get(i).get("totalPrice")) > 500) {
					System.out.printf("[%s]",MasterList.get(i).get("orderID"));
				}
			}
	}
		System.out.println();
	/**
	 * Create a HashSet of all unique cities from customer data Create a TreeSet of
	 * all product categories — should print in sorted order
	 */
		Set<String> customerCity = new HashSet<String>();
		for (int i = 0; i < MasterList.size(); i++) {
			if (MasterList.get(i).containsKey("City")) {
				customerCity.add(MasterList.get(i).get("City"));
			}
		}
		System.out.println("Cities: "+customerCity);

		
		Set<String> productCategory = new TreeSet<String>();
		for (int i = 0; i < MasterList.size(); i++) {
			if (MasterList.get(i).containsKey("Category")) {
				productCategory.add(MasterList.get(i).get("Category"));
			}
		}
		System.out.println("Product Categories: "+productCategory);
		System.out.println("*********************************************************************");
		/**
		 * Create a LinkedHashMap storing customerName → totalPrice for all orders Print
		 * the customer who paid the most
		 */
		Map<String, Integer> customerNametotalPrice = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < MasterList.size(); i++) {
			if (MasterList.get(i).containsKey("orderID")) {
				customerNametotalPrice.put(MasterList.get(i).get("customerName"),
						Integer.parseInt(MasterList.get(i).get("totalPrice")));
			}
		}
		System.out.println(customerNametotalPrice);
		int highestpaid = 0;
		String highestpaidCustomer = null;
		for (String key : customerNametotalPrice.keySet()) {

			if (customerNametotalPrice.get(key) > highestpaid) {
				highestpaid = customerNametotalPrice.get(key);
				highestpaidCustomer = key;
			}

		}

		System.out.println(highestpaidCustomer);
	}

}

