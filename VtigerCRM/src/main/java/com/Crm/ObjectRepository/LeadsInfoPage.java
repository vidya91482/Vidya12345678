package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {
	@FindBy(xpath = "//img[@alt=\"Create Lead...\"]")private WebElement createleadLookImg;
	
	public LeadsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateLeadLookupImg()
	{
		return createleadLookImg;
	}
	
	public void leadLookupImg()
	{
		createleadLookImg.click();
	}

}
