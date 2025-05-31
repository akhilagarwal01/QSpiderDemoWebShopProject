package com.Ecommerce.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {
	
	public BaseTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
