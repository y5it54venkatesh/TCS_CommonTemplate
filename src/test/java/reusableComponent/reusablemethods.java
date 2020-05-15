package reusableComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class reusablemethods {

	static public WebDriver driver=null;
	@SuppressWarnings("rawtypes")
	public static Hashtable<String, String> objhash=new Hashtable<String, String>();
	public static String curreRow;
	public static String currentReport_Path;
	
	
	
	public void SetCurrentPath(String path) {
		this.currentReport_Path=path;	
		
	}
	
	public static String GetReportPath() {
		String returnvalue=currentReport_Path;
		return 	returnvalue;
	}
	
	
	
	
	public void Setrow(String row) {
		this.curreRow=row;	
	}
	
	public static String Getrow() {
		String returnvalue=curreRow;
		return 	returnvalue;
	}
	
	public static void browserSetup(String browserName, String operatingSystem) {
		
		  DesiredCapabilities objDesc=new DesiredCapabilities();
		  objDesc.setCapability(CapabilityType.BROWSER_NAME,browserName);
		  objDesc.setCapability(CapabilityType.VERSION,"80.0");
		  objDesc.setCapability(CapabilityType.PLATFORM,operatingSystem);
		  objDesc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		  
		  try {
			driver=new RemoteWebDriver(new URL("https://mailapallivenkatesh01:5e0d51c1-989c-48a3-9abe-a7857a59b20a@ondemand.saucelabs.com:443/wd/hub"),objDesc);
		  } catch (MalformedURLException e) {
			  // TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  
	}
	
	public static void alertAccept() {		
		driver.switchTo().alert().accept();		
		
	}
	
	public static void launchBrowser() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Properties prop = new Properties();
		FileInputStream fso=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testApplication.properties")); 
		prop.load(fso);
		String appUrl=prop.getProperty("applicationURL");
		
		
		driver.navigate().to(appUrl);
		reportCreation("BrowserLaunched");
		
	}
	
	@SuppressWarnings("deprecation")
	public static void screenshots() throws IOException {
		/*
		
		File obj=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date dateobj=new Date();
		int Hour=dateobj.getHours();
		int minute=dateobj.getMinutes();
		int Second=dateobj.getSeconds();
		String currDire=System.getProperty("user.dir")+"\\Screenshots\\"+Hour+"_"+minute+"_"+Second+".png";		
		System.out.println(currDire);
		FileUtils.copyFile(obj, new File(currDire));
		*/
	
	}
	
	public void closeBrowser() {
		driver.close();		
	}
	
	public static void reportCreation(String message) {
		Reporter.log(message);
		System.out.println(message);
	}
	
	@SuppressWarnings("resource")
	public String[][] getExcelsheet() throws IOException {
		String curredrive=System.getProperty("user.dir")+"\\TestData\\TestData.xls";
		
		HSSFWorkbook wkrbul=null;
		HSSFSheet wrksheet=null;
		
		FileInputStream fso=new FileInputStream(new File(curredrive));
		wkrbul=new HSSFWorkbook(fso);
		
		wrksheet=wkrbul.getSheet("Sheet1");		
		int maxrows=wrksheet.getLastRowNum();		
		int maxCols=wrksheet.getRow(1).getLastCellNum();
		
		
		String[][] arrayData=new String[maxrows][maxCols];
		
		for(int i=1;i<=maxrows;i++) {
			for(int j=0;j<maxCols;j++) {				
					arrayData[i-1][j]=wrksheet.getRow(i).getCell(j).toString();
					//System.out.println(arrayData[i-1][j]);
			}
		}		
		return arrayData;		
	}
	
	
	@SuppressWarnings("resource")
	public static String particularData(String currentrow,String Columnname) throws IOException {
		
		String curredrive=System.getProperty("user.dir")+"\\TestData\\TestData.xls";
		
		HSSFWorkbook wkrbul=null;
		HSSFSheet wrksheet=null;
		
		FileInputStream fso=new FileInputStream(new File(curredrive));
		wkrbul=new HSSFWorkbook(fso);		
		wrksheet=wkrbul.getSheet("Sheet2");	
		
		int maxCols=wrksheet.getRow(0).getLastCellNum();
		for(int i=0;i<maxCols;i++) {
			objhash.put(wrksheet.getRow(0).getCell(i).getStringCellValue(),String.valueOf(i));
		}

		int columnnUM=Integer.parseInt(objhash.get(Columnname));	
		
		String testData=wrksheet.getRow(Integer.parseInt(currentrow)).getCell(columnnUM).getStringCellValue();
		objhash.clear();
		return testData;		
		
	}
	
@SuppressWarnings("resource")
public void reportCreation() throws IOException {
		Date obj=new Date();		
	
		String curredrive=System.getProperty("user.dir")+"\\Reports\\Report_"+obj.getHours()+"_"+obj.getMinutes()+"_"+obj.getSeconds();
		SetCurrentPath(curredrive);
		HSSFWorkbook wkrbul=null;
		HSSFSheet wrksheet=null;
		
		wkrbul=new HSSFWorkbook();
		wrksheet=wkrbul.createSheet("Sheet1");
		
		Row rowNum=wrksheet.createRow(0);		
		
			Cell cellNum_1=rowNum.createCell(0);	
				cellNum_1.setCellValue("Test Case Number");
			Cell cellNum_2=rowNum.createCell(1);
				cellNum_2.setCellValue("Actual Value");
			Cell cellNum_3=rowNum.createCell(2);
				cellNum_3.setCellValue("Expected Value");
			Cell cellNum_4=rowNum.createCell(3);
				cellNum_4.setCellValue("Status");
		
				FileOutputStream fso=new FileOutputStream(new File(curredrive+".xls"));
				wkrbul.write(fso);
				fso.close();
		
	}

@SuppressWarnings({ "deprecation", "resource" })
public static void reportUpdate(String ActualVal, String ExpecetedValue, String Result) throws IOException {
	
	String reportPath=GetReportPath();
	
	HSSFWorkbook workbuk=null;
	HSSFSheet worksheet=null;
	
	FileInputStream fso=new FileInputStream(new File(reportPath+".xls"));
	workbuk=new HSSFWorkbook(fso);
	worksheet=workbuk.getSheet("Sheet1");	
	int lastRow=worksheet.getLastRowNum();
	
	Row newrow=worksheet.createRow(lastRow+1);
	Cell newCell_0=newrow.createCell(0);
	newCell_0.setCellValue(reusablemethods.Getrow());
	
	Cell newCell_1=newrow.createCell(1);
	newCell_1.setCellValue(ActualVal);
	
	Cell newCell_2=newrow.createCell(2);
	newCell_2.setCellValue(ExpecetedValue);
	
	Cell newCell_3=newrow.createCell(3);
	newCell_3.setCellValue(Result);
		
	FileOutputStream fso_Output=new FileOutputStream(new File(reportPath+".xls"));
	workbuk.write(fso_Output);
	fso_Output.close();
	
}

public static void click(String Xpath) throws IOException {	
	
	try {
		if (driver.findElement(By.xpath(Xpath)).isEnabled()){
			driver.findElement(By.xpath(Xpath)).click();		
		}		
	}
	catch(Exception ex) {
		ex.getMessage();
		reportUpdate("Looking for element to be visible and click","element is not visible","Fail");		
	}
	
}



public static void enterText(String Xpath,String input) throws IOException {	
	
	try {
		if (driver.findElement(By.xpath(Xpath)).isEnabled()){
			driver.findElement(By.xpath(Xpath)).sendKeys(input);		
		}		
	}
	catch(Exception ex) {
		ex.getMessage();
		reportUpdate("Looking for element to be visible and click","element is not visible","Fail");		
	}
	
}



}

