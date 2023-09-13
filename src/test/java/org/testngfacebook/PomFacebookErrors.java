package org.testngfacebook;

import org.base.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomFacebookErrors extends BaseClass{
	public PomFacebookErrors() {
		PageFactory.initElements(driver, this);
	}
	//Error Page Case1 Analysis
		@FindBy(xpath = "//h2[@class='uiHeaderTitle']")
		private WebElement codeMessage;
		@FindBy(xpath = "//div[@class='_aklw']")
		private WebElement codeMessage2;
		@FindBy(xpath = "//a[@class='_aklt']")
		private WebElement codeMessage3;
		
		//Error Page Case2 Analysis
		@FindBy(xpath = "//h2[@class='uiHeaderTitle']")
		private WebElement identifyMessage1;
		@FindBy(xpath = "//div[@class='_9nq2']")
		private WebElement identifyMessage2;
		@FindBy(xpath = "//a[@role='button']")
		private WebElement identifyMessageTry;
		
		//Error Page Case3 Analysis
		@FindBy(xpath = "//span[@class='_50f6']")
		private WebElement loginAsMsg;
		@FindBy(xpath = "//a[@id='not_me_link']")
		private WebElement notYou;
		@FindBy(xpath = "//input[@type='text']")
		private WebElement notYouUsername;
		@FindBy(xpath = "//input[@type='password']")
		private WebElement notYouPass;
		@FindBy(xpath = "//div[@class='_9ay7']")
		private WebElement notYouError;
		@FindBy(partialLinkText = "Forgotten password?")
		private WebElement notYouforgot;
		
		//Error Page Case4 Analysis
		@FindBy(xpath = "//span[@class='_50f6']")
		private WebElement loginAgain1;
		@FindBy(xpath = "//input[@type='password']")
		private WebElement loginAgainPass;
		@FindBy(xpath = "//button[@name='login']")
		private WebElement loginAgainButton;
		@FindBy(xpath = "//a[@name='tryanotherway']")
		private WebElement tryAnotherWay;
		@FindBy(xpath = "//a[@class='_97w4']")
		private WebElement forgetPass;

		//Error Page Case1 Analysis: Title - Facebook
		public WebElement getCodeMessage() {
			return codeMessage;
		}
		public WebElement getCodeMessage2() {
			return codeMessage2;
		}
		public WebElement getCodeMessage3() {
			return codeMessage3;
		}
		
		//Error Page Case2 Analysis: Title - Forgotten Password | Can't Log In | Facebook
		public WebElement getIdentifyMessage1() {
			return identifyMessage1;
		}
		public WebElement getIdentifyMessage2() {
			return identifyMessage2;
		}
		public WebElement getIdentifyMessageTry() {
			return identifyMessageTry;
		}
		
		//Error Page Case3 Analysis: Title - Log in to Facebook
		public WebElement getLoginAsMsg() {
			return loginAsMsg;
		}
		public WebElement getNotYou() {
			return notYou;
		}
		public WebElement getNotYouUsername() {
			return notYouUsername;
		}
		public WebElement getNotYouPass() {
			return notYouPass;
		}
		public WebElement getNotYouError() {
			return notYouError;
		}
		public WebElement getNotYouForgot() {
			return notYouforgot;
		}
		
		//Error Page Case4 Analysis: Try again-Log in to Facebook
		public WebElement getLoginAgain1() {
			return loginAgain1;
		}
		public WebElement getLoginAgainPass() {
			return loginAgainPass;
		}
		public WebElement getLoginAgainButton() {
			return loginAgainButton;
		}
		public WebElement getTryAnother() {
			return tryAnotherWay;
		}
		public WebElement getForgotPass() {
			return forgetPass;
		}

}
