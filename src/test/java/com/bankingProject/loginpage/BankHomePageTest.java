package com.bankingProject.loginpage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingProject.base.BaseClass;
import com.bankingProject.pom.BankHomePagePom;
import com.bankingProject.pom.CredentialPom;
import com.bankingProject.pom.LoginPagePom;
import com.bankingProject.utility.Utility;

public class BankHomePageTest  extends BaseClass{

	@BeforeClass
	public void setup() {
		launchWebsite();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	/*public String getEmailFromexcel() throws EncryptedDocumentException, IOException {
		FileInputStream fileinput = new FileInputStream(projectpath+ "\\src\\main\\resources\\Excel\\bank.xlsx");
		Sheet sh=WorkbookFactory.create(fileinput).getSheet("Sheet1");
		String email=sh.getRow(1).getCell(0).getStringCellValue();
		return email;
	}*/
	public void SaveinExcel() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		sheet.createRow(0).createCell(0).setCellValue("xyz@gmail.com");
		FileOutputStream fileOutputStream = new FileOutputStream(projectpath+"\\src\\test\\resources\\excel\\NewCredential.xlsx");
		workbook.write(fileOutputStream);
		
	}
	
	
	
	@Test
	public void testgetcredential() throws InterruptedException, EncryptedDocumentException, IOException {
		LoginPagePom loginPagePom = new LoginPagePom();
		Thread.sleep(2000);
		BankHomePagePom bankHomePagePom =loginPagePom.clickongetcredential();
		Thread.sleep(8000);
		Utility utility = new Utility();
		String Email = (String) utility.getSingleCellDataFromExcel(0, 0, "Sheet1");
		bankHomePagePom.setEmailid(Email);
		Thread.sleep(2000);
		CredentialPom credentialPom =bankHomePagePom.ClickOnSubmitButton();
		Thread.sleep(2000);
		credentialPom.saveCredentials();
		
	}
	/*@Test
	public void setEmailId() {
		BankHomePagePom bankHomePagePom =new BankHomePagePom();
		bankHomePagePom.setEmailid();
		
	}
	public void ClickOnSubmitButton() {
		BankHomePagePom bankHomePagePom =new BankHomePagePom();
		bankHomePagePom.ClickOnSubmitButton();
		
		
	}
	*/
	


}
