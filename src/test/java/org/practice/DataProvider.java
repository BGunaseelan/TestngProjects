package org.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.base.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testngfacebook.PageManagerTestngFacebook;
import org.testngfacebook.PomFacebookLogin;

public class DataProvider extends BaseClass{
	static Workbook workBook;
	@BeforeClass
	public void browserLaunch() throws IOException {
		browserLaunch("chrome");
		maximizeWindow();
		FileInputStream fileStream = accessFileStream("C:\\Users\\Admin\\eclipse-workspace\\ProjectsMavenTestng\\src\\test\\resources\\Data driven Facebook Login IDs.xlsx");
		workBook = accessWorkBook("xlsx", fileStream);
	}
	@BeforeMethod
	public void before() {
		navigateUrl("https://www.facebook.com/");
	}
//	@Test(dataProvider="Login Detail")
	@Test(dataProvider="Login Detail Excell")
	public void loginFeilds1(String userName,String passWord) throws InterruptedException {
		PageManagerTestngFacebook managerFacebook = new PageManagerTestngFacebook();
		PomFacebookLogin pomFacebookLogin = managerFacebook.getPomFacebookLogin();
		passValue(pomFacebookLogin.getUserName(), userName);
		passValue(pomFacebookLogin.getPassword(), passWord);
		clickIt(pomFacebookLogin.getLoginButton());
		Thread.sleep(3000);
		previousPage();
	}
//	@org.testng.annotations.DataProvider(name="Login Detail")
//	public Object[][] data(){
//		Object a[][]= {{"Gunaseelan","123"},{"Ranjith","12345"},{"Raju","12345678"},{"Ranjith","12345"}};
//		return a;
//	}
	@org.testng.annotations.DataProvider(name="Login Detail Excell")
	public Object[][] data(){
		Sheet sheet1 = accessSheet(workBook, "Sheet1");
		int numberOfRows = sheet1.getPhysicalNumberOfRows();
		for(int i=0;i<numberOfRows;i++) {
			Row row = accessRow(sheet1, i);
			int numberOfCells = row.getPhysicalNumberOfCells();
			for(int j=0;j<numberOfCells;j++) {
				Object a[][]= {{i,j}};
				return a;
			}
		}
		return null;
	}
}
