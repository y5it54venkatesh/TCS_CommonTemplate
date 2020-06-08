package Learning.Learning;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class watsappFromWeb {
WebDriver driver;
	
	
	@BeforeTest	
	public void beforeTest() throws MalformedURLException, InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Driver\\chromedriver.exe");		
		driver=new ChromeDriver();		
		driver.get("https://api.whatsapp.com/send?phone=919885183434&text=&source=&data=&app_absent=");
		
		Thread.sleep(5000);		
		driver.findElement(By.xpath(".//*[@title='Share on WhatsApp']")).click();		
		Thread.sleep(5000);		
		driver.findElement(By.xpath(".//*[text()='use WhatsApp Web']")).click();		
		Thread.sleep(20000);
		 
		}
	
	
  @SuppressWarnings("deprecation")
@Test
  public void f() throws InterruptedException {
	  	  
		
		for(int i=0;i<1000;i++) {			
			for(int j=0;j<50;i++) {				
				driver.findElement(By.xpath(".//*[@data-icon='search-alt']")).click();				
				Thread.sleep(3000);						
			Date obj=new Date();
			
			try {				
				if(driver.findElement(By.xpath(".//*[@title='online']")).isEnabled()){
					if(driver.findElement(By.xpath(".//*[@title='online']")).isDisplayed()){
						System.out.println("Displayed now:-"+obj.getHours()+"_"+obj.getMinutes()+"_"+obj.getSeconds());						
						
					}
				}
			}
			catch(Exception ex) {
				//System.out.println("Not displayed");			
			}
		}
		
	}
		
}
  
  
 @AfterTest
  public void afterTest() {	  
	  driver.quit();
  }

}
