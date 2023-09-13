package org.testngflipkart;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomFlipkartLogin extends BaseClass {
	public PomFlipkartLogin() {
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath = "//a[@title='Sign in']")
	@FindBy(className = "_1sLnDu")
	private WebElement loginButton;
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closeButton;
	@FindBy(xpath = "//img[contains(@alt,'Close Feed')]")
	private WebElement closeLikePage;
	
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getCloseButton() {
		return closeButton;
	}
	public WebElement getCloseLikePage() {
		return closeLikePage;
	}
}
