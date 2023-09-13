package org.testngadactin;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAdactinLogin extends BaseClass {
	public PomAdactinLogin() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='text']")
	private WebElement username;
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	@FindBy(xpath="//input[@type='Submit']")
	private WebElement loginButton;
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
}
