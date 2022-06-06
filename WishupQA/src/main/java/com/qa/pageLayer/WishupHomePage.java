package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class WishupHomePage extends TestBase {
	@FindBy(xpath="//a[contains(@class,'create_task_button')]")
	private WebElement add_A_task;
	
	public WishupHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public void verifyAdd_A_TaskButton()
	{
			add_A_task.click();
	}

}
