package com.DemowebShop.testScripts.registerModule;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecommerce.genericLibrary.BaseClass;
import com.Ecommerce.genericLibrary.ExcelUtility;
import com.Ecommerce.objectRepository.RegistrationPage;
import com.Ecommerce.objectRepository.WelcomePage;

public class RegistrationTest extends BaseClass {

	@DataProvider(name = "multipleUserRegistration")
	public Object[][] registerData() {
		return ExcelUtility.readExcel(EXCEL_PATH, SHEET_NAME);
	}

	@Test(dataProvider = "multipleUserRegistration")
	public void doResgistration(String gender, String firstName, String lastName, String email, String password)
			throws InterruptedException {

		SoftAssert s = new SoftAssert();

		// click on registration link
		WelcomePage wp = new WelcomePage(driver);
		wp.goToRegistrationPage();

		// Fill the registration form at registration page
		RegistrationPage rp = new RegistrationPage(driver);
		String resultMessgae = rp.registerUser(driver, gender, firstName, lastName, email, password);

		s.assertTrue(resultMessgae.contains("Your registration completed"));

		s.assertAll();

		// Aman Singh - amansingh.qsp@gmail.com
	}

}
