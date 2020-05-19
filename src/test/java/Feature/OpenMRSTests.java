package Feature;

import java.net.MalformedURLException;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



@CucumberOptions(
		features="Feature",
		glue={"org.cucumber.stepdefs"},
		format=
				{"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/re-run.txt"}
		)
public class OpenMRSTests  
{
	public static WebDriver driver;
	private TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void setUP()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		testRunner = new TestNGCucumberRunner(this.getClass());
		
	}
	@Test(description="login_Test",dataProvider="getFeatures")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	@DataProvider
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	@AfterClass
	public void tearDown()
	{
		testRunner.finish();
	}
	
	
}