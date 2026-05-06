package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilListFramework {

	public static List<Map<String, String>> readdata(String fileName, String sheetName) {
		List<Map<String, String>> data = null;
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + fileName);
			try (XSSFWorkbook excel = new XSSFWorkbook(file)) {
				XSSFSheet sheetDetail = excel.getSheet(sheetName);
				int totalNoOfRow = sheetDetail.getPhysicalNumberOfRows();
				int totalNoOfColumn = sheetDetail.getRow(0).getPhysicalNumberOfCells();
				data = new ArrayList<Map<String, String>>();

				for (int row = 1; row < totalNoOfRow; row++) {

					Map<String, String> celldata = new LinkedHashMap<String, String>();

					for (int column = 0; column < totalNoOfColumn; column++) {

						String cellKeyValue = sheetDetail.getRow(0).getCell(column).getStringCellValue();
						String cellValue = sheetDetail.getRow(row).getCell(column).getStringCellValue();
						celldata.put(cellKeyValue, cellValue);

					}

					data.add(celldata);

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}

}
