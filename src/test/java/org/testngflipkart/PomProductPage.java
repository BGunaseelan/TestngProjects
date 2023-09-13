package org.testngflipkart;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomProductPage extends BaseClass{
	public PomProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "B_NuCI")
	private WebElement productTitle;
	@FindBy(xpath = "//button[contains(@class,'_2KpZ6l _2U9uOA _3v1')]")
	private WebElement addToCart;
	public WebElement getProductTitle() {
		return productTitle;
	}
	public WebElement getAddToCart() {
		return addToCart;
	}
}
