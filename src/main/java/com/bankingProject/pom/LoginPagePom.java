package com.bankingProject.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingProject.base.BaseClass;

public class LoginPagePom extends BaseClass  {
	
	

	
	public LoginPagePom() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='uid']")
	WebElement userId;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//input[@name='btnReset']")
	WebElement resetbutton;
	
	@FindBy(xpath="//a[@href='http://demo.guru99.com/']")
	WebElement visit;

	
	public void setUsername(String userid) {
		userId.sendKeys(userid);
		
	}
	public void setPassword(String password) {
		Password.sendKeys(password);
	}
	public ManagerHomePagePom clickOnLoginButton() {
		
		loginbutton.click();
		
		return new ManagerHomePagePom();
		
		
	}
	
	
	public BankHomePagePom clickongetcredential() {
		visit.click();
		/*if(visit.isDisplayed()) {
			driver.switchTo().frame(visit);
			driver.close();
			
		}*/
		
		return new BankHomePagePom();
	}

	

	
	
	

}
