package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
//Declaration
	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']") private WebElement smartphoneCartProduct;
	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']/../..//input[@name='removefromcart']") private WebElement smartphoneCheckBox;
	@FindBy(name = "updatecart") private WebElement updateShoppingCartButton;
	@FindBy(name = "continueshopping") private WebElement continueShoppingButton;
	@FindBy(id = "termsofservice") private WebElement termsOfServicesCheckBox;
	@FindBy(id = "checkout") private WebElement checkoutButton;
	
	//Initialization
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	
	//Utilization
	public WebElement getSmartphoneCartProduct() {
		return smartphoneCartProduct;
	}
	public WebElement getSmartphoneCheckBox() {
		return smartphoneCheckBox;
	}

	public WebElement getUpdateShoppingCartButton() {
		return updateShoppingCartButton;
	}

	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getTermsOfServicesCheckBox() {
		return termsOfServicesCheckBox;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}

	
	
	
	
	
}
