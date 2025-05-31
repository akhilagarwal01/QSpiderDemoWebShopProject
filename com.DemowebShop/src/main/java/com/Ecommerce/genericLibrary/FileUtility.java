package com.Ecommerce.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class FileUtility {

	public String getDataFromProperty(String path, String key) {
		String value = null ;
		try {
			FileInputStream f = new FileInputStream(path);
			Properties p = new Properties();
			p.load(f);
			value = p.getProperty(key);

		} catch (Exception e) {
			Reporter.log("Unable to load properties file");

		}

		return value;

	}

}
