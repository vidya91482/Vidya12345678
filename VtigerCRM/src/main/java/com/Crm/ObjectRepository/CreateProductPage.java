package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	@FindBy(xpath = "//input[@name='productname']")private WebElement productnameEditTxt;
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")private WebElement savebtnClick;
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProductNamrEditTxt()
	{
		return productnameEditTxt;
	}
	
	public WebElement getSavebtnClick()
	{
		return savebtnClick;
	}
	
	public void createProduct(String firstname)
	{
		productnameEditTxt.sendKeys(firstname);
		savebtnClick.click();
		
	}

}
