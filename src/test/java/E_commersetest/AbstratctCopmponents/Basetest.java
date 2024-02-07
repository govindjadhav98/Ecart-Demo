package E_commersetest.AbstratctCopmponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.xml.transform.Result;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.internal.ITestResultNotifier;

import com.aventstack.extentreports.model.Test;
import com.google.common.io.Files;

import E_commerse.landing_Page.Landing_page;
import io.qameta.allure.AllureResultsWriter;
import io.qameta.allure.Attachment;

public class Basetest {
	public WebDriver driver;
	public Landing_page lpage;

	public void initializebrowser() throws IOException {
		
		
		Properties prop=new Properties();
		
		 FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\E_commerse_test_resources\\Globaldata.properties");
		prop.load(file);
		
		String Browser_name=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
	
		//String Browser_name = prop.getProperty("browser");
		
		if(Browser_name.equalsIgnoreCase("Chrome")) {
		 driver=new ChromeDriver();
		 
		 
		}
		if(Browser_name.equalsIgnoreCase("Firefox")) {
		 driver=new FirefoxDriver();
			}
		if(Browser_name.equalsIgnoreCase("Edge")) {
			 driver=new EdgeDriver();
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
} public String getscreenshot(String testcasename, WebDriver driver) throws IOException {
	
	TakesScreenshot screensot = ((TakesScreenshot)driver);
	File source = screensot.getScreenshotAs(OutputType.FILE);
File file=new File(System.getProperty("user.dir")+"\\reports\\"+testcasename+".png");

Files.copy(source, file);
return System.getProperty("user.dir")+"//report//"+testcasename+".png";
}
	

	@BeforeMethod (alwaysRun = true)
	public void openpage() throws IOException {
		initializebrowser();
	 lpage=new Landing_page(driver);
	lpage.gotolandingpage();
	
}
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}
	
	}
		

