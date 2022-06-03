package com.qa.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReports_Utility extends TestBase{
	
	public void extentReport()
	{
		// directory where output is to be printed
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
		extent.attachReporter(spark);
	}
}
