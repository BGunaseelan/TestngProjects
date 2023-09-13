package org.practice;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Groups {
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}
	@AfterClass(groups = "smoke")
	public void afterClass() {
		System.out.println("After class");
	}
	@BeforeMethod(groups = "smoke")
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@AfterMethod(groups = "smoke")
	public void afterMethod() {
		System.out.println("After Method");
	}
	@Test(groups = "smoke", priority = 2)
	public void tc1() {
		System.out.println("smoke");
	}
	@Test(groups = "sanitary")
	public void tc2() {
		System.out.println("sanitary");
	}
	@Test(groups = {"smoke","sanitary"}, priority = 1)
	public void tc3() {
		System.out.println("smoke and sanitary");
	}
	@Test(groups = "regression")
	public void tc4() {
		System.out.println("regression");
	}
	@Test(groups = {"regression","sanitary"})
	public void tc5() {
		System.out.println("regression and sanitary");
	}
}

//Note: The attribute group is undefined for annotation type Before Class
