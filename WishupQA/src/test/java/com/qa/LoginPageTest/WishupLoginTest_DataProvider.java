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
import com.qa.base.TestBase;
import com.qa.pageLayer.WishupLogInWebPage;
import com.qa.utility.Extent_Utility;

public class WishupLoginTest_DataProvider extends TestBase{

	WishupLogInWebPage login;
	ExtentReports extent;
	ExtentTest test;
	
	WishupLoginTest_DataProvider()
	{
		super();
	}
	@BeforeClass
	public void setup()
	{
		launch();
		login = new WishupLogInWebPage();
	}
	
	@BeforeSuite
	public void extentSetup()
	{
		extent = Extent_Utility.extentReport("Login Test using Dataprovider");
	}
	
	@Test(priority=11,dataProvider = "ValidTestData")
	public void validDataLoginTest(String UserName, String Password, String status)
	{
		test = extent.createTest("Login Test with valid credentials using DataProvider keyword");
		//System.out.println(login.verifyLogin(UserName, Password));
		Assert.assertNotEquals(login.verifyLogin(UserName, Password, status),prop.getProperty("AddATask_bttn"));
	}
	
	@Test(priority=12,dataProvider = "InvalidTestData")
	public void invalidDataLoginTest(String UserName, String Password, String status)
	{
		test = extent.createTest("Login Test with invalid credentials using DataProvider keyword");
		//System.out.println(login.verifyLogin(UserName, Password));
		Assert.assertEquals(login.verifyLogin(UserName, Password, status),prop.getProperty("loginPageUrl"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
			  } 
		else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			  }
			  
		else if (result.getStatus() == ITestResult.SUCCESS) {
			   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			  }
	}
	@AfterClass
	public void driverTearDown()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void extentReportTearDown()
	{
		extent.flush();
	}
}
