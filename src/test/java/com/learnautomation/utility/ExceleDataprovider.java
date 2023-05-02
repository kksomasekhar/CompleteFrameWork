package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExceleDataprovider {

	Workbook wb;

	public ExceleDataprovider() {

		File src = new File("D:\\Selenium\\SeleniumFrameWork\\Testdata\\Data.xlsx");

		try {

			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file" + e.getMessage());
		}

	}
	
public String getStringData(int sheetIndux, int row, int column) {
		
		return wb.getSheetAt(sheetIndux).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public String getStringData(String sheetName, int row, int column) {
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public double getNumberData(String sheetName, int row, int column) {	
		
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
