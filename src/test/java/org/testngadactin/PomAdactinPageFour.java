package org.testngadactin;

import org.base.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAdactinPageFour extends BaseClass{
	public PomAdactinPageFour() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='order_no']")
	private WebElement orderNum;
	public WebElement getOrderNum() {
		return orderNum;
	}
}
