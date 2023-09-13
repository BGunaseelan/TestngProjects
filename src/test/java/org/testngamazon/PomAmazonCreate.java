package org.testngamazon;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAmazonCreate extends BaseClass{
	public PomAmazonCreate() { 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@type='text']")
	private WebElement giveFirstName;
	@FindBy(xpath = "//input[@type='tel']")
	private WebElement giveMobile;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement giveEmail;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement givePassword;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;
	
	public WebElement getFirstName() {
		return giveFirstName;
	}
	public WebElement getMobile() {
		return giveMobile;
	}
	public WebElement getEmail() {
		return giveEmail;
	}
	public WebElement getGivePassword() {
		return givePassword;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
}
