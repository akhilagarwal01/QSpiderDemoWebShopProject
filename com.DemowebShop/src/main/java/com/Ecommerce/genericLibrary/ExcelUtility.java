package com.Ecommerce.genericLibrary;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class ExcelUtility {

	public static Object[][] readExcel(String excelPath, String sheetName) {
		Object[][] data = null;
		try {
			FileInputStream f = new FileInputStream(excelPath);
			Workbook workbook = WorkbookFactory.create(f);
			Sheet sheet = workbook.getSheet(sheetName);
			int row = sheet.getPhysicalNumberOfRows();
			int cell = sheet.getRow(0).getPhysicalNumberOfCells();

			// define object array
			data = new Object[row - 1][cell];

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < cell; j++) {
					data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}

		} catch (Exception e) {
			Reporter.log("Unable to find excel file");
		}
		return data;
	}

}
