package skeleton;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import seleniumWDproject.DriverUtility;

public class LoginStepDefs {
      WebDriver driver;
      @Before
      public void before()
      {
    	driver=DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      }
		
      @After
      public void after()
      {
    	  driver.close();
      }
	@Given("The URL of Testme APP")
	public void the_URL_of_Testme_APP() 
	{
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	 
	}

	@When("user enters {word} as username")
	public void user_enters_as_username(String string) {
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@When("user enters {word} as password")
	public void user_enters_as_password(String string) {
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	
	@Then("user is in (Home|Admin Home)")
	public void user_is_in_home_page() {
		Assert.assertTrue(driver.getTitle().contains("Home"));
	   
	}
	@When("user enters invalid data as username")
	public void user_enters_invalid_data_as_username(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> list=dataTable.asLists();
		/*System.out.println(list.get(0).get(0));
		System.out.println(list.get(0).get(1));
		System.out.println(list.get(1).get(0));
		System.out.println(list.get(1).get(1)); 
		System.out.println("*****************");*/
		
		for (List<String> list2:list)
		{
			for ( String s:list2)
			{
			System.out.println(s+"\t"); 
		}
		System.out.println();
		}
	}

	@Then("user is in loginpage")
	public void user_is_in_loginpage(List<String> s) {
		for(String string:s)
		{ System.out.println(string);
		}
		}
}    
	

