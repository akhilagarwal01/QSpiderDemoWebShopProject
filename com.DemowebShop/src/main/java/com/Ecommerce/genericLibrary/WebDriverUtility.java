package com.Ecommerce.genericLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		
	}

}
