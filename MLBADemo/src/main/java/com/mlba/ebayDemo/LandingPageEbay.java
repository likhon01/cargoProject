package com.mlba.ebayDemo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mlba.gmailDemo.LandingPage;
import com.mlba.gmailDemo.ProfilePage;
import com.mlba.utils.Utils;

public class LandingPageEbay
{
	WebDriver	driver;
	

	public LandingPageEbay(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utils	util;
	Logger	log	= Logger.getLogger(LandingPageEbay.class);
	
	@FindBy(xpath = ".//*[@id='gh-ac']")
	WebElement	searchBox;
	
	@FindBy(xpath = ".//*[@id='gh-btn']")
	WebElement	searchButton;

	public PLPEbay searchProduct() throws InterruptedException
	{
		util = new Utils(driver);
		
		util.handleElement(searchBox).sendKeys("Electric Guitar");
		log.info("Entered electric guitar on the Search box");
		
		util.handleElement(searchButton).click();
		log.info("Clicked on the search button");
		Thread.sleep(5000);
	
		return new PLPEbay(driver);
	}
}
