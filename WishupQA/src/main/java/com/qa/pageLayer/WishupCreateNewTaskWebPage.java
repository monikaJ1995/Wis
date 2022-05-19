package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WishupCreateNewTaskWebPage extends TestBase  {
	@FindBy(xpath="//a[contains(@class,'create_task_button')]")
	private WebElement add_A_task;

	@FindBy(xpath="(//input[contains(@name,'name')])[2]")
	private WebElement task_Name;

	@FindBy(xpath="(//trix-editor[contains(@input,'task_details')])[2]")
	private WebElement describe_Task;

	@FindBy(xpath="(//button[text()=' Create this task'])[2]")
	private WebElement CreateTask;
	
	@FindBy(xpath= "(//input[contains(@checked,'true')])[2]")
	private WebElement radioBtn_OneTime;

	public WishupCreateNewTaskWebPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void verifyAdd_A_TaskButton()
	{
			add_A_task.click();
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
	
	
}


