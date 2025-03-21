package testNGListeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	    //Declaration
		@FindBy(linkText ="Register") private WebElement registerLink;
		@FindBy(linkText = "Log in") private WebElement loginLink;
		@FindBy(xpath ="//span[text()='Shopping cart']") private WebElement shoppingCart;
		@FindBy(xpath ="//span[text()='Wishlist']") private WebElement wishlistLink;
		@FindBy(partialLinkText ="BOOKS") private WebElement booksLink;
		@FindBy(partialLinkText ="APPAREL & SHOES") private WebElement apparelLink;
		@FindBy(partialLinkText ="COMPUTERS") private WebElement computerLink;
		@FindBy(partialLinkText ="DIGITAL DOWNLOADS") private WebElement digitalDownloadsLink;
		@FindBy(partialLinkText ="JEWELRY") private WebElement jwellaryLink;
		@FindBy(partialLinkText ="GIFT CARDS") private WebElement giftCardsLink;
		@FindBy(partialLinkText ="ELECTRONICS") private WebElement electronicsLink;

		//initialization
		public WelcomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}

		//Utilization
		public WebElement getRegisterLink() {
			return registerLink;
		}

		public WebElement getLoginLink() {
			return loginLink;
		}

		public WebElement getShoppingCart() {
			return shoppingCart;
		}

		public WebElement getWishlistLink() {
			return wishlistLink;
		}

		public WebElement getBooksLink() {
			return booksLink;
		}

		public WebElement getApparelLink() {
			return apparelLink;
		}

		public WebElement getComputerLink() {
			return computerLink;
		}

		public WebElement getDigitalDownloadsLink() {
			return digitalDownloadsLink;
		}

		public WebElement getJwellaryLink() {
			return jwellaryLink;
		}

		public WebElement getGiftCardsLink() {
			return giftCardsLink;
		}

		public WebElement getElectronicsLink() {
			return electronicsLink;
		}
		
		
		
}
