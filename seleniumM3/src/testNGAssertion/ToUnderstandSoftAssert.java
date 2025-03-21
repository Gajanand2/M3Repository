package testNGAssertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ToUnderstandSoftAssert {
	@Test
	public void validLoginTC() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");

		String expectedWelcomePageTitle="Demo Web Shop ";// given title with error
		String expectedLoginPageTitle="Demo Web Shop. Login ";//given title with error
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getTitle(), expectedWelcomePageTitle,"Welcome Page Is not Found!!");
		
		driver.findElement(By.linkText("Log in")).click();
		
		sa.assertEquals(driver.getTitle(), expectedLoginPageTitle,"Login Page Is not Found!!");
		
		driver.findElement(By.id("Email")).sendKeys("patil223@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(1000);
		
		sa.assertAll();//Mandatory in Soft assert at last
	}

}
