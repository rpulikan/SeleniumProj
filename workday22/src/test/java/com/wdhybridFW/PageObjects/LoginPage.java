package com.wdhybridFW.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver; //local driver variable
		
	//This is a constructor to initiate Webdriver
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;		
	}
	
	//Identifying the Objects in LoginPage
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div[3]/div[1]/div/input")
	WebElement txtusername;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div[3]/div[2]/div/input")
	WebElement txtPassword;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/button")
	WebElement btnSignIn;
	
	
	//Creating Action METHODS for each and every Object to call these in Base Class.
	
	public void setUserName(String uname) {
		txtusername.sendKeys(uname);
		
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
		
	}
	
	public void clickSignIn() {
		btnSignIn.click();
	}
	
}
