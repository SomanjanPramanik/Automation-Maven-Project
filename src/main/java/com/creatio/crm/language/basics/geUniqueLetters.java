package com.creatio.crm.language.basics;

public class geUniqueLetters {

	public static void main(String[] args) {
		// System.out.println(getUniqueCharacters("aabbbccdddeefffggg"));
		System.out.println(compressString("abccdtt"));
	}

	public static String getUniqueCharacters(String str) {
		StringBuilder string = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			if (string.indexOf(String.valueOf(str.charAt(i))) == -1) {
				string.append(str.charAt(i));
			}
		}
		return string.toString();

	}

	public static String compressString(String str) {

		StringBuffer string = new StringBuffer("");

		for (int i = 0; i < str.length(); i++) {
			
			int count = 1;
			
			while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				
				count++;
				
				i++;
				
			}
			
			string.append(str.charAt(i));
			
			if (count > 1) {
				
				string.append(count);
				
			}
			
		}

		return string.toString();
	}

}
