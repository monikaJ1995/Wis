package com.qa.testLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

	@BeforeSuite
	public void a() {
		System.out.println("BeforeSuite---a");
		
	}
	@BeforeSuite
	public void b() {
		System.out.println("BeforeSuite---b");
	}
	@BeforeTest
	public void c() {
		System.out.println("BeforeTest---c");
	}
	@BeforeTest
	public void z() {
		System.out.println("BeforeTest---z");
	}
	@AfterTest
	public void h() {
		System.out.println("AfterTest----h");
	}
	@BeforeMethod
	public void e() {
		System.out.println("BeforeMethod----e");
	}
	@BeforeMethod
	public void f() {
		System.out.println("BeforeMethod---f");
	}
	@AfterMethod
	public void g() {
		System.out.println("AfterMethod----g");
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
		System.out.println("AfterSuite-------i");
	}
}
