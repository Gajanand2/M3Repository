package testNGPackage1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToUnderstandThreadPoolSize {
	@Test(invocationCount = 5, threadPoolSize = 3)
	// It will be invoked 5 times in 3 different browsers
    // Remaining 2 will open after closing those 3
	public void launchSelenium() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.selenium.dev/");
		Thread.sleep(1000);
		driver.close();
	}
}
