package testPackage;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import genericLibrary.Flib;
import pomPackage.ElectronicsPage;
import pomPackage.LoginPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;
@Listeners(genericLibrary.MyListener.class)
public class TC_AddToCartPage_001_Test extends BaseTest {
	@Test
	public void addToCart() throws IOException {
		
//	   BaseTest bt = new BaseTest();
//     bt.browserSetUp();

		
		
//      wp.getLoginLink().click();
//		Flib flib = new Flib();
//		String email = flib.readExcelData(EXCEL_PATH_TEST, VALIDLOGINCREDS, 1, 0);
//		String password = flib.readExcelData(EXCEL_PATH_TEST, VALIDLOGINCREDS, 1, 1);
//		LoginPage lp = new LoginPage(driver);
//		lp.validLoginMethod(email, password);

		WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();

		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();

		ep.getsmartphoneAddtoCart().click();

		wp.getShoppingCart().click();

		ShoppingCartPage sp = new ShoppingCartPage(driver);
		boolean result = sp.getSmartphoneCartProduct().isDisplayed();
		//System.out.println(result == true ? "Test case is pass & Product is added to Cart" : "Test case is fail");
        SoftAssert sa = new SoftAssert();
		sa.assertEquals(result==true, true,"Product is not added to cart");
		sa.assertAll();
	}
}
