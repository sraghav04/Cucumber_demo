package seleniumWDproject;

import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import freemarker.template.SimpleDate;

public class extentReport {
  WebDriver driver;
  ExtentHtmlReporter htmlreporter;
  ExtentReports reports;
  ExtentTest logger;
}
@BeforeClass
public void beforeClass()
{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
	String path = System.getProperty("user.dir")+"/extent-reports/"+ sdf.format(new Date())+"html";
	htmlreporter=new ExtentHtmlReporter(path);
	reports=new ExtentReports();
	reports.attachReporter(htmlreporter);
	reports.setSystemInfo("username", " raghav");
	reports.setSystemInfo("host", "Localhost");
	htmlreporter.config().setReportName("Test Me App Report");
	htmlreporter.config().setTheme(Theme.DARK);
	}
@Test
public void passTest() {
logger=reports.createTest("passTest");
logger.log(Status.INFO,  "pass is started");
Assert.assertTrue(true);
}
@Test
public void failTest(){
	logger=reports.createTest("failTest");
	logger.log(Status.INFO,  "fail is started");
	Assert.assertTrue(false);	
}

@Test
public void skipTest() {
	logger=reports.createTest("skipTest");
	logger.log(Status.INFO,  "skip is started");
		throw new SkipException("SKIP");
}

@AfterMethod
public void afterMethod(ITestResult result) 
{
	if (result.getStatus()==ITestResult.FAILURE)
	{ logger.log(Status.FAIL,  "The Test is fail")}
	if
	(result.getStatus()==ITestResult.SUCCESS)
	{ logger.log(Status.PASS,  "The Test is pass")}
	if
	(result.getStatus()==ITestResult.SKIP)
	{ logger.log(Status.SKIP,  "The Test is skip")}
	
}

@AfterClass
public void afterclass() {
}
}
}



@AfterClass
public void afterClass()