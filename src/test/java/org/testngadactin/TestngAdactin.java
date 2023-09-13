package org.testngadactin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngAdactin extends BaseClass {
	static int number;
	static int page;
	static PageManagerAdactin managerAdactin;
	static WebElement username;
	static WebElement password;
	static WebElement loginButton;
	static Workbook workBook;
	static String usernameValue;
	static String valueRoomNum;
	static String valueDatePickIn;
	static String valueDatePickOut;
	static String roomType;
	@BeforeClass
	public static void initialSetup() throws IOException {
		browserLaunch("chrome");
		maximizeWindow();
		loadUrl("https://adactinhotelapp.com/");
		FileInputStream fileStream = accessFileStream(
				"C:\\Users\\Admin\\eclipse-workspace\\ProjectsMavenTestng\\src\\test\\resources\\Data driven Adactin Hotel.xlsx");
		workBook = accessWorkBook("xlsx", fileStream);
		managerAdactin = new PageManagerAdactin();
		PomAdactinLogin adactinLogin = managerAdactin.getPomAdactinLogin();
		username = adactinLogin.getUsername();
		password = adactinLogin.getPassword();
		loginButton = adactinLogin.getLoginButton();
	}
	@AfterClass
	public static void tearDownOperation() {
		quitBrowser();
	}
	@BeforeMethod
	public void beforeTestCase() throws InterruptedException, IOException {
		String pageTitle = driver.getTitle();
		page = page+1;
		System.out.println("\nPage "+page+" Title : "+pageTitle+"\n-------------");
	}
	@AfterMethod
	public void afterTestCase() throws InterruptedException, IOException {
		Thread.sleep(3000);
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\ProjectsMaven\\target\\screenshot"+number+".png");
		takeScreenShot(file);
		number = number+1;
	}
	@Test
	public void ts1() {
		usernameValue = retriveDataFromSheet(workBook, "Sheet1", 1, 0);
		passValue(username, usernameValue);
		passValue(password, retriveDataFromSheet(workBook, "Sheet1", 1, 1));
		clickIt(loginButton);
	}
	@Test
	public void ts2() throws InterruptedException, IOException {
		PomAdactinPageOne adactinPageOne = managerAdactin.getPomAdactinPageOne();
		JavascriptExecutor js =(JavascriptExecutor)driver; //for set attribute value to input dates
		WebElement showUsername = adactinPageOne.getShowUsername();
		String actualUsernamePage1 = showUsername.getAttribute("value");  //Username check
		try {
		Assert.assertEquals("Hello "+usernameValue+"!", actualUsernamePage1);  //Username check
		System.out.println("Username in display is Correct");    //Username check
		}
		catch (AssertionError e) {
			String message = e.getMessage();
			System.out.println("Username in display is Wrong ---> "+message);
		}
		//input details to fields
		passValue(adactinPageOne.getLocation(), retriveDataFromSheet(workBook, "Sheet1", 1, 2));
		passValue(adactinPageOne.getHotels(), retriveDataFromSheet(workBook, "Sheet1", 1, 3));
		roomType = retriveDataFromSheet(workBook, "Sheet1", 1, 4);
		passValue(adactinPageOne.getRoomType(), roomType);
		valueRoomNum = retriveDataFromSheet(workBook, "Sheet1", 1, 5);
		passValue(adactinPageOne.getRoomNum(), valueRoomNum);
		passValue(adactinPageOne.getAdultRoom(), retriveDataFromSheet(workBook, "Sheet1", 1, 6));
		passValue(adactinPageOne.getChildRoom(), retriveDataFromSheet(workBook, "Sheet1", 1, 7));
		valueDatePickIn = retriveDataFromSheet(workBook, "Sheet1", 1, 8);
		WebElement datePickIn = adactinPageOne.getDatePickIn();
		js.executeScript("arguments[0].setAttribute('value','"+valueDatePickIn+"')", datePickIn);
		valueDatePickOut = retriveDataFromSheet(workBook, "Sheet1", 1, 9);
		WebElement datePickOut = adactinPageOne.getDatePickOut();
		js.executeScript("arguments[0].setAttribute('value','"+valueDatePickOut+"')", datePickOut);
		clickIt(adactinPageOne.getSubmitButtonOne());
	}
	@Test
	public void ts3() {
		PomAdactinPageTwo adactinPageTwo = managerAdactin.getPomAdactinPageTwo();
		WebElement actualUsernamePage2 = adactinPageTwo.getUsernamePage2();
		//Username check
		try {
			Assert.assertEquals("Hello "+usernameValue+"!", actualUsernamePage2);  //Username check
			System.out.println("Username in display is Correct");    //Username check
			}
			catch (AssertionError e) {
				String message = e.getMessage();
				System.out.println("Username in display is Wrong ---> "+message);
			}
		//Rooms count check
		WebElement roomsCount = adactinPageTwo.getRoomsCount();
		String actualRoomsCount = roomsCount.getAttribute("value");
		String expectedRoomsCount = adactinPageTwo.stringConvertionRooms(valueRoomNum);
		if(expectedRoomsCount.equals(actualRoomsCount)) {
			System.out.println("Number of rooms in Display is Correct");
		}else {
			System.out.println("Number of rooms in Display is Wrong");
		}
		//Date-in Check
		WebElement arrivalDate = adactinPageTwo.getArrivalDate();
		String actualDateIn = getAttributeValue(arrivalDate, "value");
		if(valueDatePickIn.equals(actualDateIn)) {
			System.out.println("Arrival Date in Display is Correct");
		}else {
			System.out.println("Arrival Date in Display is Wrong");
		}
		//Date-out check
		WebElement departureDate = adactinPageTwo.getDepartureDate();
		String actualDateOut = getAttributeValue(departureDate, "value");
		if(valueDatePickOut.equals(actualDateOut)) {
			System.out.println("Departure Date in Display is Correct");
		}else {
			System.out.println("Departure Date in Display is Wrong");
		}
		//No. of Days check
		Date fromDate = retriveDateValue(workBook, "Sheet1", 1, 8);
		Date toDate = retriveDateValue(workBook, "Sheet1", 1, 9);
		String calculateDaysByDates = calculateDaysByDates(fromDate, toDate);
		String expectedNumOfDays = adactinPageTwo.stringConvertionDays(calculateDaysByDates);  //ref: pom page 3
		WebElement numOfDays = adactinPageTwo.getNumOfDays();
		String actualNumOfDays = getAttributeValue(numOfDays, "value");
		if(expectedNumOfDays.equals(actualNumOfDays)) {
			System.out.println("Number of Days in Display is Correct");
		}else {
			System.out.println("Number of Days in Display is Wrong");
		}
		//RoomType check
		WebElement roomTypeCheck = adactinPageTwo.getRoomTypeCheck();
		String actualRoomType = getAttributeValue(roomTypeCheck, "value");
		if(roomType.equals(actualRoomType)) {
			System.out.println("Room Type in Display is Correct");
		}else {
			System.out.println("Room Type in Display is Wrong");
		}
		//Button Clicks
		clickIt(adactinPageTwo.getRadioButton());
		clickIt(adactinPageTwo.getContinueButton());
	}
	@Test
	public void ts4() {
		PomAdactinPageThree adactinPageThree = managerAdactin.getPomAdactinPageThree();
		//Username check
		WebElement usernamePage3 = adactinPageThree.getUsernamePage3();
		String actualUsernamePage3 = getAttributeValue(usernamePage3, "value");
		try {
			Assert.assertEquals("Hello "+usernameValue+"!", actualUsernamePage3);  //Username check
			System.out.println("Username in display is Correct");    //Username check
			}
			catch (AssertionError e) {
				String message = e.getMessage();
				System.out.println("Username in display is Wrong ---> "+message);
			}
		//input details to fields
		passValue(adactinPageThree.getFirstName(), retriveDataFromSheet(workBook, "Sheet1", 1, 10));
		passValue(adactinPageThree.getLastName(), retriveDataFromSheet(workBook, "Sheet1", 1, 11));
		passValue(adactinPageThree.getAddress(), retriveDataFromSheet(workBook, "Sheet1", 1, 12));
		passValue(adactinPageThree.getCcNumber(), retriveDataFromSheet(workBook, "Sheet1", 1, 13));
		passValue(adactinPageThree.getCcCvv(), retriveDataFromSheet(workBook, "Sheet1", 1, 14));
		passValue(adactinPageThree.getCcType(), retriveDataFromSheet(workBook, "Sheet1", 1, 15));
		passValue(adactinPageThree.getExpMonth(), retriveDataFromSheet(workBook, "Sheet1", 1, 16));
		passValue(adactinPageThree.getExpYear(), retriveDataFromSheet(workBook, "Sheet1", 1, 17));
		clickIt(adactinPageThree.getBookNowButton());
	}	
	@Test
	public void ts5() throws InterruptedException {
		Thread.sleep(5000);
		PomAdactinPageFour adactinPageFour = managerAdactin.getPomAdactinPageFour();
		String attributeValue = getAttributeValue(adactinPageFour.getOrderNum(), "Value");
		System.out.println("Order number : " + attributeValue); // Print Order number
	}
}
