package lead;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
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
import com.Crm.ObjectRepository.LeadsInfoPage;
import com.Crm.ObjectRepository.LoginPage;

import genericUtilities.DatabaseUtility;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.WebDriverUtility;
import genericUtilities.javaUtility;

public class LeadTest {
    public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility futil=new FileUtility();
		ExcelUtility eutil=new ExcelUtility();
		DatabaseUtility dutil=new DatabaseUtility();
		javaUtility jutil=new javaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		
		System.out.println("Hello");
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commanData.properties");

//		Properties p = new Properties();
//		p.load(fis);
		String Browser =futil.readDataFromPropertyFile("Browser");
		String Url =futil.readDataFromPropertyFile("Url");
		String Username = futil.readDataFromPropertyFile("Username");
		String Password = futil.readDataFromPropertyFile("Password");
		System.out.println(Url);
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
//		Workbook wh = WorkbookFactory.create(fis1);
		String first_name = eutil.readDataFromExcel("Leads", 1, 0);
		String last_name= eutil.readDataFromExcel("Leads", 1, 1);
		String company_name = eutil.readDataFromExcel("Leads", 1, 2);
		System.out.println(first_name);
		System.out.println(last_name);
		System.out.println(company_name);
		
		
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
	 CreateLeadPage clpage = new CreateLeadPage(driver);
	 clpage.createLead(driver, first_name, last_name, company_name);
	 
	 
//	driver.findElement(By.name("user_name")).sendKeys(Username);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.cssSelector("[href='index.php?module=Leads&action=index']")).click();
//		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
//		
		
		
//	  WebElement dropdown = driver.findElement(By.name("salutationtype"));
//	  Select s=new Select(dropdown);
//	  s.selectByValue(first_name);
//	  driver.findElement(By.name("lastname")).sendKeys(last_name);
//	  driver.findElement(By.name("company")).sendKeys(company_name);
//	  driver.findElement(By.name("button")).click();
  String leads_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	  if(leads_name.contains(last_name))
		  System.out.println("Pass:Lead created");
	  else
		  System.out.println("fail");
	  
	  Thread.sleep(3000);
	  driver.quit();
		
//	  Sheet sh2 = wh.getSheet("sheet2");
//	  int rowCount1 = sh2.getLastRowNum();
//	   int cellCount1 = sh2.getRow(0).getLastCellNum();
//	   List<String>list1=new ArrayList<String>();
//	  for(int i=0;i<=rowCount1 ;i++)
//	  {
//		  for(int j=0;j<cellCount1;j++)
//		  {
//			  String value1 = sh2.getRow(i).getCell(j).getStringCellValue();
//			  list1.add(value1);
//		  }
//	  }
//	  WebElement dropdown1 = driver.findElement(By.name("salutationtype"));
//	  Select s1=new Select(dropdown1);
//	  dropdown.sendKeys(list1.get(0));
//	  driver.findElement(By.name("lastname")).sendKeys(list1.get(1));
//	  driver.findElement(By.name("company")).sendKeys(list1.get(2));
//	  driver.findElement(By.id("noofemployees")).sendKeys(list1.get(4));
//	  
//	  driver.findElement(By.name("button")).click();

	  
		


		
	}

}
