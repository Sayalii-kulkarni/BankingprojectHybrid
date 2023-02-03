package com.bankingProject.loginpage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingProject.base.BaseClass;
import com.bankingProject.pom.ManagerHomePagePom;
import com.bankingProject.pom.NewCustomerPom;

public class NewCustomerTest extends BaseClass {
	
	@BeforeClass
	public void setup() {
		launchWebsite();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		}
	@Test
	public void fillDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		LoginPageTest loginpage = new LoginPageTest();
		loginpage.clickOnLoginButton();
		ManagerHomePagePom managerhomepagepom = new ManagerHomePagePom();
		Thread.sleep(4000);
		managerhomepagepom.clickOnNewCustomer();
		Thread.sleep(4000);
		NewCustomerPom newcustomerpom =new NewCustomerPom();
		newcustomerpom.setCustomerName("Sayali");
		Thread.sleep(4000);
		newcustomerpom.setGender();
		
	}
	
	
	
}
