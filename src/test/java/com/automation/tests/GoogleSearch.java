package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.commons.CommonBrowserFunctions;
import com.automation.googe.pages.GoogleHomePage;

public class GoogleSearch extends CommonBrowserFunctions {
	
	static WebDriver driver;
	
	public GoogleSearch() {
		super(driver);
	}
	
	@Test
	public void search_test() {
		try {
			openBrowser("CHROME");
			navigateToURL(Constants.getProperty("URL"));
			search();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search() {
		GoogleHomePage objGoogleHomePage = new GoogleHomePage(getDriver());
		objGoogleHomePage.searchAText();
	}

}
