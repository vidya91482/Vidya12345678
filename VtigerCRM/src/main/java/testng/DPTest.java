package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Crm.ObjectRepository.LoginPage;

public class DPTest {
	@Test(dataProviderClass=DtaproviderTest.class,dataProvider="logindata")
	public void getData(String username,String password)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		LoginPage lp=new LoginPage(driver);
		lp.logiToApp(username, password);
		

		
	}
	@Test(dataProviderClass=ReadDataFromExcelDPTest.class,dataProvider="readDataFromExcel")
	public void getData(String orgname,String Loc,String Course)
	{
		System.out.println(orgname +"  "+ Loc +" "+Course);
	}
	

}
