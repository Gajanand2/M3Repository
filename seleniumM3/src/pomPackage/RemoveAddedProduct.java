package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveAddedProduct {
 @FindBy(name = "removefromcart") private WebElement checkBox;
 @FindBy(name = "updatecart") private WebElement updateCartButton;
 
 public RemoveAddedProduct(WebDriver driver)
 {
	PageFactory.initElements(driver, this);
	 
 }

public WebElement getCheckBox() {
	return checkBox;
}

public WebElement getUpdateCartButton() {
	return updateCartButton;
}
 
 
}
