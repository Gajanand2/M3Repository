package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import genericLibrary.Flib;
import genericLibrary.SelectUtility;

public class CheckoutPage extends BaseTest {
//Declaration
	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryDropdown;
	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityTextBox;
	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1TextBox;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement pinCodeTextBox;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneNoTextBox;
	@FindBy(xpath = "//input[@onClick='Billing.save()']")
	private WebElement billingAddressCB;
	@FindBy(xpath = "//input[@onClick='Shipping.save()']")
	private WebElement shippingCB;
	@FindBy(xpath = "//input[@onClick='ShippingMethod.save()']")
	private WebElement shippingMethodCB;
	@FindBy(xpath = "//input[@onClick='PaymentMethod.save()']")
	private WebElement paymentMethodCB;
	@FindBy(xpath = "//input[@onClick='PaymentInfo.save()']")
	private WebElement paymentInfoCB;
	@FindBy(xpath = "//input[@onClick='ConfirmOrder.save()']")
	private WebElement confirmOrderCB;
	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	private WebElement orderProcessedText;
	@FindBy(id =  "billing-address-select")
	private WebElement oldAddressDD;
//Initialization
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Utilization
	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCityTextBox() {
		return cityTextBox;
	}

	public WebElement getAddress1TextBox() {
		return address1TextBox;
	}

	public WebElement getPinCodeTextBox() {
		return pinCodeTextBox;
	}

	public WebElement getPhoneNoTextBox() {
		return phoneNoTextBox;
	}

	public WebElement getBillingAddressCB() {
		return billingAddressCB;
	}

	public WebElement getShippingCB() {
		return shippingCB;
	}

	public WebElement getShippingMethodCB() {
		return shippingMethodCB;
	}

	public WebElement getPaymentMethodCB() {
		return paymentMethodCB;
	}

	public WebElement getPaymentInfoCB() {
		return paymentInfoCB;
	}

	public WebElement getConfirmOrderCB() {
		return confirmOrderCB;
	}

	public WebElement getOrderProcessedText() {
		return orderProcessedText;
	}
	public WebElement getOldAddressDD() {
		return oldAddressDD;
	}

//Operational Method
	public void buyProductMethod() throws EncryptedDocumentException, IOException {
		SelectUtility su = new SelectUtility();
       try { 	
		if (oldAddressDD.isDisplayed()==true) {		
		 su.selectByVisibleTextMethod(oldAddressDD, "New Address");
        }
       }
       catch (Exception e) 
       {
		su.selectByVisibleTextMethod(countryDropdown, "India");
       }
       su.selectByVisibleTextMethod(countryDropdown, "India");

		Flib flib = new Flib();
		int rn = flib.randomNumber();
		String address1 = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 0);
		String city = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 1);
		long pin = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails", 1, 2);
		long phone= flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails", 1, 3);

		//String pin = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 2);
		//String phone= flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 3);
	
		String phoneNo = phone+""+rn;
		
		cityTextBox.sendKeys(city);
		address1TextBox.sendKeys(address1);
		pinCodeTextBox.sendKeys(String.valueOf(pin));
		phoneNoTextBox.sendKeys(String.valueOf(phoneNo));
		billingAddressCB.click();
		
		shippingCB.click();
		shippingMethodCB.click();
		
		paymentMethodCB.click();
		paymentInfoCB.click();
		
		
		confirmOrderCB.click();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(orderProcessedText.isDisplayed(), true,"Order is not placed!!");
		
		sa.assertAll();
	}
}
