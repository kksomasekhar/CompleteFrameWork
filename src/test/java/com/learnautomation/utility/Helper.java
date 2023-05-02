package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	
	public static String captureScreeshot(WebDriver driver) {
		
		File sorce = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screeshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+ getCurruntDateTime() +".png";
		
		try {
			FileUtils.copyFile(sorce, new File(screeshotPath));
			
			System.out.println("Screenshot captured ");
		} catch (IOException e) {
			System.out.println("Unable to take screensht"+e.getMessage());
		}
		
		return screeshotPath;
		
	}
	
	public static String getCurruntDateTime() {
		
	DateFormat customFormate= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	
	Date customDate = new Date(); 
		return customFormate.format(customDate);
		
	}
	
}
