package org.testngamazon;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAmazonPageTwo extends BaseClass {
	public PomAmazonPageTwo() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement productTitle;
	@FindBy(id = "submit.add-to-cart")
	private WebElement addToCart;
	@FindBy(xpath = "//span[@id='attach-sidesheet-checkout-button']")
	private WebElement checkOut;
	
	
	public WebElement getProductTitle() {
		return productTitle;
	}
	public WebElement getAddToCart() {
	return addToCart;
	}
	public WebElement getCheckOut() {
	return checkOut;
	}
}
