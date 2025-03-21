package testNGListeners;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class MyListener extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		Reporter.log("--Test Start--", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("--Test Success--", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String failedMethod = result.getName();
		 String ldt = LocalDateTime.now().toString();
		String timeStamp = ldt.replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorShots/"+failedMethod+timeStamp+".png");	
		
		try {
			FileHandler.copy(src, dest);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("--Test Skipped--"+result.getName(), true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("--Test Failed With Success Percentage--"+result.getName(), true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("Test Failed With Timeout--"+result.getName(), true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("--Started--"+context.getName(), true);	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("--Test Finish--"+context.getName(), true);
	}

}
