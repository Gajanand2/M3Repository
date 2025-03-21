package pomPackage;

import java.io.IOException;

public class InvalidLogin extends BaseTest {
	 public static void main(String[] args) throws IOException, InterruptedException {
			BaseTest bt = new BaseTest();//Object creation of BaseTest class
			bt.browserSetUp();//To perform pre-requisites
			
			WelcomePage wp = new WelcomePage(driver);//Object creation of WelcomePage class
			wp.getLoginLink().click();//To click on login link
			
			Flib flib = new Flib();//Object creation of Flib class
			int rc = flib.lastRowCount(EXCEL_PATH, INVALIDLOGINCREDS);
			
			//String email = flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 0);
			//String password = flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 1);
			
			//To perform login
			LoginPage lp = new LoginPage(driver);
			
			for (int i = 1; i <=rc; i++) {
				String email = flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 0);
				String password = flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 1);     
				lp.invalidLoginMethod(email, password);
			}
			
}
}