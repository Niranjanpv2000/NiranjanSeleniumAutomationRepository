package com.seleniumprojectniranjan.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumprojectniranjan.qa.base.basetest;
import com.seleniumprojectniranjan.qa.utils.utilities;

public class loginpage extends basetest{

	WebDriver driver;

	public loginpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='login_id']")
	WebElement mailidfield;

	@FindBy(xpath = "//button[@id='nextbtn']")
	WebElement nextbutton;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordfield;
	
	@FindBy(xpath = "(//div[@class='fielderror errorlabel'])[1]")
	public List <WebElement> mailidfielderrortextforlist;
	
	@FindBy(xpath = "//div[@id='password_container']//div[@class='fielderror errorlabel']")
	public List <WebElement> passwordfielderrortextforlist;
	
	@FindBy(xpath = "//button[@id='nextbtn']//span[contains(text(),'Sign in')]")
	WebElement signinbutton;
	
	
	public void EnterUserName(String strUserName) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login_id']")));
			mailidfield.click();
			mailidfield.sendKeys(strUserName);
		} catch (Exception e) {
			System.out.println("Not able to enter Mail Id due to " + e.toString());
		}
	}

	public void EnterUserPassWord(String strUserName) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(utilities.IMPLICIT_WAIT_TIME));
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
			passwordfield.click();
			passwordfield.sendKeys(strUserName);
		} catch (Exception e) {
			System.out.println("Not able to enter Password due to " + e.toString());
		}
	}

	public void ClickNextButton() {
		try {
			nextbutton.click();
		} catch (Exception e) {
			System.out.println("Not able to click next button " + e.toString());
		}
	}
	
	public void ClickSignInButton() {
		try {
			signinbutton.click();
		} catch (Exception e) {
			System.out.println("Not able to click on sign in button " + e.toString());
		}
	}

	public void LoginToPortal(String UserName, String Password) {
		EnterUserName(UserName);
		ClickNextButton();
		waitForPageLoad(2000);
		EnterUserPassWord(Password);
		ClickSignInButton();
	}

	public boolean IsUserNameFieldErrorMessageDisplayed() {

		boolean noOptionsDisplay = false;
		List<WebElement> menus = mailidfielderrortextforlist;
		if (menus.size() > 0) {
			noOptionsDisplay = true;
		} else {
			noOptionsDisplay = false;
		}
		return noOptionsDisplay;
	}
	
	public boolean IsPasswordFieldErrorMessageDisplayed() {

		boolean noOptionsDisplay = false;
		List<WebElement> menus = passwordfielderrortextforlist;
		if (menus.size() > 0) {
			noOptionsDisplay = true;
		} else {
			noOptionsDisplay = false;
		}
		return noOptionsDisplay;
	}
	
	
	
}
