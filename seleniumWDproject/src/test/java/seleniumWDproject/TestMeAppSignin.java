package seleniumWDproject;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestMeAppSignin {
	WebDriver driver;
	 ExtentHtmlReporter htmlreporter;
	  ExtentReports reports;
	  ExtentTest logger;
	@BeforeClass
	public void beforeclass()
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
		driver=DriverUtility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.manage().window().maximize();

	}
	@AfterClass
	public void afterclass() {
		driver.close();

	}
	@Test(dataProvider="dp1")
	public void TestLogin(String username, String password)
	{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Signout")));
		Assert.assertTrue(driver.getTitle().contains("Home"));
		driver.findElement(By.partialLinkText("SignOut")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Signout")));
		driver.findElement(By.partialLinkText("SignIn")).click();
	}
	@DataProvider(name="dp1")
	public Object[][] getdata()
	{
		return ReadDataExcel.testReadExcel("TestMe");
	}
}
