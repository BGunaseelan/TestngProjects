package org.practice;

import org.base.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testngfacebook.PageManagerTestngFacebook;
import org.testngfacebook.PomFacebookLogin;

public class Paramaterization extends BaseClass{
	@BeforeClass
	public void launchBrowser() {
		browserLaunch("chrome");
		maximizeWindow();
	}
	@BeforeMethod
	public void beforeMethod() {
		loadUrl("https://www.facebook.com/");
	}
	@Test
	@Parameters({"userName","passWord"})
	public void loginFeilds1(@Optional("Raju")String userName, @Optional("23456")String passWord) {
		PageManagerTestngFacebook managerFacebook = new PageManagerTestngFacebook();
		PomFacebookLogin pomFacebookLogin = managerFacebook.getPomFacebookLogin();
		passValue(pomFacebookLogin.getUserName(), userName);
		passValue(pomFacebookLogin.getPassword(), passWord);
		clickIt(pomFacebookLogin.getLoginButton());
	}
}
