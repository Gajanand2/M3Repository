package parameterization;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedMethod {
	WebDriver driver=null;
	
	@Parameters("bname")
	
  @Test
  public void parameterMethod(@Optional("chrome")String bname) {
	  if (bname.equalsIgnoreCase("chrome")) 
	  {
		driver=new ChromeDriver();
	  } 
	  else if (bname.equalsIgnoreCase("edge"))
	  {
         driver=new EdgeDriver();
	  }
	  else if(bname.equalsIgnoreCase("firefox"))
	  {
		 driver=new FirefoxDriver(); 
	  }
	  else 
	  {
		 System.out.println("invalid bname");
	  }
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  }
      @AfterMethod
      public void tearDown() 
      {
    	  driver.quit();
      }
}
