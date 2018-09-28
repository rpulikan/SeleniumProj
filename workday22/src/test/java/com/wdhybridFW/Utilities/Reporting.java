package com.wdhybridFW.Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
		public ExtentHtmlReporter htmlreporter;
		public ExtentReports extent;
		public ExtentTest test;
		
		public void onStart(ITestContext testcontext)
		{
			System.out.println("In Reporting Class");
			//DateFormat sdf = new SimpleDateFormat("MM:dd:yyyy HH:mm:ss");
			//Date date = new Date(System.currentTimeMillis());
			
			String timestamp = new SimpleDateFormat("yyyy-MM-dd hh.mm.ss").format(new Date(System.currentTimeMillis()));
				
			String repName = "Test-Report-Workday-" + timestamp + ".html";
			System.out.println(repName);
			htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+ repName);
			htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			
			extent = new ExtentReports();
			extent.attachReporter(htmlreporter);
			extent.setSystemInfo("Host Name ", "localhost");
			extent.setSystemInfo("Environment ", "V22");
			extent.setSystemInfo("User ", "Ramya");
			
			
			htmlreporter.config().setDocumentTitle("WorkDay V22 Project");
			htmlreporter.config().setReportName("Workday Testing");
			htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlreporter.config().setTheme(Theme.DARK);
					
			
		}
		
		public void onTestSuccess(ITestResult tr)
		{
			test=extent.createTest(tr.getName());
			test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
			Assert.assertTrue(true);
		}
		
		public void onTestFailure(ITestResult tr)
		{
			test=extent.createTest(tr.getName());
			test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
			
			String screenshotPath = System.getProperty("user.dir"+"\\Screenshots\\"+tr.getName()+".png");
			System.out.println(screenshotPath);
			File f = new File(screenshotPath);
			Assert.assertTrue(false);
			
			if(f.exists())
			{
				try {
					test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
					}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}

		public void onTestSkipped(ITestResult tr)
		{
			test=extent.createTest(tr.getName());
			test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		}
		
		/*public void getResult(ITestResult tr){
			 if(tr.getStatus() == ITestResult.FAILURE){
			 //logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			 //MarkupHelper is used to display the output in different colors
			 test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			 test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			 }else if(result.getStatus() == ITestResult.SKIP){
			 //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			 test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		 }
		}*/
		
		public void onFinish(ITestContext testcontext)
		{
			extent.flush();
		}
	

}
