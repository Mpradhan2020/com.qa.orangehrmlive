package com.qa.orangehrmliveTestscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class TestBase {
//pre-requesites recorded here
//	
	
//	1. initializing & initiating the browse
//	2. open the url
//	3. maximize the window
//	4. page load timeout
//	5. delete cookies
	
	public static WebDriver Driver;
	public static FileInputStream fileLoc;
	public static Properties prop;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) {
		
		try {
			fileLoc = new FileInputStream("C:\\Users\\pradhanm\\eclipse-workspace\\com.qa.orangehrmlive\\configuration\\config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	   
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Murali\\Java-Learn\\Selenium\\Browser_driver\\chromedriver.exe");
			Driver=new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Murali\\Java-Learn\\Selenium\\Browser_driver\\geckodriver.exe");
			Driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Murali\\Java-Learn\\Selenium\\Browser_driver\\IEDriverServer.exe");
			Driver = new InternetExplorerDriver();
		} 
		
		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.get(prop.getProperty("url"));
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
	}
	
	@AfterClass
	public void tearDown() {
		Driver.quit();
	}
	
	

	public void captureScreenshot(WebDriver Driver, String tname) throws IOException {
		
		
//		TakesScreenshot ts = (TakesScreenshot) Driver;
//		File Src= ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");
//		FileUtils.copyFile(Src, dest);
//		System.out.println("Screen shot captured");
		
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String dest = System.getProperty("user.dir")+"/Screenshots/";
		
		String nameScreenshot =tname.concat("_").concat(timeStamp);
		System.out.println("Screenshot location is : " + dest);
		
		
		
		Shutterbug.shootPage(Driver).withName(nameScreenshot).save(dest);
		
		
		
	}
}
