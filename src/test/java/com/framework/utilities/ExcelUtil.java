package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static String[][] readExcel(String fileNmae, String sheetName) {
		String[][] data = null;
		// C:\AutomationTraining\AutomationMavenProject\TestData\Test Data.xlsx
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + fileNmae); // file
																													// path
			try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
				XSSFSheet sheet = workbook.getSheet(sheetName);// adding sheet details to the overall file
				int rowNo = sheet.getPhysicalNumberOfRows();// row no.
				int clmnNo = sheet.getRow(0).getPhysicalNumberOfCells();// in 0th row we usually save headings of the
																		// columns
				data = new String[rowNo - 1][clmnNo]; // we don't need the headings as test data so we avoided it
				// also ^ this actually defines the size of 2-D array
				// Now to fetch data we'll use for loop... more specifically nested for loop
				for (int r = 1; r < rowNo; r++) {// avoiding 0th row 'cuz we don't need that
					for (int c = 0; c < clmnNo; c++) {

						data[r - 1][c] = sheet.getRow(r).getCell(c).getStringCellValue();
						// usually if we would do that we would go for data[0][0] = .....; data[0][1] =
						// .....; data[0][2] = .....;
						// but we'll do here the parameters data[r][c] but r starts from 1 so we
						// decrease the value
					}
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
