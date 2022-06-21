package com.qa.pageLayer;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;


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

	@FindBy(xpath="(//div[@class='inline fields'])[2]/child::div/div/input")
	private List<WebElement> radioButtons;

	@FindBy(xpath="(//input[@placeholder='Date/Time'])[2]")
	private WebElement datePicker;
	
	//     //div[@class='ui calendar due_date'])[2]
	

	@FindBy(xpath="(//td[contains(@class,'link today')])[2]")
	private WebElement today_Date;
	



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
	
	public boolean verifyRadioButtons()
	{
		boolean oneTime_Stat;
		oneTime_Stat = radioButtons.get(0).isSelected();
		for(int i=1;i<radioButtons.size();i++)
		{
			if(radioButtons.get(i).isSelected()==false)
				{
					//radioButtons.get(i).click();
				JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].checked = true;", radioButtons.get(i));
				}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return oneTime_Stat;
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
	public String verifyTestUser1Button()
	{
		testUser_btn.click();
		//return testUser_btn.getTagName();
		//return testUser_btn.getAttribute("src");     //Returns null, expected: "/images/selected_user.png"
		return testUser_btn.getAttribute("class");		// Returns "header" expected: "left floated mini ui avatar image"
		//return testUser_btn.isSelected();				//Returns "false", Expected: "True"

	}
	public String verifyDatePicker()
	{
		datePicker.click();
		today_Date.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js =(JavascriptExecutor)driver;
		return (String) js.executeScript("return arguments[0].value", datePicker);		//Returns "null", expected: ""
		
		
		//return datePicker.getAttribute("value");	
	}

	public String verifyTaskNameTextKeySimulation()
	{
		task_Name.sendKeys("task1k");
		String sentText = task_Name.getAttribute("value");
		for(int i=0; i<sentText.length(); i++)
		{
			task_Name.sendKeys(Keys.BACK_SPACE);
		}
		return task_Name.getAttribute("value");	
	}
	public String verifyDescribeTaskTextKeySimulation()
	{
		task_Name.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		task_Name.sendKeys("task1");
		task_Name.sendKeys(Keys.TAB);
		describe_Task.sendKeys("task description");
		return describe_Task.getText();	
	}


}


