package endtoend;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Crm.ObjectRepository.CreateLeadWithAllDetails;
import com.Crm.ObjectRepository.HomePageForLead;
import com.Crm.ObjectRepository.LeadsInfoPage;

import genericUtilities.BaseClass;

public class BaseClassMnagementForLead extends  BaseClass {
	//FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
//	Workbook wh = WorkbookFactory.create(fis1);
//String first_name = eutils.readDataFromExcel("Leads2", 1, 0);
//String last_name = eutils.readDataFromExcel("Leads2", 1, 1);
//String company_name = eutils.readDataFromExcel("Leads2", 1, 2);
//String no_of_employee = eutils.readDataFromExcel("Leads2", 1, 3);
//String secondary_mail = eutils.readDataFromExcel("Leads2", 1, 4);
//String mobile = eutils.readDataFromExcel("Leads2", 1, 5);
////String email = eutil.readDataFromExcel("Leads2", 1, 6);
//eutils
@Test(groups="smoke")
public void script() throws Throwable, IOException
{
	String first_name = eutils.readDataFromExcel("Leads2", 1, 0);
	String last_name = eutils.readDataFromExcel("Leads2", 1, 1);
	String company_name = eutils.readDataFromExcel("Leads2", 1, 2);
	String no_of_employee = eutils.readDataFromExcel("Leads2", 1, 3);
	String secondary_mail = eutils.readDataFromExcel("Leads2", 1, 4);
	String mobile = eutils.readDataFromExcel("Leads2", 1, 5);
	String email = eutils.readDataFromExcel("Leads2", 1, 6);

	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	HomePageForLead homePage = new HomePageForLead(driver);
	homePage.leadsLinkclk();
	LeadsInfoPage lipage = new LeadsInfoPage(driver);
	lipage.leadLookupImg();
	CreateLeadWithAllDetails cleadwithAllDetails=new CreateLeadWithAllDetails(driver);
	cleadwithAllDetails.createLead(driver, first_name, last_name, company_name, no_of_employee, secondary_mail, mobile, email);
		
	String leadsname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if (leadsname.contains(last_name)) {
		System.out.println("Pass:Lead is created with all details");
	} else {
		System.out.println("Fail");
	}
	Thread.sleep(3000);
	//driver.quit();
	
	 
}
}
