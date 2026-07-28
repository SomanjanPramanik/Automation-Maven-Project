package com.creatio.crm.language.basics;

public class CountVowels {

	public static int countVowels(String word) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		String words = word.toLowerCase().trim().replace(" ","");
        int count = 0;      
        for (int i = 0; i < words.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (words.charAt(i) == vowels[j]) {  
                    count++;
                }
            }
        }
			return count;		   
	}
	
	public static String reverseWords(String sentence) {
		String[] words = sentence.split("\\s+"); //'\\s+' is more robust e.g. Automation  QA (2space in between)==> "Automation","QA"
		StringBuilder sb = new StringBuilder();  //empty StringBuilder
		for(int i = words.length-1; i >= 0 ; i--) {
			sb.append(words[i]).append(" ");        //"Engineer Automation QA "
		}
		return sb.toString().trim();                //"Engineer Automation QA"
	}
	
	public static void main(String[] args) {
		
		System.out.print("1. method calling ==> no. of vowels present : ");
		System.out.println(countVowels("QA Automation Engineer"));
	    
		System.out.print("2. method calling ==> In Reverse Order of sentence : ");
		System.out.println(reverseWords("QA Automation                        Engineer")); //"\\s+" more robust
	}
}
