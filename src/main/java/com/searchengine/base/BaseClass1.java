package com.searchengine.base;
//package com.searchengine.base;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.searchengine.utility.Helper;
//import com.searchengine.utility.TestUtil;
//
//public class BaseClass extends TestBase{
//	
//	public WebDriver driver;
//	public TestUtil excel;
//	public TestBase config;
//	public ExtentReports report;
//	public ExtentTest logger;
//	String reportPath;
//	
//	
//	public BaseClass() {
//		super();
//	}
//
//	@BeforeSuite
//	public void setUpSuite() 
//	{
//		
//		Reporter.log("Setting up reports and Test is getting ready", true);
//		
//		excel = new TestUtil();
//		config = new TestBase();
//		
//		reportPath=System.getProperty("user.dir")+"/Reports/SearchEngine_"+ Helper.getCurrentDateTime()+".html";
//		
//		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(reportPath));
//		report=new ExtentReports();
//		report.attachReporter(extent);
//		
//		Reporter.log("Setting Done- Test can be started", true);
//	}
//
//	//@Parameters({"browser","urlToBeTested"})
//	@BeforeClass
//	public void setup() 
//	{
//		
//		Reporter.log("Trying to start Browser and Getting application ready", true);
//		
//		initialize();
//
//		Reporter.log("Browser and Application is up and running", true);
//
//	}
//
//	@AfterClass
//	public void tearDown() {
//		TestBase.quitBrowser();
//	}
//
//	@AfterMethod
//	public void tearDownMethod(ITestResult result) throws IOException 
//	{
//		Reporter.log("Test is about to end ", true);
//
//		
//		if (result.getStatus() == ITestResult.FAILURE) 
//		{
//			logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//		}
//		else if(result.getStatus()==ITestResult.SUCCESS)	
//		{
//			logger.pass("Test passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
//
//		}
//
//		report.flush();
//		
//		Reporter.log("Test Completed >>> Reports Generated", true);
//		
//		Reporter.log("Report can be accessed via >>> "+reportPath,true);
//
//	}
//
//}
