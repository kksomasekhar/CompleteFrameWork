package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogibePage {

	public static WebDriver driver;
		
		public LogibePage(WebDriver ldriver) {
			
			this.driver=ldriver;
		}
		
		@FindBy(xpath="//div//ul/a[contains(@class,'btn')]") WebElement loginButtonHome;
		@FindBy(name="email") WebElement username;
		@FindBy(name="password") WebElement password;
		@FindBy(xpath="//form//div[contains(text(),'Login')]") WebElement loginButton;
		@FindBy(xpath="//span/a[contains(text(),'Free account')]") WebElement freeCrmaHeader;
		
		
		
		/*
		 * This is a ligin method business logic 
		 */
		public void loginToCRAM(String unserNameAplication, String passwordApplication) {
			
			
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				
			}
			
			loginButtonHome.click();
			username.sendKeys(unserNameAplication);
			password.sendKeys(passwordApplication);
			loginButton.click();
			//freeCrmaHeader.isDisplayed();
			
		}
		
}


