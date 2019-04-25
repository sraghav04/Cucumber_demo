package skeleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RegisterPage;
import seleniumWDproject.DriverUtility;

public class RegisterStepDefs {
	WebDriver driver;
	@Before
	public void init()
	{

		driver=DriverUtility.getDriver("chrome");
		PageFactory.initElements(driver, RegisterPage.class);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Given("url of the demowebshop")
	public void url_of_the_demowebshop() {
	    driver.get("http://demowebshop.tricentis.com/register");
	}

	@When("user enters the data for registration")
	public void user_enters_the_data_for_registration() {
		
	   RegisterPage.gender.click();
	   RegisterPage.firstname.sendKeys("saurav");
	   RegisterPage.lastname.sendKeys("raghav");
	   RegisterPage.email.sendKeys("askmail04@test.com");
	   RegisterPage.password.sendKeys("abc123");
	   RegisterPage.confirmpassword.sendKeys("abc123");
	   RegisterPage.registerbutton.click();
	}

	@Then("user is registered successfully")
	public void user_is_registered_successfully() {
		
	}


}

