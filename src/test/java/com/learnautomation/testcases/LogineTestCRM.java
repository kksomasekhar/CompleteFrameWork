package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LogibePage;


public class LogineTestCRM extends BaseClass {
	

	@Test
	public void loginApp() {
		
		
		//System.out.println(driver.getTitle());
		
		logger=report.createTest("Login to CRM");
		
		LogibePage loginpage = PageFactory.initElements(driver, LogibePage.class);
		
		logger.info("Starting applycation");
		
		loginpage.loginToCRAM(exele.getStringData("Login", 0, 0), exele.getStringData("Login", 0, 1));
		
		logger.pass("Login scussful");
	}

}
