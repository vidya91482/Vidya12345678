package com.Crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath = "//input[@name='user_name']")private WebElement usernameEditText;
	@FindBy(xpath = "//input[@name='user_password']")private WebElement passwordEditText;
	@FindBy(id = "submitButton")private WebElement loginbtnclk;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UTILIZATION
	public WebElement getUsernameEditText() 
	{
		return usernameEditText;
	}
	
	public WebElement getpasswordEditText() 
	{
		return passwordEditText;

	}
	
	public WebElement getloginbtnclk() 
	{
	    return	loginbtnclk;
	}
	//Business libraries
	/**
	 * login to application with username and password and click on save btn
	 * @param username
	 * @param password
	 */
	public void logiToApp(String username,String password)
	{
		usernameEditText.sendKeys(username);
		passwordEditText.sendKeys(password);
		loginbtnclk.click();

	}

	
	

}
