package org.testngflipkart;

import java.io.File;
import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngFlipkartModel extends BaseClass  {
	static int number;
	static PageManagerTestngFlipkart managerFlipkart;
	static PomFlipkartLoginOtp flipkartEnterMobile;
	static WebElement productOne;
	@BeforeClass
	public static void initialSetup() {
		browserLaunch("chrome");
		maximizeWindow();
		navigateUrl("https://www.flipkart.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Login Page Title : "+pageTitle+"\n------------------");
		managerFlipkart = new PageManagerTestngFlipkart();
	}
	@BeforeMethod
	public void goLogin() throws InterruptedException {
		PomFlipkartLogin flipkart = managerFlipkart.getPomFlipkartLogin();
		try {
		switchWindow();
		} catch(Exception e) {
			Thread.sleep(3000);
			clickIt(flipkart.getLoginButton());
		}
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
		flipkartEnterMobile = managerFlipkart.getPomFlipkartLoginOtp();
		passValue(flipkartEnterMobile.getEnterMobile(), "9500205209");
		clickIt(flipkartEnterMobile.getSendOtp());
//		WebElement verifyMessage = flipkart1.getVerifyMessage();
//		String text = verifyMessage.getText();
//		System.out.println(text);
	}
	@Test
	public void tc2() {
		reloadPage();
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
	public void tc3() throws InterruptedException{
		PomFlipkartLogin flipkart = managerFlipkart.getPomFlipkartLogin();
		try {
		clickIt(flipkart.getCloseButton());
		} catch(Exception e) {
		}
		PomSearchProduct searchProduct = managerFlipkart.getPomSearchProduct();
		WebElement searchBar = searchProduct.getSearchBar();
		passValue(searchBar, "IPhone");
		String search = searchBar.getAttribute("value");
		clickIt(searchProduct.getSearchButton());
		Thread.sleep(3000);
		String pageTitle = driver.getTitle();
		System.out.println("\nPage Title : "+pageTitle+"\n-----------");
		System.out.println("\n  Products check:\n  --------------");
		productOne = searchProduct.getProductOne();
		String product1 = productOne.getText();
		String product2 = searchProduct.getProductThree().getText();
		String product3 = searchProduct.getProductFive().getText();
		System.out.println("  Given: "+search+"\n  in LIst: "+product1+"\n           "+product2+"\n           "+product3);
		productOne.click();
	}
	@Test
	public void tc4() throws InterruptedException{
		Thread.sleep(3000);
		switchWindow();
		String pageTitle = driver.getTitle();
		System.out.println("\nTitle : "+pageTitle+"\n-------------");
		PomProductPage productPage = managerFlipkart.getPomProductPage();
		WebElement productTitle = productPage.getProductTitle();
		String productTitleText = productTitle.getText();
		System.out.println("  Product Given: "+productOne+"\n  Product showing: "+productTitleText);
		clickIt(productPage.getAddToCart());
	}
}
