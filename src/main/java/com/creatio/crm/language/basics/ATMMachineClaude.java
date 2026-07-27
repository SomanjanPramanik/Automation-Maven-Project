package com.creatio.crm.language.basics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ATMMachineClaude {

	public static void main(String[] args) {
		/*
		 * balance = 50000 
		 * 5 transactions stored in LinkedList, 
		 * each transaction is a HashMap with:
		 * type → "deposit" or "withdraw" 
		 * amount → the money value
		 */
		/*
		 * Loop through all transactions 
		 * Use switch for deposit/withdraw:
		 *1. deposit → add to balance 
		 *2. withdraw → subtract from balance
		 * 
		 * If withdraw amount > balance → print "Insufficient funds" and skip (continue)
		 * If balance hits 0 → print "Account empty!" and break 
		 * Print balance after each transaction
		 */
		float balance = 50000;
		Map<String,String> transaction1 = new HashMap<String,String>();
		transaction1.put("type", "Deposit");
		transaction1.put("amount", "10000");
		Map<String,String> transaction2 = new HashMap<String,String>();
		transaction2.put("type", "Withdraw");
		transaction2.put("amount", "2000000");
		Map<String,String> transaction3 = new HashMap<String,String>();
		transaction3.put("type", "Deposit");
		transaction3.put("amount", "25000");		
		Map<String,String> transaction4 = new HashMap<String,String>();
		transaction4.put("type", "Withdraw");
		transaction4.put("amount", "85000");
		Map<String,String> transaction5 = new HashMap<String,String>();
		transaction5.put("type", "Withdraw");
		transaction5.put("amount", "15000");
		List<Map<String,String>> allFiveTransaction = new LinkedList<Map<String,String>>();
		allFiveTransaction.add(transaction1);
		allFiveTransaction.add(transaction2);
		allFiveTransaction.add(transaction3);
		allFiveTransaction.add(transaction4);
		allFiveTransaction.add(transaction5);
		//System.out.println(allFiveTransaction);
		boolean accountEmpty = false;
		for (int i = 0; i < allFiveTransaction.size(); i++) {

			String transaction = allFiveTransaction.get(i).get("type");
			switch (transaction) {
			case "Deposit":
				// deposit → add to balance
				balance = balance + Float.parseFloat(allFiveTransaction.get(i).get("amount"));
				System.out.println("Transaction Completed");
				System.out.println("Balance:" + balance);
				break;
			case "Withdraw":
				// withdraw → subtract from balance
				// If withdraw amount > balance → print "Insufficient funds" and skip (continue)
				// If balance hits 0 → print "Account empty!" and break
				if (Float.parseFloat(allFiveTransaction.get(i).get("amount")) > balance) {
					System.err.println("Transaction Failed");
					System.err.println("Insufficient funds");
					if(balance==0) {
						System.err.println("Account empty!");
						accountEmpty = true;
					}
					break;
				} 
				else {
					balance = balance - Float.parseFloat(allFiveTransaction.get(i).get("amount"));
					System.out.println("Transaction Completed");
					System.out.println("Balance:" + balance);
					if(balance==0) {
						System.err.println("Account empty!");
						accountEmpty = true;
					}
					break;
				}
				
			default:
				System.err.println("!!!!!!!!!!!!Error!!!!!!!!!!!!");

			}
			if(accountEmpty) break; // breaks for loop ✅
			
		}	
		
		

  }

}
