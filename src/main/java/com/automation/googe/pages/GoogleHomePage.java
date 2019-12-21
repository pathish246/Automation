package com.automation.googe.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.commons.BasePage;

public class GoogleHomePage extends BasePage {
	
	static WebDriver driver;
	
	@FindBy(name = "q")
	WebElement textbox_Search;
	
	@FindBy(xpath = "(//*[contains(@name,'btnK')])[1]")
	WebElement btn_GoogleSearch;
	
	
	
	public GoogleHomePage(WebDriver driver) {
		super(driver);
		GoogleHomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchAText() {
		String searchWord = Constants.getProperty("SearchWord");
		setElement(driver,textbox_Search,searchWord, "Success :- Entered Search Word as "+searchWord, "Failed :- Unable to enter search word");
		clickOnElement(driver,btn_GoogleSearch, "Success :- Clicked on Google Search", "Failed :- Unable to Click on Google Search");
		
	}
	
	

}
