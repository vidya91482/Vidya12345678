package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateLeadPage {
	@FindBy(name = "salutationtype")private WebElement firstnameDrodown;
	@FindBy(name = "lastname")private WebElement lastnameEditText;
	@FindBy(name = "company")private WebElement companyEditText;
	@FindAll({@FindBy(name = "button"),@FindBy(xpath  = "//input[@class=\"crmButton small save\"]")})private WebElement saveBtnClk;


public CreateLeadPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getFirstnameDropdownEditText()
{
	return firstnameDrodown;
}


	public WebElement getLastnameEditText()
{
	return lastnameEditText;
}

public WebElement getCompanyEditText()
{
	return companyEditText;
}

public WebElement getSaveBtnClk()
{
	return saveBtnClk;
}


public void createLead(WebDriver driver,String firstname,String lastname,String company )
{
	WebDriverUtility wutil=new WebDriverUtility();
	
	wutil.selectByIndex(driver, firstnameDrodown, 2);
	lastnameEditText.sendKeys(lastname);
	companyEditText.sendKeys(company);
	saveBtnClk.click();
	
	
	
	
	
	
}
}
	




	






