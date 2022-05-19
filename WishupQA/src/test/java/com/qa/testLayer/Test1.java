package com.qa.testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pageLayer.TestBase;
import com.qa.pageLayer.WishupCreateNewTaskWebPage;
import com.qa.pageLayer.WishupLogInWebPage;

public class Test1 extends TestBase {
	WishupLogInWebPage Test1;
	WishupCreateNewTaskWebPage create;
	
	@BeforeMethod
	public void setup()
	{
		launch("chrome");
		Test1 = new WishupLogInWebPage();
		Test1.verifyLogin("wishup_testuser1@gmail.com","testpw1");
		create = new WishupCreateNewTaskWebPage();
		create.verifyAdd_A_TaskButton();
	}
	
	//Task Name text box is enabled or not
	@Test(priority=2)
	public void TaskNameTextBoxTest()
	{
		Assert.assertTrue(create.verifyTaskNameTextBox(), "Text Box is not enabled");
	}
	
	//Describe task text box is enabled or not
	@Test(priority=3)
	public void DescribeTaskTextBoxTest()
	{		
		Assert.assertTrue(create.verifyDescribeTaskTextBox(), "Text Box is not enabled");
	}
	
	//One-Time radio button is by default selected or not
	@Test(priority=4)
	public void OneTimeRadioButtonTest()
	{	
		Assert.assertTrue(create.verifyOneTimeRadioButton(), "Radio button is not selected");
	}
	
	//Verify task creation with blank input cannot be done.
	@Test(priority=5)
	public void CreateThisTaskButtonTest()
	{	
		String URL = create.verifyCreateThisTaskButton();
		Assert.assertNotEquals(URL,"https://app-dev.wishup.co/org/100001/task/200009/details");
	}
	
	//Verify "Create this task" button Background color
	@Test(priority=5)
	public void CreateThisTaskButtonBgrndColorTest()
	{	
		Assert.assertEquals(create.verifyCreateThisTaskButtonBgrndColor(),"#6fda44");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
