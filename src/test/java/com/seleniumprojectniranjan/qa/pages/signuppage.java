package com.seleniumprojectniranjan.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumprojectniranjan.qa.base.basetest;

public class signuppage extends basetest{

	WebDriver driver;
	
	public signuppage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordfield;
	
	@FindBy(xpath = "//input[@id='rmobile']")
	WebElement phonenofield;
	
	@FindBy(xpath = "//label[contains(text(),'I agree to the')]//span[@id='signup-termservice']")
	WebElement termsandconditioncheckbox;
	
	@FindBy(xpath = "//input[@id='signupbtn']")
	WebElement signupsubmitbutton;
	
	@FindBy(xpath = "(//div[@class='field-msg']//span[@id='email-error'])[1]")
	public List <WebElement> emailfielderrormessagelist;
	
	@FindBy(xpath = "(//div[@class='field-msg']//span[@id='email-error'])[1]")
	WebElement emailfielderrormessagetext;
	
	@FindBy(xpath = "(//span[@id='password-error'])[1]")
	WebElement passwordfielderrortest;
	
	@FindBy(xpath = "(//span[@id='password-error'])[1]")
	public List <WebElement> passwordfielderrortestlist;
	
	@FindBy(xpath = "(//span[@id='rmobile-error'])[1]")
	WebElement phonenofielderrortest;
	
	@FindBy(xpath = "(//span[@id='rmobile-error'])[1]")
	public List <WebElement> phonenofielderrortestlist;
	
	public void ClickOnSignUpSubmitButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("arguments[0].scrollIntoView(true);",signupsubmitbutton);
		signupsubmitbutton.click();
	}
	
	public void EnterAnEmail(String email) {
		emailfield.click();
		emailfield.sendKeys(email);
	}
	
	public void EnterAPassword(String password) {
		passwordfield.click();
		passwordfield.sendKeys(password);
	}
	
	public void EnterAPhoneNo(String phoneno) {
		phonenofield.click();
		phonenofield.sendKeys(phoneno);
	}
	
	public void ClickOnTermsAndConditionsCheckBox() {
		termsandconditioncheckbox.click();
	}
	
	public void Register(String email, String password, String phoneno) {
		EnterAnEmail(email);
		EnterAPassword(password);
		EnterAPhoneNo(phoneno);
		ClickOnTermsAndConditionsCheckBox();
		ClickOnSignUpSubmitButton();
	}
	
	public boolean IsEmailFieldErrorMessageDisplayed() {

		boolean noOptionsDisplay = false;
		List<WebElement> menus = emailfielderrormessagelist;
		if (menus.size() > 0) {
			noOptionsDisplay = true;
		} else {
			noOptionsDisplay = false;
		}
		return noOptionsDisplay;
	}
	
	public String GetTextOfErrormessageFromGmailfield() {
		return emailfielderrormessagetext.getText();		
	}
	
	public boolean IsPasswordFieldErrorMessageDisplayed() {

		boolean noOptionsDisplay = false;
		List<WebElement> menus = passwordfielderrortestlist;
		if (menus.size() > 0) {
			noOptionsDisplay = true;
		} else {
			noOptionsDisplay = false;
		}
		return noOptionsDisplay;
	}
	
	public boolean IsMobileFieldErrorMessageDisplayed() {

		boolean noOptionsDisplay = false;
		List<WebElement> menus = phonenofielderrortestlist;
		if (menus.size() > 0) {
			noOptionsDisplay = true;
		} else {
			noOptionsDisplay = false;
		}
		return noOptionsDisplay;
	}
	
	public String GetTextOfErrormessageFromPasswordfield() {
		return passwordfielderrortest.getText();		
	}
	
	public String GetTextOfErrormessageFromPhoneNofield() {
		return phonenofielderrortest.getText();		
	}
}
