package com.seleniumprojectniranjan.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.seleniumprojectniranjan.qa.base.basetest;
import com.seleniumprojectniranjan.qa.pages.homepage;
import com.seleniumprojectniranjan.qa.pages.signuppage;
import com.seleniumprojectniranjan.qa.utils.utilities;

public class RegisterTest extends basetest {
	
	signuppage signuppageobj;
	SoftAssert softAssert = new SoftAssert();
	boolean isTestPassed = false;
	String expected = "true";

	public RegisterTest() {
		super();
	}

	public WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		driver = InitializeBrowserAndApplicationUrl(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

		homepage homepageobj = new homepage(driver);
		homepageobj.ClickSignUp();
		waitForPageLoad(4000);
		signuppageobj = new signuppage(driver);
	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}

	/********************
	 * Test cases to Check Registration Functionality
	 **************************************/

	@Test(enabled = false)
	public void RegistrationWithvalidCredentials() {
		String email = utilities.getAutoGeneratedEmailId("validemail");
		String password = "password" + utilities.getStringNumberForCurrentTime();
		String phoneno = dataProp.getProperty("phoneno");
		signuppageobj.Register(email, password, phoneno);
	}

	@Test
	public void VerifyInvalidEmailInEmailField() {
		try {
			signuppageobj.EnterAnEmail("invalidemil");
			signuppageobj.ClickOnSignUpSubmitButton();
			String actual = String.valueOf(signuppageobj.IsEmailFieldErrorMessageDisplayed());;			
			String expectedtwo = dataProp.getProperty("emailfieldinvalidemessage");
			String actualtwo = signuppageobj.GetTextOfErrormessageFromGmailfield();
			if (expected.equalsIgnoreCase(actual) & expectedtwo.equalsIgnoreCase(actualtwo)) {
				isTestPassed = true;
			} else {
				isTestPassed = false;
			}
		} catch (Exception testException) {

			isTestPassed = false;
			System.out.println("Exception due to " + testException);
		}
		softAssert.assertTrue(isTestPassed);
		softAssert.assertAll();
	}

	@Test
	public void VerifyExistingEmailInEmailField() {		
		try {
			signuppageobj.EnterAnEmail(prop.getProperty("username"));
			signuppageobj.ClickOnSignUpSubmitButton();
			String actual = String.valueOf(signuppageobj.IsEmailFieldErrorMessageDisplayed());
			String expectedtwo = dataProp.getProperty("emailfieldexistingemailmessage");
			String actualtwo = signuppageobj.GetTextOfErrormessageFromGmailfield();
			if (expected.equalsIgnoreCase(actual) & expectedtwo.equalsIgnoreCase(actualtwo)) {
				isTestPassed = true;
			} else {
				isTestPassed = false;
			}
		} catch (Exception testException) {

			isTestPassed = false;
			System.out.println("Exception due to " + testException);
		}
		softAssert.assertTrue(isTestPassed);
		softAssert.assertAll();
	}

	@Test
	public void VerifyInvalidPasswordInPasswordField() {
		try {
			signuppageobj.EnterAPassword("ABCD");
			signuppageobj.ClickOnSignUpSubmitButton();
			String actual = String.valueOf(signuppageobj.IsPasswordFieldErrorMessageDisplayed());
			String expectedtwo = dataProp.getProperty("passwordfielderrormessage");
			String actualtwo = signuppageobj.GetTextOfErrormessageFromPasswordfield();
			if (expected.equalsIgnoreCase(actual) & expectedtwo.equalsIgnoreCase(actualtwo)) {
				isTestPassed = true;
			} else {
				isTestPassed = false;
			}
		} catch (Exception testException) {

			isTestPassed = false;
			System.out.println("Exception due to " + testException);
		}
		softAssert.assertTrue(isTestPassed);
		softAssert.assertAll();
	}

	@Test
	public void VerifyInvalidPhoneNoInPhoneNoField() {
		try {
			signuppageobj.EnterAPhoneNo("invalidphoneno");
			signuppageobj.ClickOnSignUpSubmitButton();
			String actual = String.valueOf(signuppageobj.IsMobileFieldErrorMessageDisplayed());
			String expectedtwo = dataProp.getProperty("phonenofielderrormessage");
			String actualtwo = signuppageobj.GetTextOfErrormessageFromPhoneNofield();
			if (expected.equalsIgnoreCase(actual) & expectedtwo.equalsIgnoreCase(actualtwo)) {
				isTestPassed = true;
			} else {
				isTestPassed = false;
			}
		} catch (Exception testException) {

			isTestPassed = false;
			System.out.println("Exception due to " + testException);
		}
		softAssert.assertTrue(isTestPassed);
		softAssert.assertAll();
	}

}
