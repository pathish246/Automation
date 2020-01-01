package com.automation.testdatamanagment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class FetchData {

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
	
	@Test
	public void readData(ITestContext context) throws IOException {
		test(context);
	}
	
	public void test(ITestContext context) throws IOException {
		List<HashMap<String, String>> records = new ArrayList<HashMap<String, String>>();
		try {
			boolean runModeFound = false;
			int ColumnIndexRunMode = 0;
			String applicationName = context.getCurrentXmlTest().getName();
			String testDataPath = getTestFilePath(applicationName);
			File objFile = new File(testDataPath);
			FileInputStream objFileInputStream = new FileInputStream(objFile);
	        XSSFWorkbook objXSSFWorkbook = new XSSFWorkbook (objFileInputStream);
	        XSSFSheet objXSSFSheet = objXSSFWorkbook.getSheet("Search");
	        Row objFirstRow = objXSSFSheet.getRow(0);
	        int LastRow = objXSSFSheet.getLastRowNum();
	        String CellValue = "";
	        int ColumnCount = objFirstRow.getLastCellNum();
	        List<Integer> listOfRunModeYes = new ArrayList<Integer>(); 
	        for(int i=0;i<ColumnCount;i++) {
	        	Cell objCell = objFirstRow.getCell(i);
	        	CellValue = objCell.getStringCellValue();
	        	if(CellValue.equalsIgnoreCase("RUNMODE")) {
	        		ColumnIndexRunMode = i;
	        		runModeFound = true;
	        	}
	        }
	        
	        if(runModeFound==false) {
	        	Assert.fail("Configuration Issue :: Run Mode Column is Missing");
	        }
	        // we got which row is Run Mode 
	        
	        Row objRow;
	        
	        for(int i=1;i<LastRow;i++) {
	        	objRow = objXSSFSheet.getRow(i);
	        	Cell objCell = objRow.getCell(ColumnIndexRunMode);
	        	CellValue = objCell.getStringCellValue();
	        	if(CellValue.equalsIgnoreCase("Yes")) {
	        		listOfRunModeYes.add(i);
	        	}
	        }
	        // by this we got number of Test Cases to be executed
	        Cell objCellValue;
	        Cell objCellKey;
	        String CellKey;
	        
	        HashMap<String, String> singleRecord;
	        
	        for(int RunModeYes : listOfRunModeYes) {
	        	singleRecord = new HashMap<String, String>();
	        	objRow = objXSSFSheet.getRow(RunModeYes);
	        	for(int i=0;i<ColumnCount;i++) {
	        		objCellKey = objFirstRow.getCell(i);
	        		objCellValue = objRow.getCell(i);
	        		CellKey = objCellKey.getStringCellValue();
	        		CellValue = objCellValue.getStringCellValue();
	        		singleRecord.put(CellKey, CellValue);
	        	}
	        	records.add(singleRecord);
	        }
		}catch(Exception e) {
			System.out.println("Te st");
		}
		System.out.println(records);
        
	}
	
	
	
}
