package com.automation.commons;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CommonBrowserFunctions extends BasePage {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void beforeActions() throws IOException {
		loadConstantsFile();
	}
	
	@AfterClass
	public void afterActions() {
		closeBrowser();
	}
	
	public CommonBrowserFunctions(WebDriver driver) {
		super(driver);
		CommonBrowserFunctions.driver = driver;
	}
	
	public void openBrowser(String Browser) {
		switch (Browser.toUpperCase()) {
		case "FIREFOX":
			
			break;
			
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "A:\\Automation\\AutomationFiles\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:Assert.fail("Please Pass Valid Browser Name");
			break;
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		CommonBrowserFunctions.driver = driver;
	}

	public void navigateToURL(String URL) {
		logger.debug("Navigating To URL "+URL);
		driver.get(URL);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void takeScreenshot() throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(""));
	}

}
