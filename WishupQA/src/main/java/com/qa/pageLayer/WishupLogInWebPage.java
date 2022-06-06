package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.utility.Waits;

public class WishupLogInWebPage extends TestBase{
	Waits sync ;
	@FindBy(xpath="//input[@name='email']")
	private WebElement EmailAddress;

	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement Login;
	
	@FindBy(xpath="//a[contains(@class,'create_task_button')]")
	private WebElement add_A_task;
	
	@FindBy(xpath="(//div[contains(@class,'ui simple dropdown item')])[1]")
	private WebElement test_Dropdown;
	
	@FindBy(xpath="(//a[@href='/logout' and text()='Logout'])[1]")
	private WebElement logout;


	public WishupLogInWebPage()
	{
		PageFactory.initElements(driver, this);
		sync = new Waits();
	}

	public void dropdown()
	{
		test_Dropdown.click();
		sync.explicit_Wait(logout).click();
	}
	
	
	public String verifyLogin(String UserName,String password,String status)
	{
		String returnStatus="";
		EmailAddress.clear();
		EmailAddress.sendKeys(UserName);
		Password.clear();
		Password.sendKeys(password);
		Login.click();
		if(status.equalsIgnoreCase("valid"))
		{
			returnStatus = add_A_task.getText();
			test_Dropdown.click();
			sync.explicit_Wait(logout).click();		//------sync: explicit wait for element to be clickable
		}
		else if(status.equalsIgnoreCase("invalid"))
		{
			returnStatus = driver.getCurrentUrl();
		}
		return returnStatus;
	}

}
