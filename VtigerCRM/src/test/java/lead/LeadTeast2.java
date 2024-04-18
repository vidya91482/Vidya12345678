package lead;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.Crm.ObjectRepository.CreateLeadPage;
import com.Crm.ObjectRepository.HomePageForLead;
import com.Crm.ObjectRepository.HomePageForProduct;
import com.Crm.ObjectRepository.LeadInformationPage;
import com.Crm.ObjectRepository.LeadsInfoPage;
import com.Crm.ObjectRepository.LoginPage;

import genericUtilities.DatabaseUtility;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.WebDriverUtility;
import genericUtilities.javaUtility;

public class LeadTeast2 {
	 public static WebDriver driver;
		public static void main(String[] args) throws IOException, InterruptedException {
			FileUtility futil=new FileUtility();
			ExcelUtility eutil=new ExcelUtility();
			DatabaseUtility dutil=new DatabaseUtility();
			javaUtility jutil=new javaUtility();
			WebDriverUtility wutil=new WebDriverUtility();
			
			System.out.println("Hello");
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commanData.properties");

//			Properties p = new Properties();
//			p.load(fis);
			String Browser = futil.readDataFromPropertyFile("Browser");
			String Url = futil.readDataFromPropertyFile("Url");
			String Username = futil.readDataFromPropertyFile("Username");
			String Password = futil.readDataFromPropertyFile("Password");
//			FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
//			Workbook wh = WorkbookFactory.create(fis1);
			String first_name = eutil.readDataFromExcel("Leads3", 1, 0);
     		String last_name= eutil.readDataFromExcel("Leads3", 1, 1);
			String company_name = eutil.readDataFromExcel("Leads3", 1, 2);
			String event_name = eutil.readDataFromExcel("Leads3", 1, 3);
			String Location = eutil.readDataFromExcel("Leads3", 1, 4);
			String start_date = eutil.readDataFromExcel("Leads3", 1, 5);
			String end_date = eutil.readDataFromExcel("Leads3", 1, 6);
			
			if (Browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(Url);
			 LoginPage loginPage = new LoginPage(driver);
			 loginPage.logiToApp(Username, Password);
			 HomePageForLead lhp=new HomePageForLead(driver);
			 lhp.leadsLinkclk();
			 LeadsInfoPage lipage = new LeadsInfoPage(driver);
			 lipage.leadLookupImg();
			 CreateLeadPage clpage = new CreateLeadPage(driver);
			 clpage.createLead(driver, first_name, last_name, company_name);
			 LeadInformationPage leadinfopage=new LeadInformationPage(driver);
			 leadinfopage.addEventClk();
			 
//			driver.findElement(By.name("user_name")).sendKeys(Username);
//			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
//			driver.findElement(By.id("submitButton")).click();
//			driver.findElement(By.cssSelector("[href='index.php?module=Leads&action=index']")).click();
//			driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
//			 WebElement dropdown = driver.findElement(By.name("salutationtype"));
//			  Select s=new Select(dropdown);
//			  s.selectByValue(first_name);
//			  driver.findElement(By.name("lastname")).sendKeys(last_name);
//			  driver.findElement(By.name("company")).sendKeys(company_name);
//			  driver.findElement(By.name("button")).click();
//			  driver.findElement(By.xpath("//a[text()='Add Event']")).click();
//			  driver.findElement(By.id("jscal_trigger_date_start")).click();
			  String eventpagename = driver.findElement(By.xpath("//span[text()='Creating Event']")).getText();
			  if(eventpagename.contains(
					  "Creating Event")) {
				  System.out.println("event page displyaed");
			  }
			  else {
				  System.out.println("event page not displyed");
			  }
	//	  driver.findElement(By.name("subject")).sendKeys(event_name);
	//	  driver.findElement(By.name("location")).sendKeys(Location);
	//  driver.findElement(By.name("date_start")).sendKeys(start_date);
	//  driver.findElement(By.name("due_date")).sendKeys(end_date);
			  
			
			



}
}
