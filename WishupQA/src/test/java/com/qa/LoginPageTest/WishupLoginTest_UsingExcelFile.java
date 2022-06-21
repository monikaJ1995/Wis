package com.qa.LoginPageTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.base.TestBase;
import com.qa.pageLayer.WishupLogInWebPage;
import com.qa.utility.Extent_Utility;

public class WishupLoginTest_UsingExcelFile extends TestBase{
	WishupLogInWebPage login;
	ExtentReports extent;
	ExtentTest test;
	SoftAssert Assert;
	
	WishupLoginTest_UsingExcelFile()
	{
		super();
		Assert = new SoftAssert();
	}
	
	@BeforeSuite
	public void extentSetup()
	{
		extent = Extent_Utility.extentReport("Login Test Using Excel File");
	}
	
	@BeforeClass
	public void setup()
	{
		launch();
		login = new WishupLogInWebPage();
	}
	
	@Test(dataProvider="ExcelLoginData")
	public void wishupLoginPageTest(String username, String pwd, String status)
	{
		test = extent.createTest("Wishup Login Test with Excel file");
		String returnData =login.verifyLogin(username, pwd, status);
		//System.out.println(login.verifyLogin(username, pwd, status));
		if(status.equalsIgnoreCase("valid"))
		{
			Assert.assertEquals(returnData,prop.getProperty("AddATask_bttn"),"Test case failed with valid credentials, check with DEV");
		}

		else if(status.equalsIgnoreCase("invalid"))
		{
			Assert.assertEquals(returnData,prop.getProperty("loginPageUrl","Test case failed with valid credentials, check with DEV"));
		}
		Assert.assertAll();
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
