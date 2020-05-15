package Learning.Learning;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HonorPhoneValidation {
	
	WebDriver driver;
	
	@SuppressWarnings("rawtypes")
	@BeforeTest	
	public void beforeTest() throws MalformedURLException, InterruptedException {
	
	
	//	File app = new File("C:\\Users\\Venkatesh\\Git\\Learning\\AndroidApp", "Contacts.apk");
		  
		 //To create an object of Desired Capabilities
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		//OS Name
	
		 
		 capabilities.setCapability("deviceName", "192.168.0.101:5555");

		//Set BROWSER_NAME desired capability to Android.
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		//Set android VERSION from device desired capability.
		capabilities.setCapability(CapabilityType.VERSION, "4.4.2");

		// Set android platformName desired capability to Android.
		capabilities.setCapability("platformName", "Android");

		// Set android appPackage desired capability.
		capabilities.setCapability("appPackage", "com.android.calculator2");

		// Set android appActivity desired capability.
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		 
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(6000);
		
		driver.close();
		
		driver.quit();
		
		//driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();

		//driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

		//driver.findElement(By.id("com.android.calculator2:id/digit_8")).click();

		//driver.findElement(By.id("com.android.calculator2:id/eq")).click();

		//String result = driver.findElement(By.className("android.widget.EditText")).getText();

		//System.out.println("Result of Addition is : " + result);
		
		
		 
		 
		}
	
	
	
	
	
	
  @Test
  public void f() {
	/*  
	  WebElement addContactButton = driver.findElement(By.name("Add Contact"));
	  addContactButton.click();
	   //locate input fields and type name and email for a new contact and save it
	   List<WebElement> textFields = driver.findElements(By.className("android.widget.EditText"));
	  textFields.get(0).sendKeys("aaa Test");
	  textFields.get(1).sendKeys("9999999999");
	  textFields.get(2).sendKeys("testemail@domain.com");
	  driver.findElement(By.name("Save")).click();
	  */
  }

 /* @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }*/
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
