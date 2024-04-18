package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	@FindBy(xpath = "//img[@alt='Create Product...']")private WebElement createProductLookupLink;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getcreateProductLookupLink()
	{
		return createProductLookupLink;
	}
	
	public void productLookupImg()
	{
		createProductLookupLink.click();
	}
	

}
