package org.cucumber.tests;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;




@io.cucumber.junit.CucumberOptions(
		features= {"src/test/resources/Feature"},
		glue = {"org.cucumber.stepdefs"},
		strict = true		
		)


@RunWith(Cucumber.class)
public class OpenMRSTests  
{	
	public static WebDriver driver;
	
	@BeforeClass
	public static void browser_Setup() {			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
	}
		
	
}