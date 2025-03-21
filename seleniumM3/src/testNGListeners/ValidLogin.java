package testNGListeners;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testNGListeners.MyListener.class)//Package name . Class name
public class ValidLogin extends BaseTest{
	
	@Test
   public void ValidLoginTC() throws IOException {
	
	//BaseTest bt = new BaseTest();//Object creation of BaseTest class
	//bt.browserSetUp();//To perform pre-requisites
	
	WelcomePage wp = new WelcomePage(driver);//Object creation of WelcomePage class
	wp.getLoginLink().click();//To click on login link
	
	Flib flib = new Flib();//Object creation of Flib class
	String email = flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 4);//0->4 made
	String password = flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 1);
	
	//To perform login
	LoginPage lp = new LoginPage(driver);
	lp.validLoginMethod(email, password);
	
}
}
