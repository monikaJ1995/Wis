package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WishupLogInWebPage extends TestBase{
	@FindBy(xpath="//input[@name='email']")
	private WebElement EmailAddress;

	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement Login;


	public WishupLogInWebPage()
	{

		PageFactory.initElements(driver, this);
	}

	public void verifyLogin(String UserName,String password)
	{
		EmailAddress.sendKeys(UserName);
		Password.sendKeys(password);
		Login.click();

	}

}
