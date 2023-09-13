package org.testngamazon;

import java.io.File;
import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestngAmazon extends BaseClass {
	static int number;
	static PageManagerAmazon managerAmazon;
	static WebElement signIn;
	static WebElement createAccount;
	static WebElement searchBox;
	static WebElement searchBoxIcon;
	static String product1;
    @BeforeClass
	public static void initialSetup() {
		browserLaunch("chrome");
		maximizeWindow();
		navigateUrl("https://www.amazon.in/");
//		navigateUrl("https://www.amazon.in/Apple-iPhone-14-128GB-Blue/dp/B0BDK62PDX/ref=sr_1_1_sspa?crid=Z9UPIPONI3BQ&keywords=Iphone&qid=1690288659&sprefix=iphone%2Caps%2C357&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1#");
		String pageTitle = driver.getTitle();
		System.out.println("Login Page Title : "+pageTitle+"\n------------------");
		managerAmazon = new PageManagerAmazon();
		PomAmazonLogin amazon = managerAmazon.getPomAmazonLogin();
		signIn = amazon.getSignIn();
		searchBox = amazon.getSearchBox();
		searchBoxIcon = amazon.getSearchBoxIcon();
	}
	@AfterClass
	public static void tearDownOperation() {
		quitBrowser();
	}
	@AfterMethod
	public void afterTestCase() throws InterruptedException, IOException {
		Thread.sleep(3000);
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\ProjectsMaven\\target\\screenshot"+number+".png");
		takeScreenShot(file);
		number = number+1;
	}
	@Test(groups = "Smoke")
	public void logIn1() throws InterruptedException{
		signIn.click();
		String pageTitle = driver.getTitle();
		System.out.println("\nPage Title : "+pageTitle+"\n------------------");
		PomAmazonLogin amazon = managerAmazon.getPomAmazonLogin();
		WebElement username = amazon.getUsername();
		username.sendKeys("gunaseelan");
		WebElement continueButton = amazon.getContinueButton();
		continueButton.click();
		Thread.sleep(3000);
		String pageTitle1 = driver.getTitle();
		System.out.println("Page Title : "+pageTitle1+"\n------------------");
		if(pageTitle1.equals("Amazon Sign In")) {
			PomAmazonLogin amazon1 = managerAmazon.getPomAmazonLogin();
			WebElement warning1 = amazon1.getWarning1();
			String text1 = warning1.getText();
			WebElement warning2 = amazon1.getWarning2();
			String text2 = warning2.getText();
			System.out.println(text1+text2);
			amazon1.getUsername();
			System.out.println("Username Block present");
			amazon1.getContinueButton();
			System.out.println("Continue Button present");
			createAccount = amazon1.getCreateAccount();
			String text = createAccount.getText();
			String attribute = createAccount.getAttribute("href");
			System.out.println("Text : "+text+" ---->link: "+attribute);
		} else {
			System.out.println("Login Success");
		}
	}
	@Test
	public void logIn2() {
		previousPage();
		String pageTitle1 = driver.getTitle();
		System.out.println("\nPage Title : "+pageTitle1+"\n------------------");
		PomAmazonCreate amazon1 = managerAmazon.getPomAmazonCreate();
		createAccount.click();
		WebElement firstName = amazon1.getFirstName();
		firstName.sendKeys("Gunaseelan");
		WebElement mobile = amazon1.getMobile();
		mobile.sendKeys("9500205209");
		WebElement email = amazon1.getEmail();
		email.sendKeys("bgunaseelankrish@gmail.com");
		WebElement givePassword = amazon1.getGivePassword();
		givePassword.sendKeys("123456");
		WebElement submitButton = amazon1.getSubmitButton();
		submitButton.click();
	}
	@Test
	public void logIn3() {
		navigateUrl("https://www.amazon.in/");
		searchBox.sendKeys("Iphone");
		String search = searchBox.getAttribute("value");
		searchBoxIcon.click();
		PomAmazonPageOne amazon1 = managerAmazon.getPomAmazonPageOne();
		WebElement productOne = amazon1.getProductOne();
		String pageTitle = driver.getTitle();
		System.out.println("\nPage Title : "+pageTitle+"\n-----------");
		System.out.println("\n  Products check:\n  --------------");
		product1 = productOne.getText();
		WebElement productThree = amazon1.getProductThree();
		String product2 = productThree.getText();
		WebElement productFive = amazon1.getProductFive();
		String product3 = productFive.getText();
		System.out.println("  Given: "+search+"\n  in LIst: "+product1+"\n           "+product2+"\n           "+product3);
		productOne.click();
	}
	@Test
	public void logIn4() throws InterruptedException {
		switchWindow();
		String pageTitle = driver.getTitle();
		System.out.println("\nTitle : "+pageTitle+"\n-------------");
		PomAmazonPageTwo amazon2 = managerAmazon.getPomAmazonPageTwo();
		WebElement productTitle = amazon2.getProductTitle();
		String productTitleText = productTitle.getText();
		System.out.println("  Product Given: "+product1+"\n  Product showing: "+productTitleText);
		WebElement addToCart = amazon2.getAddToCart();
		addToCart.click();
		Thread.sleep(20000);
		WebElement checkOut = amazon2.getCheckOut();
		checkOut.click();
	}
}
