package org.testngflipkart;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomFlipkartCreate extends BaseClass {
	public PomFlipkartCreate() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "_14Me7y")
	private WebElement createAccount;
	@FindBy(xpath = "//span[contains(text(),'Looks like')]")
	private WebElement textMessage;
	
	
	public WebElement getCreateButton() {
		return createAccount;
	}
	public WebElement getTextMessage() {
		return textMessage;
	}
	
}
