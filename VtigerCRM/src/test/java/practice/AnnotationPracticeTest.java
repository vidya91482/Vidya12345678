package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationPracticeTest {
	
	@Test(groups="smoke")
	public void sampleTest1()
	{
		System.out.println("----ST-1----");
		
	}
	
	@BeforeClass(groups="smoke")
	public void login()
	{
		System.out.println("---login successful---");
		
	}
	
	@BeforeMethod(groups="regression")
	public void data()
	{
		System.out.println("----enter the data-----");
		
	}
	
	@Test(groups="smoke")
	public void sampleTest2()
	{
		System.out.println("----ST-2---");
	}
	
	@AfterMethod(groups="regression")
	public void verifyData()
	{
		System.out.println("---Data varified---");
	}
	
	@AfterClass(groups="smoke")
	public void logout()
	{
		System.out.println("---logout successful---");
	}

}
