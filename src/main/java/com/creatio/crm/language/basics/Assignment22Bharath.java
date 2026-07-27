package com.creatio.crm.language.basics;

public class Assignment22Bharath {

	public static void main(String[] args) {
		/*
		 * Assignment: Identify Longest Common Prefix (Read Instructions and example
		 * output carefully)
		 * 
		 * Write a function to find the longest common prefix string amongst an array of
		 * strings. If there is no common prefix, return an empty string "". 
		 * Example 1:
		 * Input: strs = ["flower","flow","flight"] Output: "fl" 
		 * Example 2: Input: strs = ["dog","racecar","car"] Output: "" 
		 * Explanation: There is no common prefix
		 * among the input strings. 
		 * Constraints: 
		 * • 1 <= strs.length <= 200 
		 * • 0 <= strs[i].length <= 200 
		 * • strs[i] consists of only lowercase English letters.
		 */
		String [] given = {"dog","racecar","car"};
		if(given.length == 0 || given == null) {
			System.out.println("No values are there");
		}
		String prefix = given[0]; //dog
		int lengthPrefix = prefix.length(); //3
		for(int i = 0 ; i < lengthPrefix ; i++) {
			prefix = prefix.substring(0,lengthPrefix-i); //3-0 = 3 -> dog
			boolean status = true;                   //Always starts with true
			for(String val : given) {
				if(!val.startsWith(prefix)) {
					status = false;
					break;
				}
			}
			if(status) {
				System.out.println("common prefix is : "+prefix);
				break;
			}
		}	
		if(prefix.length() <= 1) {
			System.out.println("No common prefix present");
		}

	}

}
