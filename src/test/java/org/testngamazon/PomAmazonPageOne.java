package org.testngamazon;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAmazonPageOne extends BaseClass {
	public PomAmazonPageOne() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement productOne;
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")
	private WebElement productThree;
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[5]")
	private WebElement productFive;
	
	public WebElement getProductOne() {
		return productOne;
	}
	public WebElement getProductThree() {
		return productThree;
	}
	public WebElement getProductFive() {
		return productFive;
	}
}
