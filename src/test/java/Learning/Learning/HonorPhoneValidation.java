package Learning.Learning;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

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
	
		 
		 capabilities.setCapability("deviceName", "GJN9K17407900914");
		 
		 //capabilities.setCapability("deviceName", "192.168.0.101:5555");
		 		 

		//Set BROWSER_NAME desired capability to Android.
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		//Set android VERSION from device desired capability.
		capabilities.setCapability(CapabilityType.VERSION, "5.1");

		// Set android platformName desired capability to Android.
		capabilities.setCapability("platformName", "Android");
		
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);		
		capabilities.setCapability(MobileCapabilityType.NO_RESET,false);
		
				
		/* - Calculator
		capabilities.setCapability("appPackage", "com.android.calculator2");		
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		*/
		
		/*Youtube
		capabilities.setCapability("appPackage", "com.google.android.youtube");
		capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
		 */
		

		capabilities.setCapability("appPackage", "com.facebook.mlite");
		capabilities.setCapability("appActivity", "com.facebook.mlite.coreui.view.MainActivity");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(20000);
		
		
		
		
		//Facebook
		driver.findElement(By.xpath(".//*[contains(@content-desc,'Email or phone number')]")).sendKeys("mutyala.ramanamma@gmail.com");		
		Thread.sleep(6000);		
		driver.findElement(By.xpath(".//*[contains(@content-desc,'Password')]")).sendKeys("8939477600");		
		Thread.sleep(6000);		
		driver.findElement(By.id("com.facebook.mlite:id/login_login_button")).click();		
		Thread.sleep(10000);		
		driver.findElement(By.xpath(".//*[@text='Not Now']")).click();
		Thread.sleep(6000);		
		driver.findElement(By.xpath(".//*[@content-desc='PrashantiVenkatesh Muthyala']")).click();		
		Thread.sleep(6000);
		//driver.findElement(By.id("com.whatsapp:id/verify_sms_code_input")).sendKeys("");
		
		
		for(int i=0;i<100;i++) {
			
		Thread.sleep(5000);
		
		try {
		
			if(driver.findElement(By.xpath(".//*[@text='Active Now']]")).isEnabled()){
				if(driver.findElement(By.xpath(".//*[@text='Active Now']]")).isDisplayed()){
					System.out.println("Displayed now");
				}
			}
		}
		catch(Exception ex) {
			System.out.println("no element found Small exception");
		}
		
		
		}
		
		
		/*
		watsapp
		driver.findElement(By.id("com.whatsapp:id/eula_accept")).click();		
		Thread.sleep(6000);		
		driver.findElement(By.id("com.whatsapp:id/registration_cc")).sendKeys("91");		
		Thread.sleep(6000);		
		driver.findElement(By.id("com.whatsapp:id/registration_phone")).sendKeys("9553155727");		
		Thread.sleep(6000);		
		driver.findElement(By.id("com.whatsapp:id/registration_submit")).click();
		Thread.sleep(6000);		
		driver.findElement(By.id("android:id/button1")).click();		
		Thread.sleep(6000);
		//driver.findElement(By.id("com.whatsapp:id/verify_sms_code_input")).sendKeys("");
		*/
		
		
		/* Youtube
		capabilities.setCapability("appPackage", "com.google.android.youtube");
		capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");
		*/
		driver.findElement(By.id("com.google.android.youtube:id/menu_item_1")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("com.google.android.youtube:id/search_edit_text")).sendKeys("Venkatesh");
		Thread.sleep(6000);
		//((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(6000);
		driver.findElement(By.id("com.google.android.youtube:id/left_thumbnail")).click();
		Thread.sleep(6000);
		
		
		Thread.sleep(20000);		
		
		driver.quit();
		

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
