package subPages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import reusableComponent.reusablemethods;
import reusableComponent.identifiers;

public class subPages extends reusablemethods {
	
	
	
	
	public static void subScribe() throws IOException, InterruptedException {
		//driver.findElement(By.xpath(".//*[@id='address']")).sendKeys("madhuri1622@gmail.com");		
		//driver.findElement(By.xpath(identifiers.subscribeaddress_txt)).sendKeys("madhuri1622@gmail.com");
		
		enterText(identifiers.subscribeaddress_txt,"madhuri1622@gmail.com");		
		click(identifiers.subscribe_btn);		
		//driver.findElement(By.xpath(".//*[@class='btn btn-primary']")).click();
		
		Thread.sleep(4000);
		alertAccept();
		reportUpdate("Subscribed successfully","Subscribed successfully","Pass");
		
	}
	
	
	public static void googleSearch() throws InterruptedException, IOException{
		
		String Currentrow=Getrow();
		String CurrSearchValue=particularData(Currentrow,"SearchingText");
				
		driver.findElement(By.name("q")).sendKeys(CurrSearchValue);	
		Thread.sleep(2000);		
		Actions obj=new Actions(driver);
		obj.moveToElement(driver.findElement(By.name("btnK")));
		obj.build();
		obj.perform();
		obj.release();		
		
		driver.findElement(By.name("btnK")).click();			
		Thread.sleep(5000);		
		
		WebDriverWait objwait=new WebDriverWait(driver,20);
		objwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='logo']")));
		
		String txtComparisin=driver.findElement(By.xpath(".//*[@id='logo']")).getAttribute("title");

		if(txtComparisin.contains("Go to Google Home")) {
			Reporter.log("Passed with the go to google home");
		}		
	}
}
