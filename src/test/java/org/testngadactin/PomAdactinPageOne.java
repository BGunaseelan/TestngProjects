package org.testngadactin;

import org.base.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAdactinPageOne extends BaseClass{
	public PomAdactinPageOne() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//select[@id='location']")
	private WebElement location;
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotels;
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomType;
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement roomNum;
	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adultRoom;
	@FindBy(xpath="//select[@id='child_room']")
	private WebElement childRoom;
	@FindBy(xpath="//input[@id='datepick_in']")
	private WebElement datePickIn;
	@FindBy(xpath="//input[@id='datepick_out']")
	private WebElement datePickOut;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton1;
	@FindBy(xpath="//input[@name='username_show']")
	private WebElement showUsername;
	
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotels() {
		return hotels;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getRoomNum() {
		return roomNum;
	}
	public WebElement getAdultRoom() {
		return adultRoom;
	}
	public WebElement getChildRoom() {
		return childRoom;
	}
	public WebElement getDatePickIn() {
		return datePickIn;
	}
	public WebElement getDatePickOut() {
		return datePickOut;
	}
	public WebElement getSubmitButtonOne() {
		return submitButton1;
	}
	public WebElement getShowUsername() {
		return showUsername;
	}
}
