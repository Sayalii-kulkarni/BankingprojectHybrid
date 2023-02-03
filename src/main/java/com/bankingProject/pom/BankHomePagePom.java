package com.bankingProject.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingProject.base.BaseClass;

public class BankHomePagePom extends BaseClass {

	public BankHomePagePom() {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement Emailid;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement SubmitButton;
	
	public void setEmailid(String Email) {
	Emailid.sendKeys(Email);
	
	
	}
	
	public CredentialPom ClickOnSubmitButton() {
		SubmitButton.click();
		return new CredentialPom();
		
	}
	
	
	
}


