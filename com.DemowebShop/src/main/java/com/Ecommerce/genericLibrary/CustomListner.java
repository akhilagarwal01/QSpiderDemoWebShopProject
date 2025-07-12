package com.Ecommerce.genericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class CustomListner implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		TakesScreenshot t = (TakesScreenshot) BaseClass.driver;
		try {
			Files.copy(((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE),
					new File("./src/test/resources/Output/FailedScreenshots/" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
