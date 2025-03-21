package testNGPackage1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToUnderstandDependentsOnMethod {
  @Test(dependsOnMethods = "register")
  public void login() {
	  Reporter.log("This is login method", true);
  }
  
  @Test
  public void register() {
	  Reporter.log("This is register method", true);
  }
  
  @Test(dependsOnMethods = {"register","login"})//For more than 1 dependents method use inside {}
  public void checkAccountBalance() {
	  Reporter.log("This is checkAccountBalance method", true);
  }
  
  @Test(dependsOnMethods = {"login","moneyTransfer"})
  public void logout() {
	  Reporter.log("This is logout method", true);
  }
  
  @Test(dependsOnMethods = {"login","checkAccountBalance"})
  public void moneyTransfer() {
	  Reporter.log("This is moneyTransfer method", true);
  }
}
