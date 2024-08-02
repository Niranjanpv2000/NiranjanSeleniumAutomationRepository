package com.seleniumprojectniranjan.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.seleniumprojectniranjan.qa.utils.utilities;

public class basetest {

	public static WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public basetest() {
		
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\seleniumprojectniranjan\\qa\\config\\config.properties");
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\seleniumprojectniranjan\\qa\\testdata\\testdata.properties");
		
		try {
			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
				
		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	

	public WebDriver InitializeBrowserAndApplicationUrl(String browsername) {
		
		if(browsername.equalsIgnoreCase("chrome")){
			//driver = new ChromeDriver();
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
	
		}else if(browsername.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
	    }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}
	
	public void waitForPageLoad(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
