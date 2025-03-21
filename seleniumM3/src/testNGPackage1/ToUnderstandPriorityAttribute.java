package testNGPackage1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToUnderstandPriorityAttribute {
  @Test(priority = -4)
  public void login() 
  {
	Reporter.log("This is TestNG login method ", true);  
  }
  @Test(priority = -5)//lesser the no. higher the priority only if class has more than 1 method 
  public void register() //by default it is 0 for all so  run alphabetically 
  {                     //we can give positive no. also
	  Reporter.log("This is TestNG register method ", true);
  }
  @Test(priority = -3)
  public void checkAccountBalance() 
  {
	Reporter.log("This is TestNG checkAccountBalance method ", true);  
  }
  @Test(priority = -2)
  public void moneyTransfer() 
  {
	Reporter.log("This is TestNG moneyTransfer method ", true);  
  }
  @Test(priority = -1)
  public void logout() 
  {
	Reporter.log("This is TestNG logout method ", true);  
  }
}
