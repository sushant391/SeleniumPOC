package com.xem.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.MediaEntityBuilder;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	ExtentTest logger;
	
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\sshejwal\\OneDrive - R4 Technologies, LLC\\Desktop\\XEM\\XEM\\src\\main\\java\\com\\xem\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sshejwal\\OneDrive - R4 Technologies, LLC\\Desktop\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sshejwal\\OneDrive - R4 Technologies, LLC\\Desktop\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		htmlReporter = new ExtentHtmlReporter("TestExecution.html");
	    
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	public void testLog() throws Exception
	{
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
       // test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("extent3screenshot.png").build());
       // test.addScreenCaptureFromPath("extent3screenshot.png");
        

	}
	
	public void tearDown()
	{
        extent.flush();
        driver.close();

	}
	
    
	
}
