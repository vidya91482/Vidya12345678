package practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationTest {
	@Test(groups="smoke")
	public void script()
	{
		System.out.println("------TestScript 1--------");
		
	}
	
	@BeforeClass(groups="smoke")
	public void login()
	{
		System.out.println("--Login Successful--");
	}
	
	@Test(groups="smoke")
	public void script1()
	{
		System.out.println("-----TestScript-----");
	}
	
	@BeforeMethod(groups="regression")
	public void enterData()
	{
	  System.out.println("--Dta entered Successfully--");	
	}
	
	@AfterMethod(groups="smoke")
	public void logout()
	{
		System.out.println("---Logout Successful");
	}
	
	

}
