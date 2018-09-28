package com.wdhybridFW.TestCases;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.wdhybridFW.PageObjects.LoginPage;

//Calling BaseClass - Inheritance topic in Java - Oops concept

public class TC_LoginTest_001 extends BaseClass {
	
	@Test//TestNG Annotations
	public void logintest() throws IOException,InterruptedException //
	{
		
		logger.info("Workday Login Page Opened");
		System.out.println("Starting the LoginTest");
		LoginPage lp = PageFactory.initElements(driver,LoginPage.class); //Calling the Constructor
				
		lp.setUserName(username); //Calling the Action Methods from Page Objects using the Constructor Object
		lp.setPassword(password);
		lp.clickSignIn();
			
		 if (driver.getTitle().equals("Workday ibm22 - Sign In to Workday"))
		 {
			 logger.info("Landed in Home Page Successfully");
			 Assert.assertTrue(true);
			 captureScreen(driver,"loginTest");
		 }
		 		
	}
	
	
	

}
