package seleniumWDproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Login {
	@Test

	public void testgooglepage() 
	{
		//System.setProperty("webdriver.ie.driver","C:\\IEDriverServer\\IEDriverServer.exe");
	            WebDriver driver=DriverUtility.getDriver("chrome");
				driver.manage().window().maximize();
				driver.get("http://www.google.co.in");
	            String title=driver.getTitle();
	            Assert.assertEquals(title,"Google");
	           
	}

}