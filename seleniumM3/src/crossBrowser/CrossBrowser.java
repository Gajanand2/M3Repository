package crossBrowser;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
    @Parameters("bname")
	
	@Test
  public void crossBrowser(@Optional("chrome")String bname) throws InterruptedException {
	
    WebDriver driver=null;

	if (bname.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	} 
	else if(bname.equalsIgnoreCase("firefox")) 
	{
        driver=new EdgeDriver();
	}
	else if (bname.equalsIgnoreCase("edge")) 
	{
		driver=new EdgeDriver();		
	}
	else 
	{
		System.out.println("Invalid Browser name");
	}
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 driver.get("https://demowebshop.tricentis.com/");
	 
	 Thread.sleep(2000);
	 driver.close();
  }
}
