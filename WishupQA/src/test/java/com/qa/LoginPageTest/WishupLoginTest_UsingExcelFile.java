package com.qa.LoginPageTest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.pageLayer.WishupLogInWebPage;
import com.qa.utility.TestBase;

public class WishupLoginTest_UsingExcelFile extends TestBase{
	WishupLogInWebPage login;
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	WishupLoginTest_UsingExcelFile()
	{
		super();
	}
	
	@BeforeSuite
	public void extentSetup()
	{
		spark = new ExtentSparkReporter("./extent_reports/LoginTestWithExcelFile.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Wishup Login Test with Excel");
		spark.config().setDocumentTitle("Log in Webpage Test using Excel File");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Monika J.");
		extent.setSystemInfo("OS", "Windows 11");
	}
	
	@BeforeClass
	public void setup()
	{
		launch();
		login = new WishupLogInWebPage();
	}
	
	@Test(dataProvider="ExcelLoginData")
	public void WishupLoginPageTest(String username, String pwd, String status)
	{
		test = extent.createTest("Wishup Login Test with Excel file");
		String returnData =login.verifyLogin(username, pwd, status);
		//System.out.println(login.verifyLogin(username, pwd, status));
		if(returnData.equalsIgnoreCase(prop.getProperty("AddATask_bttn"))||returnData.equalsIgnoreCase(prop.getProperty("loginPageUrl")))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
		}
	}
	@AfterMethod
	public void extentTearDown(ITestResult result)
	{
		 if (result.getStatus() == ITestResult.FAILURE) {
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
			  } else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			  }
			  else if (result.getStatus() == ITestResult.SUCCESS) {
			   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			  }
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	@AfterSuite
	public void extentTearDown()
	{
		extent.flush();
	}

}
