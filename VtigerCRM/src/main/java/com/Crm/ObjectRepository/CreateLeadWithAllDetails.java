package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateLeadWithAllDetails {
	@FindBy(xpath = "//select[@name='salutationtype']")private WebElement firstnameDropdownTxt;
	@FindBy(xpath = "//input[@name='lastname']")private WebElement lastnameEditTxt;
	@FindBy(xpath = "//input[@name='company']")private WebElement companyEditTxt;
	@FindBy(xpath = "//input[@id='noofemployees']")private WebElement noOfEmployeesEditTxt;
	@FindBy(xpath = "//input[@id='secondaryemail']")private WebElement secondaryMailEditTxt;
	@FindBy(xpath = "//input[@name='mobile']")private WebElement mobileEditTxt;
	@FindBy(xpath = "//input[@id='email']")private WebElement emailEditTxt;
	@FindBy(xpath = "(//input[@name='button'])[1]")private WebElement savebtnClk;
	
	public CreateLeadWithAllDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstnameDropdownTxt() {
		return firstnameDropdownTxt;
	}

	public void setFirstnameDropdownTxt(WebElement firstnameDropdownTxt) {
		this.firstnameDropdownTxt = firstnameDropdownTxt;
	}

	public WebElement getLastnameEditTxt() {
		return lastnameEditTxt;
	}

	public void setLastnameEditTxt(WebElement lastnameEditTxt) {
		this.lastnameEditTxt = lastnameEditTxt;
	}

	public WebElement getCompanyEditTxt() {
		return companyEditTxt;
	}

	public void setCompanyEditTxt(WebElement companyEditTxt) {
		this.companyEditTxt = companyEditTxt;
	}

	public WebElement getNoOfEmployeesEditTxt() {
		return noOfEmployeesEditTxt;
	}

	public void setNoOfEmployeesEditTxt(WebElement noOfEmployeesEditTxt) {
		this.noOfEmployeesEditTxt = noOfEmployeesEditTxt;
	}

	public WebElement getSecondaryMailEditTxt() {
		return secondaryMailEditTxt;
	}

	public void setSecondaryMailEditTxt(WebElement secondaryMailEditTxt) {
		this.secondaryMailEditTxt = secondaryMailEditTxt;
	}

	public WebElement getMobileEditTxt() {
		return mobileEditTxt;
	}

	public void setMobileEditTxt(WebElement mobileEditTxt) {
		this.mobileEditTxt = mobileEditTxt;
	}

	public WebElement getEmailEditTxt() {
		return emailEditTxt;
	}

	public void setEmailEditTxt(WebElement emailEditTxt) {
		this.emailEditTxt = emailEditTxt;
	}
	public WebElement getsavebtntxt()
	{
		return savebtnClk;
	}
	
	public void createLead(WebDriver driver, String firstname,String lastname,String company,String noofemp,String secondarymail,String mobile,String mail)
	{
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.selectByIndex(driver, firstnameDropdownTxt, 2);
		firstnameDropdownTxt.sendKeys(firstname);
		lastnameEditTxt.sendKeys(lastname);
		companyEditTxt.sendKeys(company);
		noOfEmployeesEditTxt.sendKeys(noofemp);
		secondaryMailEditTxt.sendKeys(secondarymail);
		mobileEditTxt.sendKeys(mobile);
		emailEditTxt.sendKeys(mail);
		savebtnClk.click();
		
		
		
		
	}
	
     
}
