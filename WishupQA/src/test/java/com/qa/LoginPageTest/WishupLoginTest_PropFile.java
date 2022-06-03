package com.qa.LoginPageTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.pageLayer.WishupLogInWebPage;
import com.qa.utility.TestBase;

public class WishupLoginTest_PropFile extends TestBase{
	WishupLogInWebPage login;
	Properties prop_TD;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
	WishupLoginTest_PropFile()
	{
		super();
		prop_TD = new Properties();
		try {
			FileInputStream file =new FileInputStream(System.getProperty("user.dir")+prop.getProperty("testData_propDest"));
			prop_TD.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@BeforeSuite
	public void extentSetup()
	{
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./extent_reports/LoginTestWithPropertiesFile.html");
		spark.config().setReportName("WishupLoginWebpage");
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("Tester", "Monika J");
		
	}
	@BeforeMethod
	public void setup()
	{
		launch();
		login = new WishupLogInWebPage();
	}
	

	//invalid Credentials through property file
	@Test(priority = 11)
	public void invalidLoginPageTest()
	{
		test = extent.createTest("Test for Login functionality with invalid credentials via Properties file");
		String validation1 = login.verifyLogin(prop_TD.getProperty("invalid_userName1"), prop_TD.getProperty("invalid_pwd1"), "invalid");
		Assert.assertEquals(validation1, prop.getProperty("loginPageUrl"));
		test.log(Status.PASS, "User failed to login with invalid credentials");
		String validation2 = login.verifyLogin(prop_TD.getProperty("invalid_userName2"), prop_TD.getProperty("invalid_pwd2"), "invalid");
		Assert.assertEquals(validation2, prop.getProperty("loginPageUrl"));
		test.log(Status.PASS, "User failed to login with invalid credentials");
		String validation3 = login.verifyLogin(prop_TD.getProperty("invalid_userName3"), prop_TD.getProperty("invalid_pwd3"), "invalid");
		Assert.assertEquals(validation3, prop.getProperty("loginPageUrl"));
		test.log(Status.PASS, "User failed to login with invalid credentials");
	}
	
	//valid Credentials through property file
	@Test(priority = 12)
	public void validLoginPageTest()
	{
		test = extent.createTest("Test for Login functionality with valid credentials via Properties file");
		String validation1 = login.verifyLogin(prop_TD.getProperty("valid_userName1"), prop_TD.getProperty("valid_pwd1"), "valid");
		Assert.assertEquals(validation1, prop.getProperty("AddATask_bttn"));
		test.log(Status.PASS, "User successfully logged in with valid credentials");
		String validation2 = login.verifyLogin(prop_TD.getProperty("valid_userName2"), prop_TD.getProperty("valid_pwd2"), "valid");
		Assert.assertEquals(validation2, prop.getProperty("AddATask_bttn"));
		test.log(Status.PASS, "User successfully logged in with valid credentials");
		String validation3 = login.verifyLogin(prop_TD.getProperty("valid_userName3"), prop_TD.getProperty("valid_pwd3"), "valid");
		Assert.assertEquals(validation3, prop.getProperty("AddATask_bttn"));
		test.log(Status.PASS, "User successfully logged in with valid credentials");
		test.pass("Login test with valid credentials passed");
	}
	

	@AfterMethod
	public void tearDown(ITestResult result)
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
