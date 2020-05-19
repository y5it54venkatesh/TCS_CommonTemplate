package Feature;

import Feature.OpenMRSTests;
import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 

public class LoginPage  
{
	@Given("^Open Application and Enter URL$")
	public void open_Application_and_Enter_url() throws Throwable {
	  OpenMRSTests.driver.get("https://demo.openmrs.org/openmrs/login.htm");
	  
	}

	@When("^enter name$")
	public void enter_username() throws Throwable {
		OpenMRSTests.driver.findElement(By.id("username")).sendKeys("Admin");
	}

	@When("^enter password$")
	public void enter_password() throws Throwable {
		OpenMRSTests.driver.findElement(By.id("password")).sendKeys("Admin123");
		OpenMRSTests.driver.findElement(By.id("Inpatient Ward")).click();
		OpenMRSTests.driver.findElement(By.id("loginButton")).click();
	}

	@Then("^verify message$")
	public void verify_Msg() throws Throwable {
	   boolean result =  OpenMRSTests.driver.findElement(By.tagName("h4")).getText().contains("Logged");
	   Assert.assertTrue(result);
	}
}