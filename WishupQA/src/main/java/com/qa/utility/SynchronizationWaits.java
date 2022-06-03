package com.qa.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationWaits extends TestBase{
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public WebElement explicit_Wait(WebElement element)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

}
