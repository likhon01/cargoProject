package com.mlba.ui.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.mlba.utils.Utils;

public class BaseTest
{
	public WebDriver driver;

	@BeforeMethod
	public void start() throws IOException
	{
		Logger log = Logger.getLogger(BaseTest.class);
		DOMConfigurator.configure("log4j.xml");
		FileInputStream f = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(f);
		if (prop.getProperty("browser").equals("firefox"))
		{
			log.info("Browser initializing");
			System.setProperty("webdriver.gecko.driver",
					"./driver/geckodriver");
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else if (prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.gecko.driver",
					"./driver/chromedriver");
			driver = new ChromeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void close(ITestResult result) throws IOException
	{
		if (result.getStatus() == result.FAILURE)
		{
			Utils util = new Utils(driver);
			util.screenShot();
		}
		driver.quit();
	}
}
