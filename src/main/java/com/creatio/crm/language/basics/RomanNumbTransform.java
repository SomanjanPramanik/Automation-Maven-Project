package com.creatio.crm.language.basics;

public class RomanNumbTransform {

	public static void main(String[] args) {
		
           System.out.println(romanNum(555));
		
	}

	public static StringBuffer romanNum(int num) {

		StringBuffer str = new StringBuffer();

		int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%d , %d",num,numbers[i]);
			System.out.println();
			while (num >= numbers[i]) {
               num = num - numbers[i];
               System.out.println(num);
               str.append(symbols[i]);
               System.out.println(str);
			}
		}
		return str;
	}

}
