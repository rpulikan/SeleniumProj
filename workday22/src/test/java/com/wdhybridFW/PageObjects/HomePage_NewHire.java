package com.wdhybridFW.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_NewHire {
	
	public WebDriver driver ;
	
	public  void HomePage(WebDriver driver){
		
		this.driver = driver;
		
		
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/input")
	WebElement Search;

	@FindBy(xpath = "/html/body/div[5]/div[1]/div[1]/section/div/div/div/div[1]/div/div[2]/div[2]/div/ul/li/div/div/div[1]/ul")
	WebElement StartProxy;
	
	@FindBy(xpath="/html/body/div[6]/div[1]/div[1]/section/div[1]/div/div/div[1]/div/div/ul/li[2]/div[2]/div/div/div[1]/input")
	WebElement ActAs;
	
	@FindBy(xpath="/html/body/div[6]/div[1]/div[1]/section/div[2]/div[1]/div[1]/button[1]/span[2]")
	WebElement OK;
	
	@FindBy(xpath = "//*[@id=\"gwt-uid-4\"]")
	WebElement RdioCreateNew;
	
	@FindBy(xpath = "//*[@id=\"56$284553\"]")
	WebElement lnkHireEmp;

	
	public void Setsearch(String proxy) {
		Search.sendKeys(proxy);
		Search.sendKeys(Keys.ENTER);
	}
	public void ClickStartProxy() {
		StartProxy.click();
	}
	
	public void setActas(String actrole) {
		ActAs.sendKeys(actrole);
		ActAs.sendKeys(Keys.ENTER);
		
	}
	
	public void ClickOK() {
		OK.click();
	}
	
	public void SelectRdioCreateNew() {
		RdioCreateNew.click();
	}
	
	public void clickHireNewEmp() {
		lnkHireEmp.click();
	}
	
}
