package com.qa.testLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest2 {

	@BeforeSuite
	public void p() {
		System.out.println("BeforeSuite-----p");
		
	}
	@BeforeSuite
	public void q() {
		System.out.println("BeforeSuite------q");
	}
	@BeforeTest
	public void r() {
		System.out.println("BeforeTest--------r");
	}
	@BeforeTest
	public void d() {
		System.out.println("BeforeTest");
	}
	@AfterTest
	public void h() {
		System.out.println("AfterTest");
	}
	@BeforeMethod
	public void e() {
		System.out.println("BeforeMethod");
	}
	@BeforeMethod
	public void f() {
		System.out.println("BeforeMethod");
	}
	@AfterMethod
	public void g() {
		System.out.println("AfterMethod");
	}
	@Test
	public void mj() {
		System.out.println("Test");
	}
	@Test
	public void mjj() {
		System.out.println("mjj_Test");
	}
	
	@AfterSuite
	public void i() {
		System.out.println("AfterSuite");
	}
}
