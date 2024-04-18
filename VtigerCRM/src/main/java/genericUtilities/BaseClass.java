package genericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Crm.ObjectRepository.LoginPage;
//import com.beust.jcommander.Parameter;
//import com.beust.jcommander.Parameters;

public class BaseClass {
	public static WebDriver sdriver;
	public DatabaseUtility dutils=new DatabaseUtility();
	public FileUtility futils=new FileUtility();
	public ExcelUtility eutils=new ExcelUtility();
	public WebDriverUtility wutils=new WebDriverUtility();
	public javaUtility jutils=new javaUtility();
	
	public WebDriver driver;
	//@Parameters("Browser")
	
	@BeforeSuite(alwaysRun =true)
	public void connectToDB() throws SQLException
	{
		dutils.connectToDB();
		Reporter.log("----DBConnected---",true);
	}
	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException
	{
	String Browser = futils.readDataFromPropertyFile("Browser");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		sdriver=driver;
	
		wutils.maximiseWindow(driver);
		wutils.waitForPageLoad(driver, 20);
			
	}
	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws IOException
		{
		    String url=futils.readDataFromPropertyFile("Url");
			String username = futils.readDataFromPropertyFile("Username");
			String password=futils.readDataFromPropertyFile("Password");
			driver.get(url);
			
			LoginPage lp=new LoginPage(driver);
			lp.logiToApp(username, password);
			Reporter.log("---Logged in to Applcn---",true);
			
			
			
		}
		
		@AfterMethod(alwaysRun = true)
		public void logoutFromApplcn()
		{
			driver.quit();
		}	
		
		@AfterSuite(alwaysRun = true)
		public void closeDB() throws SQLException
		{
			dutils.closeDB();
		}
		
	
	

	
		
	}
	
	
	


