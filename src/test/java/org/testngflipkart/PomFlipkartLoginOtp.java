package org.testngflipkart;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomFlipkartLoginOtp extends BaseClass {
	public PomFlipkartLoginOtp() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement mobile;
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement sendOtp;
//	@FindBy(className = "_210lwq")
//	private WebElement verifyOtpMsg;
	
	public WebElement getEnterMobile() {
		return mobile;
	}
	public WebElement getSendOtp() {
		return sendOtp;
	}
//	public WebElement getVerifyMessage() {
//		return verifyOtpMsg;
//	}
}
