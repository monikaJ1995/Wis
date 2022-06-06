package com.qa.testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pageLayer.WishupCreateNewTaskWebPage;
import com.qa.pageLayer.WishupHomePage;
import com.qa.pageLayer.WishupLogInWebPage;
import com.qa.utility.SystemDate;

public class WishupCreateNewTaskTest extends TestBase {
	WishupLogInWebPage Test1;
	WishupCreateNewTaskWebPage create;
	WishupHomePage homePage;
	SystemDate currentDate;

	WishupCreateNewTaskTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		launch();
		Test1 = new WishupLogInWebPage();
		Test1.verifyLogin(prop.getProperty("userName"),prop.getProperty("password"),prop.getProperty("credentialStatus"));
		create = new WishupCreateNewTaskWebPage();
		homePage = new WishupHomePage();
		homePage.verifyAdd_A_TaskButton();
		currentDate = new SystemDate();
	}
	
	//Task Name text box is enabled or not
	@Test(priority=11)
	public void TaskNameTextBoxTest()
	{
		Assert.assertTrue(create.verifyTaskNameTextBox(), "Text Box is not enabled");
	}

	//Describe task text box is enabled or not
	@Test(priority=12)
	public void DescribeTaskTextBoxTest()
	{		
		Assert.assertTrue(create.verifyDescribeTaskTextBox(), "Text Box is not enabled");
	}

	//One-Time radio button is by default selected or not
	@Test(priority=13)
	public void OneTimeRadioButtonTest()
	{	
		Assert.assertTrue(create.verifyOneTimeRadioButton(), "Radio button is not selected");	
	}

	//Verify "Create this task" button Background color
	@Test(priority=14, enabled=true)
	public void TestUser1_Btn_Test()
	{	
		//Assert.assertEquals(create.verifyTestUser1Button(),"https://app-dev.wishup.co/images/selected_user.png");
		System.out.println(create.verifyTestUser1Button());
	}

	//Verify task creation with blank input cannot be done.
	@Test(priority=15)
	public void CreateThisTaskButtonTest()
	{	
		Assert.assertNotEquals(create.verifyCreateThisTaskButton(),prop.getProperty("taskDetailsUrl"));
	}
	
	//Verify "Create this task" button Background color
	@Test(priority=16)
	public void CreateThisTaskButtonBgrndColorTest()
	{	
		Assert.assertEquals(create.verifyCreateThisTaskButtonBgrndColor(),prop.getProperty("CreateThisTaskButtonBgrndColor"));
	}

	@Test(priority=17)
	public void datePickerTest()
	{	
//		System.out.println(create.verifyDatePicker());
//		System.out.println(currentDate.currentDate());
		Assert.assertEquals(create.verifyDatePicker(), currentDate.currentDate());
	}
	
	//KeySimulation Action
	
	@Test(priority=18)
	public void textBoxKeySimulationTest()
	{		
		Assert.assertEquals(create.verifyDescribeTaskTextKeySimulation(), "task description");	
	}
	
	@Test(priority=19)
	public void clearTaskNameKeySimulationTest()
	{	
		Assert.assertEquals(create.verifyTaskNameTextKeySimulation(), "");	
	}
	
	@Test(priority=20)
	public void radioButtonsTest()
	{	
		create.verifyRadioButtons();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

