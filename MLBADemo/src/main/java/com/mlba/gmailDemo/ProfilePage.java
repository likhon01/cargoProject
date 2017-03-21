package com.mlba.gmailDemo;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mlba.ui.test.BaseTest;
import com.mlba.utils.Utils;

public class ProfilePage
{
	WebDriver driver;

	public ProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("Elements initialized");
	}

	Utils		util	= new Utils(driver);
	Logger		log		= Logger.getLogger(ProfilePage.class);
	
	@FindBy(xpath = ".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")
	WebElement	profileLogo;

	public void verifyProfileLogo() throws IOException
	{
		if (util.handleElement(profileLogo).isDisplayed())
		{
			log.info("Landed profile page");
		}
		else
			log.error("error");
	}
}
