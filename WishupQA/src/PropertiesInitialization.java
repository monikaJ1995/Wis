package com.qa.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesInitialization {
	public static void propInitialization()
	{
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
