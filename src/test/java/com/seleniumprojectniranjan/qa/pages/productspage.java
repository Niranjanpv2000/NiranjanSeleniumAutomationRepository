package com.seleniumprojectniranjan.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumprojectniranjan.qa.base.basetest;

public class productspage extends basetest{
	WebDriver driver;
	public productspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='sub-headmenu sub-headmenu1']//li//span")
	public List <WebElement> productnames;
	
	public String GetAllProductnames()
    {
		List<WebElement> options = productnames;
		List<String> optionTexts = new ArrayList<>();
		for (WebElement option : options) {
            optionTexts.add(option.getText());
        }        
        return String.join(", ", optionTexts);
    }
}
