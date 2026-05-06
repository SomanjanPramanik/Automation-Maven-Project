package com.framework.utilities;

import java.util.List;
import java.util.Map;

public class ReadExcelDataMain {

	public static void main(String[] args) {
		// calling common method
		String[][] data = ExcelUtil.readExcel("Test Data1.xlsx", "Sheet1");
		for (String[] dataInrow : data) { // Elements(here it is also an array) store in array named "data"
			for (String value : dataInrow) {// Elements(here string values) store in the elements that were in main
											// array(data)
				System.out.print(" " + value + " ");
			}
			System.out.println();
		}

		System.out.println(
				"============================================================================================================");

		// calling List method
		List<Map<String, String>> readData = ExcelUtilListFramework.readdata("Test Data1.xlsx", "Sheet1");
		for (Map<String, String> columnData : readData) {
			for (String value : columnData.keySet()) {
				System.out.print("   " + columnData.get(value) + "   ");
			}
			System.out.println();
		}

	}

}
