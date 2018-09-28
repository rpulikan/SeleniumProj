package com.wdhybridFW.TestCases;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wdhybridFW.PageObjects.HomePage_NewHire;


public class TC_NewHire_002 extends BaseClass {
	
	@Test
	public void navtocreateNH() throws IOException,InterruptedException
	{
		
		HomePage_NewHire hp = PageFactory.initElements(driver,HomePage_NewHire.class); 
		hp.Setsearch("Start Proxy");
		Thread.sleep(10000          );
		hp.ClickStartProxy();
		
		hp.ClickStartProxy();
		hp.setActas(readconfig.getRole());//Getting the data from config.prop file
		hp.ClickOK();
		hp.Setsearch("Hire Employee");
		Thread.sleep(3000);
		hp.clickHireNewEmp();
		hp.SelectRdioCreateNew();		
		hp.ClickOK();
		
	}

}
