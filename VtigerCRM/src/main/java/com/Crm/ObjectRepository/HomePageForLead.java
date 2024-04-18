package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageForLead {
	@FindBy(xpath = "//a[text()='Leads']")private WebElement leadsLink;
	@FindBy(xpath = "//a[text()='Opportunities']")private WebElement opportunitiesLink;
	@FindBy(xpath = "//a[text()='Products']")private WebElement productsLink;
	@FindBy(xpath = "//a[text()='More']")private WebElement moreLink;
	@FindBy(xpath = "//a[text()='Campaigns']")private WebElement campaignslink;
	
	
	//Initialization
	public HomePageForLead(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLeadsLink()
	{
		return leadsLink; 
	}
	
	public WebElement getOppotunitiesLink()
	{
		return opportunitiesLink;
	}
	
	public WebElement getProductsLink()
	{
		return productsLink;
	
	}
	
	public WebElement getMoreLink()
	{
		return moreLink; 
	}
	
	public WebElement getCampaignsLink()
	{
		return  campaignslink;
	}
	
	public void leadsLinkclk()
	{
		leadsLink.click();
	}

}
