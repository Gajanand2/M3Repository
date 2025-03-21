package testNGListeners;

import java.io.IOException;

public class AddToCartPage extends BaseTest {
  public static void main(String[] args) throws IOException {
	BaseTest bt = new BaseTest();
	bt.browserSetUp();
	
	WelcomePage wp = new WelcomePage(driver);
	wp.getLoginLink().click();
	
	Flib flib = new Flib();
	String email = flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 0);
	String password = flib.readExcelData(EXCEL_PATH, VALIDLOGINCREDS, 1, 1);
	
	LoginPage lp = new LoginPage(driver);
	lp.validLoginMethod(email, password);
	
	wp.getElectronicsLink().click();
	
	ElectronicsPage ep = new ElectronicsPage(driver);
	ep.getCellPhoneLink().click();
	
	ep.getsmartphoneAddtoCart().click();
	
	wp.getShoppingCart().click();
	
	ShoppingCartPage sp = new ShoppingCartPage(driver);
	boolean result = sp.getSmartphoneCartProduct().isDisplayed();
	System.out.println(result==true?"Test case is pass & Product is added to Cart":"Test case is fail");
	
}
}
