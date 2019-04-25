package skeleton;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AddNewProduct.AddNewProduct;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RegisterPage;
import seleniumWDproject.DriverUtility;

public class LoginTestmeStepDefs {
	WebDriver driver;
	@Before
	public void init()
	{

		driver=DriverUtility.getDriver("chrome");
		PageFactory.initElements(driver, AddNewProduct.class);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	}
	@Given("The URL of Testme APP")
	public void the_URL_of_Testme_APP() 
	{
		   AddNewProduct.userName.sendKeys("admin");
		   AddNewProduct.password.sendKeys("Password456");
		   AddNewProduct.Login.click();
	 
	}
	@When("user enters {word} as username")
	public void user_enters_as_username(String string) {
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
	
}
	@When("user enters {word} as password")
	public void user_enters_as_password(String string) {
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
	}
	@Then("user is in (Home|Admin Home)")
	public void user_is_in_home_page() {
		Assert.assertTrue(driver.getTitle().contains("Home"));
}
	@When("user enters the data for registration")
	public void user_enters_the_data_for_registration() {
		
	   
	  
	   AddNewProduct.email.sendKeys("askmail04@test.com");
	   AddNewProduct.password.sendKeys("abc123");
	   AddNewProduct.confirmpassword.sendKeys("abc123");
	   AddNewProduct.registerbutton.click();
	}
}