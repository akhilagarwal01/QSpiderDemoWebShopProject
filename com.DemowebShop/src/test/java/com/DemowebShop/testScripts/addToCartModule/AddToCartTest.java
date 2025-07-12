package com.DemowebShop.testScripts.addToCartModule;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecommerce.genericLibrary.BaseClass;
import com.Ecommerce.objectRepository.LoginPage;
import com.Ecommerce.objectRepository.WelcomePage;

public class AddToCartTest extends BaseClass{
	
	@Test
	public void doValidLogin() {
		
		SoftAssert s = new SoftAssert();
		// Click on login link
		WelcomePage wp = new WelcomePage(driver);
		
		//Verify User land on Welcome page
//		Assert.assertEquals(wp.getPageLogo().isDisplayed(), true);
		s.assertEquals(wp.getPageLogo().isDisplayed(), false);
		wp.goToLoginPage();
		
		//Fill the valid credentials
		LoginPage lp = new LoginPage(driver);
//		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		s.assertEquals(driver.getTitle(), "Demo Web Shop Login");
		lp.doLogin("akhilagarwal012@gmail.com", "*1234567!");
		
		//Verify user logged in successfully
		Assert.assertEquals(lp.getLogoutLink().isDisplayed(), true);
		
		//check for all assertion
		s.assertAll();
	}
	
	@Test
	public void addtocart() {
		
	}

}
