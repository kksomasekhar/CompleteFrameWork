package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataprovider {

	Properties pro;
	public ConfigDataprovider() throws IOException {
		

		File src = new File("D:\\Selenium\\SeleniumFrameWork\\cogfig\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			System.out.println("Not aboe to loed Config file"+e.getMessage());
		}
	}
	
	
	public String getDataFromConfug(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
	
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getStringURL() {
		return pro.getProperty("qaURL");
	}
}
