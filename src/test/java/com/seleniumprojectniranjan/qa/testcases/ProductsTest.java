package com.seleniumprojectniranjan.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.seleniumprojectniranjan.qa.base.basetest;
import com.seleniumprojectniranjan.qa.pages.homepage;
import com.seleniumprojectniranjan.qa.pages.loginpage;
import com.seleniumprojectniranjan.qa.pages.productspage;
import com.seleniumprojectniranjan.qa.utils.utilities;

public class ProductsTest extends basetest{
	SoftAssert softAssert = new SoftAssert();
	boolean isTestPassed = false;
	loginpage loginpageobj;
	homepage homepageobj;
	productspage productspageobj;

	public ProductsTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		driver = InitializeBrowserAndApplicationUrl(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

		homepageobj = new homepage(driver);
		loginpageobj = new loginpage(driver);
		productspageobj = new productspage(driver);
		homepageobj.ClickSignIn();
		waitForPageLoad(4000);		
	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] supplyTestData() {
		Object[][] data = utilities.getTestDataFromExcel("login");
		return data;
	}
	
	/********************
	 * Test case to Verify Products
	 **************************************/
	
	@Test(dataProvider = "supplyTestData")
	public void Verifyproducts(String username, String password) {
		try {
			loginpageobj.LoginToPortal(username, password);
			waitForPageLoad(4000);
			homepageobj.ClickProducts();
			String expected = dataProp.getProperty("productnames");
			String actual = productspageobj.GetAllProductnames();
			if (expected.equalsIgnoreCase(actual)) {
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
