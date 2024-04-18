package product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Crm.ObjectRepository.CreateProductPage;
import com.Crm.ObjectRepository.HomePageForLead;
import com.Crm.ObjectRepository.HomePageForProduct;
import com.Crm.ObjectRepository.LoginPage;
import com.Crm.ObjectRepository.ProductsPage;

import genericUtilities.DatabaseUtility;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.WebDriverUtility;
import genericUtilities.javaUtility;

public class ProductTest {
	public static WebDriver driver;


	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileUtility futil=new FileUtility();
		ExcelUtility eutil=new ExcelUtility();
		DatabaseUtility dutil=new DatabaseUtility();
		javaUtility jutil=new javaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		

		
			

				FileInputStream fis= new FileInputStream(".//src/test/resources/commanData.properties");
//				Properties pObj = new Properties();
//				pObj.load(fis);
				
				//login to the Customer Association Hub 
				String Browser = futil.readDataFromPropertyFile("Browser");
				String URL = futil.readDataFromPropertyFile("Url");
				String Username=futil.readDataFromPropertyFile("Username");
				String Password=futil.readDataFromPropertyFile("Password");
				if(Browser.equals("chrome")) {
					driver=new ChromeDriver();
				}else if(Browser.equals("firefox")) {
					driver=new FirefoxDriver();
				}
				
				driver.get(URL);
				 LoginPage loginPage = new LoginPage(driver);
				 loginPage.logiToApp(Username, Password);
				 HomePageForProduct productHomePage = new HomePageForProduct(driver);
				 productHomePage.productLinkClk();
				 ProductsPage proPage=new ProductsPage(driver);
				 proPage.productLookupImg();
				 
				 String firstname =  eutil.readDataFromExcel("product_Info", 1, 1);
				 CreateProductPage cproPage=new CreateProductPage(driver);
				 cproPage.createProduct(firstname);
				 
				 
//				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
//				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
//				driver.findElement(By.id("submitButton")).submit();
			
			
			//navigating to the product page
//		   driver.findElement(By.xpath("//a[.='Products']")).click();
		 
		   //navigating to the create product page
//		   driver.findElement(By.xpath("//img[contains(@src,'themes/softed/images/btnL3Add.gif')]")).click();
		   //connecting to the Excel and importing data
			FileInputStream excel= new FileInputStream("src/test/resources/TestData.xlsx./");
//		   Workbook wb = WorkbookFactory.create(excel);
//		   Sheet sh = wb.getSheet("productInfo");
		   String Product_Name = eutil.readDataFromExcel("product_Info", 1, 1);
//		   String Product_Category = eutil.readDataFromExcel("productInfo", 2, 1);
//		   String Vendor_Name = eutil.readDataFromExcel("productInfo", 3, 1);
//		   String productname = eutil.readDataFromExcel("productInfo", 4, 1);
//		   String Vendor_Part_No = eutil.readDataFromExcel("productInfo", 5, 1);
//		   String Product_Sheet = eutil.readDataFromExcel("productInfo", 6, 1);
//		   String GL_Account=eutil.readDataFromExcel("productInfo", 7, 1);
//		   String Part_Number = eutil.readDataFromExcel("productInfo", 8, 1);
//		   String manufacturer = eutil.readDataFromExcel("productInfo", 9, 1);
//		   String Website = eutil.readDataFromExcel("productInfo", 9, 1);
//		   String Mfr_Part_No = eutil.readDataFromExcel("productInfo", 10, 1);
	//	   String Serial_No = eutil.readDataFromExcel("productInfo", 11, 1);
//		   String Unit_Price = eutil.readDataFromExcel("productInfo", 12, 1);
//		   String Commission_Rate = eutil.readDataFromExcel("productInfo", 13, 1);
	//	   String Usage_Unit = eutil.readDataFromExcel("productInfo", 14, 1);
	//	   String Qty_in_Stock = eutil.readDataFromExcel("productInfo", 15, 1);
	//	   String Handler = eutil.readDataFromExcel("productInfo", 16, 1);
	//	   String Qty_Unit = eutil.readDataFromExcel("productInfo", 17, 1);
	//	   String Reorder_Level = eutil.readDataFromExcel("productInfo", 18, 1);
	//	   String Qty_in_Demand = eutil.readDataFromExcel("productInfo", 19, 1);
	//	   String Description  = eutil.readDataFromExcel("productInfo", 20, 1);

		   
		   //random number
		//   Random r = new Random();
	//	   int random = r.nextInt(500);
		//    String random_product_name = productname+random;
		   
		//   int rowCount = sh.getLastRowNum();
		//   int cellCount = sh.getRow(0).getLastCellNum();
		//   for(int i=0;i<=rowCount;i++) {
//			   String checkvalue = sh.getRow(i).getCell(0).toString();
//			   if(checkvalue.equalsIgnoreCase("Product_Name"))
//			   for(int j=0;j<cellCount;j++) {
//				   String output = sh.getRow(i).getCell(1).toString();
//			   }
		//   }
		   
		   //entering all the textField

//		   driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Product_Name);
//		   driver.findElement(By.name("button")).click();
		   String pipage = driver.findElement(By.xpath("//td[text()='Product Information']")).getText();
		   if(pipage.contains("Product Information")) {
			   System.out.println("Product Information page displayed");
		   }
		   else {
			   System.out.println("Product Information page not displayed");
		   }

				
				
	

				
				
		}
		

			


	}


