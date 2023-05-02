package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory {
	
	
	public static WebDriver startApplication(WebDriver driver, String browsername, String appURL) {
		
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\SeleniumFrameWork\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		else if (browsername.equals("FireFox")) {
			
		}else if(browsername.equals("IE")) {
			
		}else {
			System.out.println("we do not support this browser");
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
