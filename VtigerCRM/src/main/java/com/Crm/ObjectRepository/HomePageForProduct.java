package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageForProduct {
	@FindBy(xpath = "//a[text()='Products']")private WebElement productLink;
	 
	public HomePageForProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProductlink()
	{
		return productLink;
	}
	
	public void productLinkClk()
	{
		productLink.click();
	}

}
