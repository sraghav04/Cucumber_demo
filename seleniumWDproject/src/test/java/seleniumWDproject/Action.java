package seleniumWDproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Action {
@Test
public void Action() 
{
	WebDriver driver=new DriverUtility.getDriver("chrome");
	driver.get("http://10.232.237.143:443/TestMeApp");
	driver.manage().windows().maximize();
	
	Actions act1=new Actions(driver);

	act1.moveToElement(driver.findElement(By.partialLinkText("AboutUs"))).perform();
	act1.moveToElement(driver.findElement(By.partialLinkText("OurOffices"))).perform();
	act1.moveToElement(driver.findElement(By.partialLinkText("Chennai"))).click().perform();
    String home=driver.getWindowHandle();
    Set<String> set=driver.getWindowHandles();
    Assert.assertEquals(set.size(),2);
    System.out.println(set);
    Object[]windows=set.toArray();
    driver.switchTo().windows(windows[1].toString());
    System.out.println("The Title:"+driver.getTitle());
    




}
}
