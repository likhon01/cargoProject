package com.mlba.ebayDemo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mlba.gmailDemo.LandingPage;
import com.mlba.utils.Utils;

public class PLPEbay
{
	WebDriver driver;
	
	public PLPEbay(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Utils	util;
	Logger	log	= Logger.getLogger(PLPEbay.class);
	
	@FindBy(xpath = ".//*[@id='item3f6aaa1276']/ul[1]/li[1]/span")
	WebElement	productPrice;
	
	public void firstProduct()
	{
		util = new Utils(driver);
		String value = util.handleElement(productPrice).getText();
		String number=value.replace("$", "");
		log.info(number);
		double price=Double.parseDouble(number);
		log.info("The price of this product is $"+price);
		
		
	}
}
