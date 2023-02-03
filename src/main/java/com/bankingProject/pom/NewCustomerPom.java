package com.bankingProject.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingProject.base.BaseClass;

	public class NewCustomerPom extends BaseClass {
		
		public NewCustomerPom() {
		PageFactory.initElements(driver, this);
		
		}
		
		
		@FindBy(xpath = "//input[@name='name']")
		WebElement Customername;
		
		@FindBy(xpath = "//input[@name='rad1'][2]")
		WebElement Gender;
		
		@FindBy(xpath = "//input[@id='dob']")
		WebElement Dateofbirth;
		
		@FindBy(xpath = "//textarea[@name='addr']")
		WebElement Address;
		
		@FindBy(xpath = "//input[@name='city']")
		WebElement City;
		
		@FindBy(xpath = "//input[@name='state']")
		WebElement State;
		
		@FindBy(xpath = "//input[@name='pinno']")
		WebElement Pin;
		
		@FindBy(xpath = "//input[@name='telephoneno']")
		WebElement Telephoneno;
		
		@FindBy(xpath = "//input[@name='emailid']")
		WebElement Emailid;
		
		@FindBy(xpath = "//input[@name='sub']")
		WebElement Submit;
		
		public void setCustomerName(String name) {
			Customername.sendKeys(name);
		}
		
		public void setGender() {
			Gender.click();
		}
		public void setDob() {
			
		}
		public void setAddress(String address) {
			Address.sendKeys(address);
		}
		
		public void setCity(String city) {
			City.sendKeys(city);
		}
		public void setState(String state) {
			State.sendKeys(state);
		}
		public void setPin(CharSequence[] pin) {
			Pin.sendKeys(pin);
		}
		/*public void setTelephoneno(int Telephoneno) {
			Telephoneno.
		}*/
		public void setEmailid(String email) {
			Emailid.sendKeys(email);
		}
		public void clickonSubmit() {
			Submit.click();
		}
		
		

}
