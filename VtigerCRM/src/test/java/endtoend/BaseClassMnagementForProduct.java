package endtoend;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Crm.ObjectRepository.CreateProductPage;
import com.Crm.ObjectRepository.HomePageForProduct;
import com.Crm.ObjectRepository.ProductsPage;

import genericUtilities.BaseClass;





public class BaseClassMnagementForProduct extends BaseClass {
	@Test(groups="smoke")
	public void product() throws EncryptedDocumentException, IOException {
//	 HomePageForProduct productHomePage = new HomePageForProduct(driver);
		HomePageForProduct productHomePage = new HomePageForProduct(driver);
	 productHomePage.productLinkClk();
	 ProductsPage proPage=new ProductsPage(driver);
	 proPage.productLookupImg();
	 
	 String firstname =  eutils.readDataFromExcel("product_Info", 1, 1);
	 CreateProductPage cproPage=new CreateProductPage(driver);
	 cproPage.createProduct(firstname);
	   String Product_Name = eutils.readDataFromExcel("product_Info", 1, 1);
	   String pipage = driver.findElement(By.xpath("//td[text()='Product Information']")).getText();
	   if(pipage.contains("Product Information")) {
		   System.out.println("Product Information page displayed");
	   }
	   else {
		   System.out.println("Product Information page not displayed");
	   }


	
	
	

}
}
	
