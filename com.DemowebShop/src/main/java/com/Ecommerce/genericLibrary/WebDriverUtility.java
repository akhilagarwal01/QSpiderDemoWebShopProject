package com.Ecommerce.genericLibrary;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		
	}
	
	public int getRandomNo() {
		Random r = new Random();
		return r.nextInt(1000);
	}
	
	public String getRandomEmail() {
		String email = "akhil_automation" + getRandomNo() + "@gmail.com";
		return email;
	}

}
