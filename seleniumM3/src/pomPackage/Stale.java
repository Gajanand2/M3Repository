package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stale {
	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	
	driver.findElement(By.linkText("Log in")).click();
	WebElement email = driver.findElement(By.id("Email"));//sendKeys("patil223@gmail.com");
	driver.navigate().refresh();
	
	email.sendKeys("patil223@gmail.com");//StaleElementReferenceException
	//To avoid this we need to relocate the email and send keys
	
	WebElement pass = driver.findElement(By.id("Password"));//.sendKeys("Password@123");
	pass.sendKeys("Password@123");
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
}
}