package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {
	@FindBy(xpath = "//a[text()='Add Event']")private WebElement addeventlink;
	
	public LeadInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getaddEventClk()
	{
		return addeventlink;
	}
	
	public void addEventClk()
	{
		addeventlink.click();
	}
	

}
