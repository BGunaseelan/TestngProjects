package org.testngflipkart;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.base.BaseClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestngFlipkart extends BaseClass  {
	static int number;
	static PageManagerTestngFlipkart managerFlipkart;
	static PomFlipkartLoginOtp flipkartEnterMobile;
	@BeforeClass
	public static void initialSetup() {
		browserLaunch("chrome");
		maximizeWindow();
		navigateUrl("https://www.flipkart.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Login Page Title : "+pageTitle+"\n------------------");
		managerFlipkart = new PageManagerTestngFlipkart();
	}
	@AfterMethod
	public void afterTestCase() throws InterruptedException, IOException {
		Thread.sleep(3000);
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\ProjectsMaven\\target\\screenshot"+number+".png");
		takeScreenShot(file);
		number = number+1;
	}
	@Test
	public void tc1() {
		PomFlipkartLogin flipkart = managerFlipkart.getPomFlipkartLogin();
		try {
		switchWindow();
		} catch(Exception e) {
			clickIt(flipkart.getLoginButton());
		}
		flipkartEnterMobile = managerFlipkart.getPomFlipkartLoginOtp();
		passValue(flipkartEnterMobile.getEnterMobile(), "9500205209");
		clickIt(flipkartEnterMobile.getSendOtp());
//		WebElement verifyMessage = flipkart1.getVerifyMessage();
//		String text = verifyMessage.getText();
//		System.out.println(text);
	}
	@Test
	public void tc2() {
		PomFlipkartCreate flipkart = managerFlipkart.getPomFlipkartCreate();
		clickIt(flipkart.getCreateButton());
		String text = flipkart.getTextMessage().getText();
		System.out.println(text);
		try {
			System.out.println("Enter Mobile number Block is Present");
			passValue(flipkartEnterMobile.getEnterMobile(), "9500205209");
			clickIt(flipkartEnterMobile.getSendOtp());
		}
		catch (Exception e) {
			System.out.println("Enter Mobile number Block is Absent");
		}
	}
	@Test
	public void tc3(){
		
	}
}
