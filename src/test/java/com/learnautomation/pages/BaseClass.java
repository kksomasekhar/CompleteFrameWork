package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataprovider;
import com.learnautomation.utility.ExceleDataprovider;
import com.learnautomation.utility.Helper;



public class BaseClass {

	public static WebDriver driver;
	public static ExceleDataprovider exele;
	public static ConfigDataprovider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpsuit() throws IOException {

		Reporter.log("Setting up report and test is getting ready", true);

		exele = new ExceleDataprovider();
		config = new ConfigDataprovider();

		ExtentReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/FreeCRM+" + Helper.getCurruntDateTime() + ".html"));
		System.out.println(System.getProperty("user.dir"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setup() {

		Reporter.log("Trying to start browser and getting applycation ready", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStringURL());
		Reporter.log("Applycation is up and running", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {

		Reporter.log("Test is about to end", true);

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreeshot(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreeshot(driver)).build());
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test skiped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreeshot(driver)).build());
		}

		report.flush();

		Reporter.log("Test completed", true);
	}

}
