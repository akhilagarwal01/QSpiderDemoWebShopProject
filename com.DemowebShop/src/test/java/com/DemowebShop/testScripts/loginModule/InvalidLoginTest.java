
package com.DemowebShop.testScripts.loginModule;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.genericLibrary.BaseClass;
import com.Ecommerce.genericLibrary.ExcelUtility;
import com.Ecommerce.objectRepository.LoginPage;
import com.Ecommerce.objectRepository.WelcomePage;

public class InvalidLoginTest extends BaseClass {
	
	
	@DataProvider(name = "invalidCredentials")
	public Object[][] invalidData() {
		return ExcelUtility.readExcel(EXCEL_PATH, "invalidLoginData");
	}

	@Test(dataProvider = "invalidCredentials")
	public void invalidLoginTest(String emailId, String password) {
		// Click on login link
		WelcomePage wp = new WelcomePage(driver);
		wp.goToLoginPage();

		// Fill the valid credentials
		LoginPage lp = new LoginPage(driver);
		String errorMeesage = lp.invalidLogin(emailId, password);
		Assert.assertTrue(errorMeesage.contains("Login was unsuccessful"), errorMeesage);
		
		
	}

}
