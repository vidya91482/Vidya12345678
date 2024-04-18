package endtoend;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Crm.ObjectRepository.CreateLeadPage;
import com.Crm.ObjectRepository.HomePageForLead;
import com.Crm.ObjectRepository.LeadsInfoPage;

import genericUtilities.BaseClass;

public class BaseClassManagementForLeadWithMndatory extends BaseClass{
	@Test(groups="smoke")
	public void createLeadWithMandatory() throws EncryptedDocumentException, IOException
	{
		String first_name = eutils.readDataFromExcel("Leads", 1, 0);
		String last_name= eutils.readDataFromExcel("Leads", 1, 1);
		String company_name = eutils.readDataFromExcel("Leads", 1, 2);
		 HomePageForLead homePage = new HomePageForLead(driver);
		 homePage.leadsLinkclk();
		 LeadsInfoPage lipage = new LeadsInfoPage(driver);
		 lipage.leadLookupImg();
		 CreateLeadPage clpage = new CreateLeadPage(driver);
		 clpage.createLead(driver, first_name, last_name, company_name);
		 

	}

}
