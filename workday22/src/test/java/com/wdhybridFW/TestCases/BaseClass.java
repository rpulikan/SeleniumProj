package com.wdhybridFW.TestCases;

//import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.wdhybridFW.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL  = readconfig.getApplicationURL() ;
	public String username = readconfig.getUserName() ;
	public String password = readconfig.getPassword() ;
	public String actTitle;
	public static WebDriver driver = null;//This is Static so this can be called anywhere in the package using the class name and instance will be only one.
	
	//Implementing Logger in Base class inorder to be accessible by other classes
	public static Logger logger;
	
		@Parameters("browser")
		@BeforeSuite
		public void setup(String br) throws InterruptedException
		{
			System.out.println("In Setup Class");	
			//System.out.println(System.getProperty("java.class.path")); To get classpath of Java
					
			if(br.equals("firefox"))
			{
				// System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
				driver = new FirefoxDriver();
				System.out.println("Firefox launching");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				logger = Logger.getLogger("loginTest");
				PropertyConfigurator.configure("log4j.properties");//This will work with 1.2 v or log 4j dependency, new version has diff type of code
				
			}else if(br.equals("chrome"))			
			{
				System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
				driver = new ChromeDriver();
			   
							
			}
			//driver.manage().deleteAllCookies();
			driver.get(baseURL);
			System.out.println("Launching WorkDay22");
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);	
							
		}
	
		@AfterSuite//Method to call after class to exit the browser
		public void teardown() 
		{
			driver.quit();
		}
		
		public void captureScreen(WebDriver driver, String tname) throws IOException
		{
			System.out.println("In Screenshot Method");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname+".png");
			FileUtils.copyFile(source,target);
			System.out.println(" Screenshot Taken");
		}

}
