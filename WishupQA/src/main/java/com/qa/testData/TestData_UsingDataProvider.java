package com.qa.testData;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.qa.utility.ExcelUtility;

public class TestData_UsingDataProvider {
	@DataProvider(name ="ValidTestData")
	public String[][] validLogInCredentials()
	{
		String[][] LogInData = {
				{"wishup_testuser1@gmail.com","testpw1","valid"},
				{"wishup_testuser3@gmail.com","testpw3","valid"},
				{"wishup_testuser4@gmail.com","testpw4","valid"}
		};
		return LogInData;
	}
	
	@DataProvider(name ="InvalidTestData")
	public String[][] invalidLogInCredentials()
	{
		String[][] LogInData = {
				{"wishup_testuser1@gmail.com","abc@1","invalid"},
				{"wishup_testuser3@gmail.com","abc@2","invalid"},
				{"wishup_testuser2@gmail.com","testpw2","invalid"}
		};
		return LogInData;
	}
	
	@DataProvider(name="ExcelLoginData")
	public String[][] excelLoginData() throws IOException
	{
		String path="C:\\Users\\91952\\Desktop\\A\\kkkk\\WishupQA\\src\\main\\java\\com\\qa\\testData\\WishupLoginTestData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return loginData;
	}

}
