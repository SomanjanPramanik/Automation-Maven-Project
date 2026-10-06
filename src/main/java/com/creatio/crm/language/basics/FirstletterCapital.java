package com.creatio.crm.language.basics;

public class FirstletterCapital {

	public static void main(String[] args) {

		System.out.println(firstLetterCapitalSentence("mY nAme iS somaNJAN pRAMAnik "));
	}

	public static String firstLetterCapital(String str) {
		if (str == null) {

			return null;

		}

		StringBuilder strCap = new StringBuilder("");
		strCap.append(Character.toUpperCase(str.charAt(0)));
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && i < str.length()-1) {
				strCap.append(str.charAt(i));
				i++;
				strCap.append(Character.toUpperCase(str.charAt(i)));

			} 
			else {
				strCap.append(str.charAt(i));
			}

		}

		return strCap.toString();

	}
	
	public static String firstLetterCapitalSentence(String str) {
		
		StringBuilder string = new StringBuilder("");
		
		string.append(Character.toUpperCase(str.charAt(0)));
		
		for(int i =1 ; i < str.length(); i++) {
			
			if(str.charAt(i) == ' ' && i< str.length()-1 ) {
				
				string.append(str.charAt(i));
				i++;
				string.append(Character.toUpperCase(str.charAt(i)));

			}
			else {
				
				string.append(str.charAt(i));
				
			}
		}
		
		return string.toString();
		
	}

}
