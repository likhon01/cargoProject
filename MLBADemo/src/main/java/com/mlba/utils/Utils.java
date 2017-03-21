package com.mlba.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.mlba.gmailDemo.LandingPage;

public class Utils
{
	WebDriver driver;
	
	public Utils(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		log.info("Elements initialized");
	}
	Logger	log	= Logger.getLogger(Utils.class);
	
	public WebElement handleElement(WebElement ele)
	{
		log.info(ele + " is initialized");
		return ele;
	}
	
	public void waitForElement() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	
	public void screenShot() throws IOException
	{
		   File sf=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(sf, new File("./image/shot"+Math.random()*1000+".png"),true);
	        log.info("Took screen shot");
	}
	
}
