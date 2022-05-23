package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utility.TestBase;


public class WishupCreateNewTaskWebPage extends TestBase  {
	

	@FindBy(xpath="(//input[contains(@name,'name')])[2]")
	private WebElement task_Name;

	@FindBy(xpath="(//trix-editor[contains(@input,'task_details')])[2]")
	private WebElement describe_Task;

	@FindBy(xpath="(//button[text()=' Create this task'])[2]")
	private WebElement CreateTask;
	
	@FindBy(xpath= "(//input[contains(@checked,'true')])[2]")
	private WebElement radioBtn_OneTime;
	
	@FindBy(xpath="(//div[contains(text(),'Test User 1')])[2]")
	private WebElement testUser_btn;

	public WishupCreateNewTaskWebPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public boolean verifyTaskNameTextBox()
	{

		return task_Name.isEnabled();	
	}
	public boolean verifyDescribeTaskTextBox()
	{
		return describe_Task.isEnabled();
	}
	
	public boolean verifyOneTimeRadioButton()
	{
		
		return radioBtn_OneTime.isSelected();
	}
	public String verifyCreateThisTaskButton()
	{
			CreateTask.click();
			return driver.getCurrentUrl();
	}
	public String verifyCreateThisTaskButtonBgrndColor()
	{
		String bkcolor = CreateTask.getCssValue("background-color");
		return Color.fromString(bkcolor).asHex();
	}
	public boolean verifyTestUser1Button()
	{
		testUser_btn.click();
		
		return testUser_btn.isSelected();
		
	}
	
	
}


