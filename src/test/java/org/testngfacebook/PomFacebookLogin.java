package org.testngfacebook;

import org.base.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomFacebookLogin extends BaseClass{
	public PomFacebookLogin() {
		PageFactory.initElements(driver, this);
	}
	//Login
	@FindBy(xpath = "//input[@type='text']")
	private WebElement username;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@value='1']")
	private WebElement loginButton;
	
	
	public WebElement getUserName() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
}
