package com.Ecommerce.genericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass implements IAutoConstant {

	public static WebDriver driver;
	public FileUtility f = new FileUtility();;
	public WebDriverUtility u = new WebDriverUtility();

	@BeforeSuite
	public void connectServer() {
		Reporter.log("== Server Connected == ", true);
	}

	@BeforeTest
	public void connectDatabaseConnection() {
		Reporter.log("== Database Connected succcessfully == ", true);
	}

	@BeforeClass
	public void setUp() {
		String browser = f.getDataFromProperty(PROP_PATH, "browser");
		String url = f.getDataFromProperty(PROP_PATH, "url");

		switch (browser.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			Reporter.log("== Browser launched successfully == ", true);
			break;

		case "edge":
			driver = new EdgeDriver();
			Reporter.log("== Browser launched successfully == ", true);
			break;

		case "firefox":
			driver = new FirefoxDriver();
			Reporter.log("== Browser launched successfully == ", true);
			break;

		default:
			Reporter.log("== Invalid bro=wser name == ", true);

		}
		
		driver.manage().window().maximize();
		u.implicitWait(driver, 10);
		driver.get(url);
		
		

	}
	
	@AfterClass
	public void teatDown() {
		driver.quit();
		Reporter.log("== Browser closed successfully == ", true);
	}
	
	@AfterTest
	public void closeDatabaseConnection() {
		Reporter.log("== Database closed succcessfully == ", true);
	}
	
	@AfterSuite
	public void closeServer() {
		Reporter.log("== Server closed succcessfully ==", true);
	}

}
