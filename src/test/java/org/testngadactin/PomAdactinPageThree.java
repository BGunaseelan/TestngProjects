package org.testngadactin;

import org.base.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAdactinPageThree extends BaseClass{
	public PomAdactinPageThree() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement firstName;
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement lastName;
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement address;
	@FindBy(xpath="//input[@id='cc_num']")
	private WebElement ccNum;
	@FindBy(xpath="//input[@id='cc_cvv']")
	private WebElement ccCvv;
	@FindBy(xpath="//select[@id='cc_type']")
	private WebElement ccType;
	@FindBy(xpath="//select[@id='cc_exp_month']")
	private WebElement ccExpMonth;
	@FindBy(xpath="//select[@id='cc_exp_year']")
	private WebElement ccExpYear;
	@FindBy(xpath="//input[@id='book_now']")
	private WebElement bookNowButton;
	@FindBy(xpath="//input[@name='username_show']")
	private WebElement usernamePage3;
	
	public WebElement getFirstName() {
		return firstName;	
	}
	public WebElement getLastName() {
		return lastName;	
	}
	public WebElement getAddress() {
		return address;	
	}
	public WebElement getCcNumber() {
		return ccNum;	
	}
	public WebElement getCcCvv() {
		return ccCvv;	
	}
	public WebElement getCcType() {
		return ccType;	
	}
	public WebElement getExpMonth() {
		return ccExpMonth;	
	}
	public WebElement getExpYear() {
		return ccExpYear;	
	}
	public WebElement getBookNowButton() {
		return bookNowButton;	
	}
	public WebElement getUsernamePage3() {
		return usernamePage3;	
	}
}	
