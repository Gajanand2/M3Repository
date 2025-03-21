package dataDriverFramework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest implements IAutoConstant {
	
	static WebDriver driver;

	public void browserSetUp() throws IOException {
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(PROP_PATH, "browser1");
		String url = flib.readPropertyData(PROP_PATH, URL);
        //Here we have stored PROP_PATH in IAutoConstants and we are passing it
		//But in URL we have stored as url only url is the key from property file
		//and we are taking the value of that key from properties file
		//(of IAutoConstant)URL-->url(of properties)-->url value(from properties)
		
		if (browserValue.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserValue.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} 
		
		else if (browserValue.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		} 
		
		else 
		{
			System.out.println("Enter Valid Browser Name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	    }
	
	    public void browserTearDown()
	    {
	      driver.quit();			
	    }
}