package testPackage;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;

@Listeners(genericLibrary.MyListener.class)
public class TC_RemoveProductFromCart_002_Test extends BaseTest {
  @Test
  public void removeProductFromCart() {
	  WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();

		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();

		ep.getsmartphoneAddtoCart().click();

		wp.getShoppingCart().click();
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		sp.getSmartphoneCheckBox().click();
		
		sp.getUpdateShoppingCartButton().click();
		
		SoftAssert sa = new SoftAssert();
		try 
		{
		sa.assertEquals(sp.getSmartphoneCartProduct().isDisplayed(),false, "Product is not removed");
		} 			 
		catch (Exception e)
		{
		Reporter.log("Product is Reomoved from Cart",true);
        }
		sa.assertAll();
}
}