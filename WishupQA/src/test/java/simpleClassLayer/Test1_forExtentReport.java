package simpleClassLayer;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.pageLayer.WishupLogInWebPage;

public class Test1_forExtentReport {

	WishupLogInWebPage login;
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	
	@BeforeSuite
	public void extentSetup()
	{
		spark = new ExtentSparkReporter("./extent_reports/SimpleExtentReport_withAssertion.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("AssertionTest");
		spark.config().setDocumentTitle("SimpleExtentReport");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Monika J.");
		extent.setSystemInfo("OS", "Windows 11");
	}
	
	@Test
	public void Test1()
	{
		test = extent.createTest("NOT-OK Test with assert True");
			Assert.assertFalse(true);
	}
	@Test
	public void Test2()
	{
		test = extent.createTest("OK Test with assert True");
		Assert.assertFalse(false);
	}
	@Test(dependsOnMethods = "Test1")
	public void Test3()
	{
		test = extent.createTest("NOT_OK(SKIP) Test with assert True");
		Assert.assertFalse(true);
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

	@AfterSuite
	public void extentTearDown()
	{
		extent.flush();
	}

}
