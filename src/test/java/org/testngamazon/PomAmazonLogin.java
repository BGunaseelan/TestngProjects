package org.testngamazon;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAmazonLogin extends BaseClass {
	public PomAmazonLogin() {
		PageFactory.initElements(driver, this);
	}
	//Login
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement signIn;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement username;
	@FindBy(xpath = "//input[@class='a-button-input']")
	private WebElement continueButton;
	@FindBy(xpath = "//h4[@class='a-alert-heading']")
	private WebElement warning1;
	@FindBy(xpath = "//span[@class='a-list-item']")
	private WebElement warning2;
	@FindBy(xpath = "//a[@class='a-button-text']")
	private WebElement createAccount;
	@FindBy(xpath = "//input[@name='field-keywords']")
	private WebElement searchBox;
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchBoxIcon;
	
	
	public WebElement getSignIn() {
		return signIn;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getContinueButton() {
		return continueButton;
	}
	public WebElement getWarning1() {
		return warning1;
	}
	public WebElement getWarning2() {
		return warning2;
	}
	public WebElement getCreateAccount() {
		return createAccount;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getSearchBoxIcon() {
		return searchBoxIcon;
	}
}
