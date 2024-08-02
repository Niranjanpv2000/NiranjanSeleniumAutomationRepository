package com.seleniumprojectniranjan.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.seleniumprojectniranjan.qa.utils.extentreporter;
import com.seleniumprojectniranjan.qa.utils.utilities;

public class mylisteners implements ITestListener {

	ExtentReports extendReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		
		extendReport = extentreporter.generateExtentReport();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extendReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " Started Executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName() + " Successfully Executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destinationScreenshotPath = utilities.captureScreenshot(driver, result.getName());

		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " Skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extendReport.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
	    File extentReport = new File(pathOfExtentReport);
	    
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
