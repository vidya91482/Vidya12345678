package endtoend;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Crm.ObjectRepository.CreateLeadPage;
import com.Crm.ObjectRepository.HomePageForLead;
import com.Crm.ObjectRepository.LeadInformationPage;
import com.Crm.ObjectRepository.LeadsInfoPage;

import genericUtilities.BaseClass;
//@Listeners(genericUtilities.ListnerIMPClass.class)
public class BaseClassManagementLeadEvent extends BaseClass {
	@Test(groups="smoke")
	public void leadEvent() throws EncryptedDocumentException, IOException
	{
		String first_name = eutils.readDataFromExcel("Leads3", 1, 0);
 		String last_name= eutils.readDataFromExcel("Leads3", 1, 1);
		String company_name = eutils.readDataFromExcel("Leads3", 1, 2);
		String event_name = eutils.readDataFromExcel("Leads3", 1, 3);
		String Location = eutils.readDataFromExcel("Leads3", 1, 4);
		String start_date = eutils.readDataFromExcel("Leads3", 1, 5);
		String end_date = eutils.readDataFromExcel("Leads3", 1, 6);
		 HomePageForLead lhp=new HomePageForLead(driver);
		 lhp.leadsLinkclk();

		 LeadsInfoPage lipage = new LeadsInfoPage(driver);
		 lipage.leadLookupImg();
		 CreateLeadPage clpage = new CreateLeadPage(driver);
		 clpage.createLead(driver, first_name, last_name, company_name);
		 LeadInformationPage leadinfopage=new LeadInformationPage(driver);
		 leadinfopage.addEventClk();
		 fail();
		 String eventpagename = driver.findElement(By.xpath("//span[text()='Creating Event']")).getText();
		  if(eventpagename.contains(
				  "Creating Event")) {
			  System.out.println("event page displyaed");
		  }
		  else {
			  System.out.println("event page not displyed");
			  System.out.println("abc");
		
	}
	
	

}
}
	
