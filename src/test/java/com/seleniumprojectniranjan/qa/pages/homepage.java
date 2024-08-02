package com.seleniumprojectniranjan.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumprojectniranjan.qa.base.basetest;

public class homepage extends basetest{

	WebDriver driver;

	public homepage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='signupcontainer']//a)[1]")
	WebElement signin;
	
	@FindBy(xpath = "//div[@class='signupcontainer']//a[@class='signUp']")
	WebElement signup;
	
	@FindBy(xpath = "(//li[@class='zh-productdropdown']//span[@class='pd-dp'])[1]")
	WebElement products;

	public void ClickSignIn() {
		try {
			signin.click();
		} catch (Exception e) {
			System.out.println("Not able to click on sign in button " + e.toString());
		}
	}

	public void ClickSignUp() {
		try {
			signup.click();
		} catch (Exception e) {
			System.out.println("Not able to click next button " + e.toString());
		}
	}
	
	public void ClickProducts() {
		try {
			products.click();
		} catch (Exception e) {
			System.out.println("Not able to click products " + e.toString());
		}
	}

}
