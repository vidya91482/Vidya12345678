package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngSession {
	@Test
	public void login()
	{
		Reporter.log("login success",true);
	}
	
  @Test(priority=1)
  public void usernsme()
  {
	  Reporter.log("username successfully entered",true);
  }
  @Test(priority=2)
  public void logout()
  {
	  Reporter.log("logout success",true);
  }
  
}
