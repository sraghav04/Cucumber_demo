package seleniumWDproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestMeAppRegister {
	WebDriver Driver;
	ExtentHtmlReporter htmlreporter;
	  ExtentReports reports;
	  ExtentTest logger;
	
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
		Driver=DriverUtility.getDriver("chrome");
		Driver.get("http://10.232.237.143:443/TestMeApp/");
		Driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void testRegister()
	{
		
		Driver.findElement(By.partialLinkText("SignUp")).click();
		Driver.findElement(By.id("userName")).sendKeys("sauravR45");
		Driver.findElement(By.id("err")).click();
		Assert.assertEquals(Driver.findElement(By.id("err")).getText(), " Available");
		logger=reports.createTest("Register");
		logger.log(Status.INFO, "username Available");
		Driver.findElement(By.id("firstName")).sendKeys("saurav");
		Driver.findElement(By.id("lastName")).sendKeys("raghav");
		Driver.findElement(By.id("password")).sendKeys("Password13");
		Driver.findElement(By.id("pass_confirmation")).sendKeys("Password13");
		Driver.findElement(By.cssSelector("input[value='Male']")).click();
		Driver.findElement(By.id("emailAddress")).sendKeys("askme@gmail.com");
		Driver.findElement(By.id("mobileNumber")).sendKeys("7011403828");
		Driver.findElement(By.cssSelector("input[value='Male']")).click();
		Driver.findElement(By.cssSelector("img[src='images/calendar.png']")).click();
		Select month=new Select(Driver.findElement(By.className("ui-datepicker-month")));
		month.selectByVisibleText("Apr");
		Select year=new Select(Driver.findElement(By.className("ui-datepicker-year")));
		year.selectByVisibleText("1995");
		Driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td[7]/a")).click();
		Driver.findElement(By.id("address")).sendKeys("kundalhalli");
		Driver.findElement(By.id("securityQuestion")).click();
		Driver.findElement(By.id("answer")).sendKeys("Gurgaon");
		Driver.findElement(By.name("Submit")).click();
		//Assert.assertEquals(Driver.findElement(By.id("errormsg").getText().contains("User Registered Successfully"));
		//ssert.assertTrue(Driver.findElement(By.xpath("//form[@role='form']/fieldset/div[8]")).getText().contains("User Registered Successfully"));
	}
	
	@Test(priority=2)
    public void TestLogin()
    {
		
		Driver.findElement(By.id("userName")).sendKeys("Lalitha");
		Driver.findElement(By.id("password")).sendKeys("Password123");
		Driver.findElement(By.name("Login")).click();
		//Assert.assertTrue(Driver.getTitle().contains("Home"));
		
    }
	
	@Test(priority=3)
	public void testCart()  throws InterruptedException
	{
		Actions act1=new Actions(Driver);

		act1.moveToElement(Driver.findElement(By.partialLinkText("All Categories"))).perform();
		act1.moveToElement(Driver.findElement(By.partialLinkText("Electronics"))).click().perform();
		//Thread.sleep(3000);
		Driver.findElement(By.partialLinkText("Head Phone")).click();
		//Driver.findElement(By.cssSelector("a[class='btn btn-success btn-product']")).click();
		
		Driver.findElement(By.partialLinkText("Add to cart")).click();
		Driver.findElement(By.partialLinkText("Cart")).click();
		Driver.findElement(By.partialLinkText("Checkout")).click();
		//act1.moveToElement(Driver.findElement(By.partialLinkText("Proceed to Pay"))).click().perform();
		act1.moveToElement(Driver.findElement(By.cssSelector("input[value='Proceed to Pay']"))).click().perform();
		Thread.sleep(3000);
	}
		
	@Test(priority=4)
	public void testPayment()
	{
		Driver.findElement(By.xpath("//div[@id=\"swit\"]/div[1]/div/label")).click();
		Driver.findElement(By.id("btn")).click();
		Driver.findElement(By.name("username")).sendKeys("123456");
		Driver.findElement(By.name("password")).sendKeys("Pass@456");
		Driver.findElement(By.xpath("//div[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
		Driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		Driver.findElement(By.xpath("//div[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
		Driver.findElement(By.partialLinkText("Home")).click();
		Driver.findElement(By.partialLinkText("SignOut")).click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
		

		
		
		
		
		
		
		
		
		
		
		
		
		

