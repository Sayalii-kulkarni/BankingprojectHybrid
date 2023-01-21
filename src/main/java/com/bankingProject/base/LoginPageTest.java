package com.bankingProject.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass{

	@BeforeClass
	public void setUp() {
		launchWebsite();
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	@Test
	public void testTitle() {
		String pageTitle =driver.getTitle();
		
		if(pageTitle.equalsIgnoreCase("GTPL Bank Home Page")) {
			System.out.println("We are on correct page");
		}
		else {
				System.out.println("We are on wrong page");
			}
		}
	}


