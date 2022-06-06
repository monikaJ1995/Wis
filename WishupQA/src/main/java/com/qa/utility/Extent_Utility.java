package com.qa.utility;



import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.base.TestBase;



public class Extent_Utility extends TestBase{
	static String currentDate = SystemDate.currentDate_Time();
	public static ExtentReports extentReport(String reportName)
	{
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./extent_reports/"+reportName+"-"+currentDate+".html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName(reportName);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Monika J.");
		extent.setSystemInfo("OS", "Windows 11");
		return extent;
	}
}
