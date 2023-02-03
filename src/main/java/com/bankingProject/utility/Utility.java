package com.bankingProject.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.bankingProject.base.BaseClass;


public class Utility extends BaseClass {

		
		FileInputStream fileinputstream;
		
		public Utility() {
			try {
				this.fileinputstream = new FileInputStream(projectpath+"\\src\\main\\resources\\Excel\\bank.xlsx");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		
		
			public void getAllExcelSheetData(String sheetName) throws EncryptedDocumentException, IOException {
			Sheet sh = WorkbookFactory.create(fileinputstream).getSheet(sheetName);
			HashMap<String, Object> hmap = new HashMap<>();
		 	for(int i=0; i<=sh.getLastRowNum();i++) {
		 		int cellCount = sh.getRow(i).getLastCellNum();
			 	for(int j=0; j<cellCount;j++) {
			 		if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("string")) {
			 			sh.getRow(i).getCell(j).getStringCellValue();
			 		}
		 			else if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("numreic")) {
		 				sh.getRow(i).getCell(j).getNumericCellValue();
			 		}
		 		}
		 	}
			
	 	}
			
			
			public Object getSingleCellDataFromExcel(int row, int cell,String sheetName) throws EncryptedDocumentException, IOException {
				
				Sheet sh = WorkbookFactory.create(fileinputstream).getSheet("Sheet1");
				Object data = "";
				
				if(sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("string"))
					data = sh.getRow(row).getCell(cell).getStringCellValue();
				else if(sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("numeric"))
					data = sh.getRow(row).getCell(cell).getNumericCellValue();
				return data;
			} 
			public String getScreenshot(String screenshotname) throws IOException {
				
				File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String destpath=projectpath + "\\Screenshot\\"+screenshotname+".jpeg";
				FileUtils.copyFile(screenshot,new File(destpath));
				return destpath;
			}
			
			public void createExtentReport() {
				ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(projectpath+"//extentReport//extent.html");
				ExtentReports extentReports = new ExtentReports();
				extentReports.attachReporter(extentsparkreporter);
				
				
				
			}
			
	 	
		

}


