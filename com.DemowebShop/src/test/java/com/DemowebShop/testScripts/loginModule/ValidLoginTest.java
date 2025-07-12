package com.DemowebShop.testScripts.loginModule;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecommerce.genericLibrary.BaseClass;
import com.Ecommerce.genericLibrary.CustomListner;
import com.Ecommerce.objectRepository.LoginPage;
import com.Ecommerce.objectRepository.WelcomePage;

@Listeners(CustomListner.class)
public class ValidLoginTest extends BaseClass{

	@Test
	public void doValidLogin() {
		
		SoftAssert s = new SoftAssert();
		// Click on login link
		WelcomePage wp = new WelcomePage(driver);
		
		//Verify User land on Welcome page
//		Assert.assertEquals(wp.getPageLogo().isDisplayed(), true);
		s.assertEquals(wp.getPageLogo().isDisplayed(), true);
		wp.goToLoginPage();
		
		//Fill the valid credentials
		LoginPage lp = new LoginPage(driver);
//		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		s.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		lp.doLogin("akhilagarwal012@gmail.com", "1234567!");
		
		//Verify user logged in successfully
		Assert.assertEquals(lp.getLogoutLink().isDisplayed(), true);
		
		//check for all assertion
		s.assertAll();
		
		//https://github.com/Github151112/A3DemoWebShopProject - 
		// Aman singh DemoWebShop project git repo
		
		
		
		
	}
	
	
	
	
}
