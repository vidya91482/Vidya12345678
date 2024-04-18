package lead;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Crm.ObjectRepository.CreateLeadPage;
import com.Crm.ObjectRepository.CreateLeadWithAllDetails;
import com.Crm.ObjectRepository.HomePageForLead;
import com.Crm.ObjectRepository.LeadsInfoPage;
import com.Crm.ObjectRepository.LoginPage;

import genericUtilities.DatabaseUtility;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.WebDriverUtility;
import genericUtilities.javaUtility;

public class Lead1Test {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility futil = new FileUtility();
		ExcelUtility eutil = new ExcelUtility();
		DatabaseUtility dutil = new DatabaseUtility();
		javaUtility jutil = new javaUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		System.out.println("Hello");
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commanData.properties");

		// Properties p = new Properties();
		// p.load(fis);
		String Browser = futil.readDataFromPropertyFile("Browser");
		String Url = futil.readDataFromPropertyFile("Url");
		String Username = futil.readDataFromPropertyFile("Username");
		String Password = futil.readDataFromPropertyFile("Password");
		System.out.println(Url);
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
//			Workbook wh = WorkbookFactory.create(fis1);
		String first_name = eutil.readDataFromExcel("Leads2", 1, 0);
		String last_name = eutil.readDataFromExcel("Leads2", 1, 1);
		String company_name = eutil.readDataFromExcel("Leads2", 1, 2);
		String no_of_employee = eutil.readDataFromExcel("Leads2", 1, 3);
		String secondary_mail = eutil.readDataFromExcel("Leads2", 1, 4);
		String mobile = eutil.readDataFromExcel("Leads2", 1, 5);
		String email = eutil.readDataFromExcel("Leads2", 1, 6);
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
		HomePageForLead homePage = new HomePageForLead(driver);
		homePage.leadsLinkclk();
		LeadsInfoPage lipage = new LeadsInfoPage(driver);
		lipage.leadLookupImg();
		CreateLeadWithAllDetails cleadwithAllDetails=new CreateLeadWithAllDetails(driver);
		cleadwithAllDetails.createLead(driver, first_name, last_name, company_name, no_of_employee, secondary_mail, mobile, email);
			
				
		 
		 
//    		driver.findElement(By.name("user_name")).sendKeys(Username);
//   		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
//   		driver.findElement(By.id("submitButton")).click();
//    		driver.findElement(By.cssSelector("[href='index.php?module=Leads&action=index']")).click();
//    		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
//		    WebElement dropdown = driver.findElement(By.name("salutationtype"));
//    		  Select s=new Select(dropdown);
//    		  s.selectByVisibleText(first_name);
//		      driver.findElement(By.name("lastname")).sendKeys(last_name);
 //  		  driver.findElement(By.name("company")).sendKeys(company_name);
//		      driver.findElement(By.id("noofemployees")).sendKeys("100");
//    		  driver.findElement(By.id("secondaryemail")).sendKeys( secondary_mail);
//    		  driver.findElement(By.id("mobile")).sendKeys(mobile);
//    		  driver.findElement(By.id("email")).sendKeys(email);
//    		  Thread.sleep(2000);
//    		  driver.findElement(By.name("button")).click();
//    		  Thread.sleep(2000);
		String leadsname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (leadsname.contains(last_name)) {
			System.out.println("Pass:Lead is created with all details");
		} else {
			System.out.println("Fail");
		}
		Thread.sleep(3000);
		driver.quit();

	}
}
