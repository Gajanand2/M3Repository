package testNGAnnotation;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToUndestandAnnotation {
  @BeforeTest
  public void beforeTestMethod() {
	  Reporter.log("Before test method",true);
  }
  @AfterMethod // these invoked after every @Test method executes
  public void afterMethod() {
	  Reporter.log("After Method method",true);
  }
  @BeforeSuite
  public void beforeSuitMethod() {
	  Reporter.log("Before Suite method",true);
  }
  @BeforeClass
  public void beforeClassMethod() {
	  Reporter.log("Before Class method",true);
  }
  @AfterClass
  public void afterClassMethod() {
	  Reporter.log("After Class method",true);
  }
  @AfterSuite
  public void afterSuiteMethod() {
	  Reporter.log("After suite method",true);
  }
  @AfterTest
  public void afterTestMethod() {
	  Reporter.log("After test method",true);
  }
  @Test
  public void test1() {
	  Reporter.log("test1 method",true);
  }
  @Test
  public void test2() {
	  Reporter.log("test 2 method",true);
  }
  @BeforeMethod // these invoked before every @Test method executes
  public void beforeMethod() {
	  Reporter.log(" Before method method",true);
  }
  
}
