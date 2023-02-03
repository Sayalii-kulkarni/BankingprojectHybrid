package com.bankingProject.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingProject.base.BaseClass;

public class ManagerHomePagePom extends BaseClass{
	
	public ManagerHomePagePom() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement NewCustomer;
	
	public void clickOnNewCustomer() {
		NewCustomer.click();
		
	}

}
