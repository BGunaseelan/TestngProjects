package org.testngadactin;

import org.base.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAdactinPageTwo extends BaseClass{
	public PomAdactinPageTwo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement radioButton;
	@FindBy(id="continue")
	private WebElement continuebutton;
	@FindBy(xpath="(//td[@valign='top'])[2]")
	private WebElement usernamePage2;
	@FindBy(xpath="//input[@name='rooms_0']")
	private WebElement roomsCount;
	@FindBy(xpath="//input[@name='arr_date_0']")
	private WebElement arrivalDate;
	@FindBy(xpath="//input[@name='dep_date_0']")
	private WebElement departureDate;
	@FindBy(xpath="//input[@name='no_days_0']")
	private WebElement numOfDays;
	@FindBy(xpath="//input[@name='room_type_0']")
	private WebElement roomsTypeCheck;
	
	
	
	public WebElement getRadioButton() {
		return radioButton;
	}
	public WebElement getContinueButton() {
		return continuebutton;
	}
	public WebElement getUsernamePage2() {
		return usernamePage2;
	}
	public WebElement getRoomsCount() {
		return roomsCount;
	}
	public WebElement getArrivalDate() {
		return arrivalDate;
	}
	public WebElement getDepartureDate() {
		return departureDate;
	}
	public WebElement getNumOfDays() {
		return numOfDays;
	}
	public WebElement getRoomTypeCheck() {
		return roomsTypeCheck;
	}
	
	public String stringConvertionRooms(String value) {
		switch (value) {
		case "1 - One" :
			String roomNumbers = "1 Rooms";
			return roomNumbers;
		case "2 - Two" :
			String roomNumbers2 = "2 Rooms";
			return roomNumbers2;	
		case "3 - Three" :
			String roomNumbers3 = "3 Rooms";
			return roomNumbers3;	
		case "4 - Four" :
			String roomNumbers4 = "4 Rooms";
			return roomNumbers4;	
		case "5 - Five" :
			String roomNumbers5 = "5 Rooms";
			return roomNumbers5;	
		case "6 - Six" :
			String roomNumbers6 = "6 Rooms";
			return roomNumbers6;	
		case "7 - Seven" :
			String roomNumbers7 = "7 Rooms";
			return roomNumbers7;	
		case "8 - Eight" :
			String roomNumbers8 = "8 Rooms";
			return roomNumbers8;	
		case "9 - Nine" :
			String roomNumbers9 = "9 Rooms";
			return roomNumbers9;	
		case "10 - Ten" :
			String roomNumbers10 = "10 Rooms";
			return roomNumbers10;	
		default:
			return null;
		}
	}
	public String stringConvertionDays(String value) {
		switch (value) {
		case "1" :
			String days = "1 Days";
			return days;
		case "2" :
			String days2 = "2 Days";
			return days2;	
		case "3" :
			String days3 = "3 Days";
			return days3;	
		case "4" :
			String days4 = "4 Days";
			return days4;	
		case "5" :
			String days5 = "5 Days";
			return days5;	
		case "6" :
			String days6 = "6 Days";
			return days6;	
		case "7" :
			String days7 = "7 Days";
			return days7;	
		case "8" :
			String days8 = "8 Days";
			return days8;	
		case "9" :
			String days9 = "9 Days";
			return days9;	
		case "10" :
			String days10 = "10 Days";
			return days10;	
		default:
			return null;
		}
	}
}