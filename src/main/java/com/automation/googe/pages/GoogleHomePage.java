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
	
	@FindBy(xpath = "(//li[contains(@class,'sbct') and contains(@jsaction,'click')])[3]")
	WebElement lbl_SearchResultThirdIndex;
	
	
	
	
	
	public GoogleHomePage(WebDriver driver) {
		super(driver);
		GoogleHomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchAText() {
		String searchWord = Constants.getProperty("SearchWord");
		setElement(driver,textbox_Search,searchWord, "Success :- Entered Search Word as "+searchWord, "Failed :- Unable to enter search word");
		hoverOnThirdElement();
		clickOnElement(driver,btn_GoogleSearch, "Success :- Clicked on Google Search", "Failed :- Unable to Click on Google Search");
	}
	
	public void hoverOnThirdElement() {
		hoverOnElement(driver, lbl_SearchResultThirdIndex, "Success :- Hovered On Third Index of Search Result", "Failed :- Unable to Hover on Third Index of Search Result");
	}
	
	

}
