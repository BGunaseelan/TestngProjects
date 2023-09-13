package org.testngflipkart;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomSearchProduct extends BaseClass {
	public PomSearchProduct() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "_3704LK")
	private WebElement searchBar;
	@FindBy(className = "L0Z3Pu")
	private WebElement searchButton;
	@FindBy(xpath = "(//div[@class='_4rR01T'])[1]")
	private WebElement productOne;
	@FindBy(xpath = "(//div[@class='_4rR01T'])[3]")
	private WebElement productThree;
	@FindBy(xpath = "(//div[@class='_4rR01T'])[5]")
	private WebElement productFive;
	
	
	public WebElement getSearchBar() {
		return searchBar;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
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
