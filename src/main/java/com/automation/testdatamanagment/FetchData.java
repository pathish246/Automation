package com.automation.testdatamanagment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class FetchData {

	@Test
	public void test() {
		getTestFilePath("GOOGLE");
	}
	
	public String getTestFilePath(String applicationName) {
		String Path = System.getProperty("user.dir");
		switch (applicationName.toUpperCase()) {
		case "GOOGLE":
			Path = Path.concat("\\src\\main\\resources\\TestData\\GoogleSearch.xlsx");
			break;

		default:Assert.fail("Please Pass Valid Application Name");
			break;
		}
		return Path;
	}
	
	public void readData(ITestContext context) throws IOException {
		String applicationName = context.getCurrentXmlTest().getName();
		String testDataPath = getTestFilePath(applicationName);
		File objFile = new File(testDataPath);
		FileInputStream objFileInputStream = new FileInputStream(objFile);
        XSSFWorkbook objXSSFWorkbook = new XSSFWorkbook (objFileInputStream);
        XSSFSheet objXSSFSheet = objXSSFWorkbook.getSheet("Sheet");
        Row objRow = objXSSFSheet.getRow(0);
        String CellValue = "";
        int ColumnCount = objRow.getLastCellNum();
        for(int i=0;i<ColumnCount;i++) {
        	Cell objCell = objRow.getCell(i);
        	CellValue = objCell.getStringCellValue();
        	if(CellValue.equalsIgnoreCase("RUNMODE")) {
        		
        	}
        }
        
	}
	
	
	
}
