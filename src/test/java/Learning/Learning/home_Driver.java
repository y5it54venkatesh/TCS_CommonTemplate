package Learning.Learning;



import reusableComponent.reusablemethods;
import subPages.subPages;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class home_Driver {
	
	
	reusablemethods objresuable=new reusablemethods();
	subPages subObj=new subPages();
	
	@SuppressWarnings("static-access")
	@BeforeTest
	@Parameters({"browserName","OperatingSystem"})
	public void beforeTest(String browserName, String OperatingSystem ) {
			objresuable.browserSetup(browserName, OperatingSystem);
	  }
	
	
	@SuppressWarnings("static-access")
	@Test(dataProvider = "dp")  
	public void setUp(String TestCaseNum, String UserData, String Userpassword) throws IOException, InterruptedException {
	
		objresuable.Setrow(TestCaseNum);
		
		if(UserData.equalsIgnoreCase("YES")){
			System.out.println(UserData);
			Reporter.log("New Test case Execution started:- Test case number: "+TestCaseNum);	
			objresuable.launchBrowser();
			//objresuable.screenshots();	
			//subObj.googleSearch();
			//subObj.registration();
			subObj.subScribe();
			
		}			 
	}
  
	@SuppressWarnings("static-access")
	@AfterMethod
	public void afterMethod(ITestResult status) throws IOException {
	  if (status.getStatus()==ITestResult.FAILURE){
		  objresuable.reportCreation("Failed the test case");		  
		//  objresuable.screenshots();
		  objresuable.closeBrowser(); 		  
	  }	  
	  
	 
	  
	  
	}


	@DataProvider
	public Object[][] dp() throws IOException {
		
		Object[][] arrayReturn= objresuable.getExcelsheet();				
		return arrayReturn;		
	}
  

	@AfterTest
	public void afterTest() {
		objresuable.closeBrowser(); 	
	  
	}


	@SuppressWarnings("static-access")
	@AfterSuite
	public void afterSuite() throws IOException {     
		System.out.println("Closed");
		objresuable.driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		objresuable.reportCreation();
	}
}
