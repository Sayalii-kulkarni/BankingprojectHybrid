package com.bankingProject.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static String projectpath =System.getProperty("user.dir");
	
	public void launchWebsite() {
		
		System.out.println("projectpath");
		
		System.setProperty("webdriver.chrome.driver",projectpath+ "\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		
		
		
	}


}
