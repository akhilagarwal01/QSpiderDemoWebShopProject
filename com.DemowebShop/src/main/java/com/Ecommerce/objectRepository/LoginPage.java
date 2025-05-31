package com.Ecommerce.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	
	@FindBy(id = "RememberMe")
	private WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='validation-summary-errors']/span")
	private WebElement validationError;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void doLogin(String emaiId, String password) {
		emailTextField.sendKeys(emaiId);
		passwordTextField.sendKeys(password);
		rememberMeCheckBox.click();
		loginButton.click();
	}
	
	public String invalidLogin(String emaiId, String password) {
		emailTextField.sendKeys(emaiId);
		passwordTextField.sendKeys(password);
		rememberMeCheckBox.click();
		loginButton.click();
		return validationError.getText();
		
	}
	

}
