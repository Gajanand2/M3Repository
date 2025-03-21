package testNGExecution2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HeroMotors {
  @Test(groups = "Regression")
  public void launchHeroMotorsTC() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.heromotocorp.com/");
		Thread.sleep(1000);
		driver.close();
	  }
}
