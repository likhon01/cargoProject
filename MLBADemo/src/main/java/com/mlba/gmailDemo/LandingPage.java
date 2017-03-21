package com.mlba.gmailDemo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mlba.ui.test.BaseTest;
import com.mlba.utils.Utils;

public class LandingPage
{
	WebDriver	driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utils	util;
	Logger	log	= Logger.getLogger(LandingPage.class);
	
	@FindBy(xpath = ".//*[@id='Email']")
	WebElement	userName;
	
	@FindBy(xpath = ".//*[@id='next']")
	WebElement	nextButton;
	
	@FindBy(xpath = ".//*[@id='Passwd']")
	WebElement	passwordBox;
	
	@FindBy(xpath = ".//*[@id='signIn']")
	WebElement	signInButton;
	
	public ProfilePage logInCredential() throws InterruptedException
	{
		util = new Utils(driver);
		util.handleElement(userName).sendKeys("MLBADemo@gmail.com");
		log.info("Entered username");
		
		util.handleElement(nextButton).click();
	
		log.info("Clicked on the next button");
		util.waitForElement();
		util.handleElement(passwordBox).sendKeys("MLBADemo8");
		log.info("Entered password");
		
		util.handleElement(signInButton).click();
		log.info("Clicked on sign in button");
		util.waitForElement();
		
		return new ProfilePage(driver);
	}

	public ProfilePage invalidUserloginCredential() throws InterruptedException
	{
		util = new Utils(driver);
		util.handleElement(userName).sendKeys("MLBADemo01@gmail.com");
		util.handleElement(nextButton).click();
		util.waitForElement();
		util.handleElement(passwordBox).sendKeys("MLBADemo8");
		util.handleElement(signInButton).click();
		util.waitForElement();
		return new ProfilePage(driver);
	}

	public ProfilePage invalidPassloginCredential() throws InterruptedException
	{
		util = new Utils(driver);
		util.handleElement(userName).sendKeys("MLBADemo@gmail.com");
		util.handleElement(nextButton).click();
		util.waitForElement();
		util.handleElement(passwordBox).sendKeys("MLBADemo80");
		util.handleElement(signInButton).click();
		util.waitForElement();
		return new ProfilePage(driver);
	}
}
