package dataDriverFramework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLogin extends BaseTest implements IAutoConstant {
	public static void main(String[] args) throws IOException, InterruptedException {
		Flib flib = new Flib();
//      String url = flib.readPropertyData(PROP_PATH, URL);      
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.get(url);
		 BaseTest bt = new BaseTest();
	     bt.browserSetUp();
		
	     driver.findElement(By.linkText("Log in")).click();
          
	     int rc = flib.lastRowCount(EXCEL_PATH, INVALIDLOGINCREDS);
	     
		 for (int i = 1; i <= rc; i++) {
			String email = flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 0);
			String password = flib.readExcelData(EXCEL_PATH, INVALIDLOGINCREDS, i, 1);
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Password")).clear();						
		}
		 Thread.sleep(1000);
		 bt.browserTearDown();
	}
}
