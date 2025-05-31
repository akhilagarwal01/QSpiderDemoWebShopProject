package com.Ecommerce.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BaseTest {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getGender(WebDriver driver, String gender) {
		return driver.findElement(By.xpath("//label[text()='" + gender + "']"));
	}

	@FindBy(id = "FirstName")
	private WebElement FirstNameTextField;

	@FindBy(name = "LastName")
	private WebElement LastNameTextField;

	@FindBy(name = "Email")
	private WebElement emailtextField;

	@FindBy(name = "Password")
	private WebElement passwordField;

	@FindBy(name = "ConfirmPassword")
	private WebElement ConfirmPassword;

	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement regSuccessMessage;

	public String registerUser(WebDriver driver, String gender, String firstName, String lastName, String email,
			String password) throws InterruptedException {
		getGender(driver, gender).click();
		FirstNameTextField.sendKeys(firstName);
		LastNameTextField.sendKeys(lastName);
		emailtextField.sendKeys(email);
		passwordField.sendKeys(password);
		ConfirmPassword.sendKeys(password);
		Thread.sleep(3000);
		registerButton.click();
		Thread.sleep(2000);
		logoutButton.click();
		
		return regSuccessMessage.getText();

	}

}
