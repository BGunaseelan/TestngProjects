package org.testngfacebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngFacebook extends BaseClass {
	static int number;
	static int row = 0;
	static PageManagerTestngFacebook managerFacebook;
	static WebElement username;
	static WebElement password;
	static WebElement loginButton;
	static Workbook workBook;

	@BeforeClass
	public static void initialSetup() throws InterruptedException, IOException {
		browserLaunch("chrome");
		maximizeWindow();
		FileInputStream fileStream = accessFileStream("C:\\Users\\Admin\\eclipse-workspace\\ProjectsMavenTestng\\src\\test\\resources\\Data driven Facebook Login IDs.xlsx");
		workBook = accessWorkBook("xlsx", fileStream);
	}
	@AfterClass
	public static void tearDownOperation() {
		quitBrowser();
	}
	@AfterMethod
	public void afterTestCase() throws InterruptedException, IOException {
		Thread.sleep(3000);
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\ProjectsMavenTestng\\target\\screenshot"+number+".png");
		takeScreenShot(file);
		number = number+1;
	}
	@BeforeMethod
	public void login() throws InterruptedException, IOException {
		navigateUrl("https://www.facebook.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Login Page Title : "+pageTitle+"\n------------------");
		managerFacebook = new PageManagerTestngFacebook();
		PomFacebookLogin facebook = managerFacebook.getPomFacebookLogin();
		passValue(facebook.getUserName(), retriveDataFromSheet(workBook, "Sheet1", row+1, 0));
		passValue(facebook.getPassword(), retriveDataFromSheet(workBook, "Sheet1", row+1, 1));
		clickIt(facebook.getLoginButton());
		row = row+1;
		Thread.sleep(3000);
	}
	@Test(invocationCount=3,groups = "Sanity")
	public void userLogin() throws IOException, InterruptedException{
		String pageTitle = driver.getTitle();
		System.out.println("\nPage Title : "+pageTitle+"\n------------------");
		//Error Page Case1 Analysis: Title - Facebook
		if(pageTitle.equals("Facebook")) {
			PomFacebookErrors facebook1 = managerFacebook.getPomFacebookErrors();
			WebElement codeMessage = facebook1.getCodeMessage();
			WebElement codeMessage2 = facebook1.getCodeMessage2();
			WebElement codeMessage3 = facebook1.getCodeMessage3();
			System.out.println(codeMessage.getText());
			System.out.println(codeMessage2.getText());
			String text = codeMessage3.getText();
			String attribute = codeMessage3.getAttribute("href");
			System.out.println("Text : "+text+" ---->link: "+attribute);
		//Error Page Case2 Analysis: Title - Forgotten Password | Can't Log In | Facebook
		} else if(pageTitle.equals("Forgotten Password | Can't Log In | Facebook")) {
					PomFacebookErrors facebook1 = managerFacebook.getPomFacebookErrors();
					WebElement identifyMessage1 = facebook1.getIdentifyMessage1();
					System.out.println(identifyMessage1.getText());
					WebElement identifyMessage2 = facebook1.getIdentifyMessage2();
					System.out.println(identifyMessage2.getText());
					WebElement identifyMessageTry = facebook1.getIdentifyMessageTry();
					String text1 = identifyMessageTry.getText();
					String attribute = identifyMessageTry.getAttribute("href");
					System.out.println("Text : "+text1+" ---->link: "+attribute);
				//Error Page Case3 Analysis: Title - Log in to Facebook
				} else if(pageTitle.equals("Log in to Facebook")) {
						PomFacebookErrors facebook1 = managerFacebook.getPomFacebookErrors();
						WebElement loginAsMsg = facebook1.getLoginAsMsg();
						System.out.println(loginAsMsg.getText());
						WebElement notYou = facebook1.getNotYou();
						String text2 = notYou.getText();
						String attribute = notYou.getAttribute("href");
						System.out.println("Text : "+text2+" ---->link: "+attribute);
						try {
						facebook1.getNotYouUsername();
						System.out.println("Username Block is Present");
						} catch(Exception e) {
							System.out.println("Username Block is Absent");
						}
						try {
						facebook1.getNotYouPass();
						System.out.println("Password Block is Present");
						} catch(Exception e){
							System.out.println("Password Block is Absent");
						}
						WebElement notYouError = facebook1.getNotYouError();
						System.out.println(notYouError.getText());
						WebElement notYouForgot = facebook1.getNotYouForgot();
						String text3 = notYouForgot.getText();
						String attribute2 = notYouForgot.getAttribute("href");
						System.out.println("Text : "+text3+" ---->link: "+attribute2);
					//Error Page Case4 Analysis: Try again-Log in to Facebook (Title : Log in to Facebook)
					}	else {
						PomFacebookErrors facebook1 = managerFacebook.getPomFacebookErrors();
							WebElement loginAgain1 = facebook1.getLoginAgain1();
							WebElement tryAnother = facebook1.getTryAnother();
							WebElement forgotPass = facebook1.getForgotPass();
							System.out.println(loginAgain1.getText());
							try {
							facebook1.getLoginAgainPass();
							System.out.println("Password Block is Present");
							}catch(Exception e){
								System.out.println("Password Block is Absent");
							}
							try {
							facebook1.getLoginAgainButton();
							System.out.println("Login Button is Present");
							} catch(Exception e) {
								System.out.println("Login Button is Absent");
							}
							String text4 = tryAnother.getText();
							String attribute2 = tryAnother.getAttribute("href");
							System.out.println("Text : "+text4+" ---->link: "+attribute2);
							String text5 = forgotPass.getText();
							String attribute3 = forgotPass.getAttribute("href");
							System.out.println("Text : "+text5+" ---->link: "+attribute3);
					}
	}
}
