package seleniumWDproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtility {

	static public WebDriver getDriver(String browser)
	{ 
		if (browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","C:\\IEDriverServer\\IEDriverServer.exe");
		return new InternetExplorerDriver();
		}
		else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\ChromeDriver.exe");
			return new ChromeDriver();
		}

		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else 
		{ return null;
		}
	}

}	


