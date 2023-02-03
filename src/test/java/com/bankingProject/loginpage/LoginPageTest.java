package com.bankingProject.loginpage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bankingProject.base.BaseClass;
import com.bankingProject.pom.LoginPagePom;
import com.bankingProject.pom.ManagerHomePagePom;
import com.bankingProject.pom.NewCustomerPom;
import com.bankingProject.utility.Utility;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class LoginPageTest extends BaseClass {
	
	LoginPagePom loginPagePom;
	ExtentTest extenttest;
	ExtentReports extentReports ;
	
	@BeforeClass()
	public void setUp() {
		launchWebsite();
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(projectpath+"//extentReport//extent.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentsparkreporter);
		
		//driver.get("https://demo.guru99.com/V1/index.php");
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
	switch (result.getStatus()) {
	case 1:
		extenttest.log(Status.PASS, "test case pass with correct Url");
		break;
	case 2:
		extenttest.log(Status.FAIL, "test case FAIL with INcorrect Url");
		break;
			
	case 3:
		extenttest.log(Status.SKIP, "test case SKIPPED...");
		break;
				

	default:
		break;
	}
		
		extentReports.flush();
		driver.close();
	}
	@Test
	public void testTitle() throws IOException {
		Utility utility = new Utility();
		extenttest = extentReports.createTest("testTitle");
		String pageTitle =driver.getCurrentUrl();
		extenttest.log(Status.PASS, pageTitle);
		extenttest.addScreenCaptureFromPath(utility.getScreenshot("testTitle"), pageTitle);
		
		//utility.getScreenshot("testTitle")
		Assert.assertEquals(pageTitle, "https://demo.guru99.com/V1/index.php");
		
		/*if(pageTitle.equalsIgnoreCase("https://demo.guru99.com/V1/index.php")) {
			System.out.println("We are on correct url");
		}
		else {
				System.out.println("We are on wrong url");
			}*/
	}
		@Test
		public void clickOnLoginButton() throws EncryptedDocumentException, IOException, InterruptedException {
			
			loginPagePom = new LoginPagePom();
			Utility utility = new Utility();
			String userid=(String) utility.getSingleCellDataFromExcel(1, 0, "Sheet1");
			loginPagePom.setUsername(userid);
			Utility utility1 = new Utility();
			String password=(String) utility1.getSingleCellDataFromExcel(2, 0, "Sheet1");
			loginPagePom.setPassword(password);
			Thread.sleep(2000);
			loginPagePom.clickOnLoginButton();
			Thread.sleep(2000);
			/*ManagerHomePagePom managerhomepagepom = new ManagerHomePagePom();
			Thread.sleep(4000);
			managerhomepagepom.clickOnNewCustomer();
			Thread.sleep(4000);
			NewCustomerPom newcustomerpom =new NewCustomerPom();
			newcustomerpom.setCustomerName("Sayali");
			Thread.sleep(4000);
			newcustomerpom.setGender();*/
			
		}
		
		
		
		
		
}	
	




