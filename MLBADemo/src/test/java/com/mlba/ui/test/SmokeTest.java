package com.mlba.ui.test;

import java.io.IOException;
import org.testng.annotations.Test;
import com.mlba.ebayDemo.LandingPageEbay;
import com.mlba.ebayDemo.PLPEbay;
import com.mlba.gmailDemo.LandingPage;
import com.mlba.gmailDemo.ProfilePage;

public class SmokeTest extends BaseTest
{
	@Test
	public void gmailLoginTest() throws InterruptedException, IOException
	{
		LandingPage lp = new LandingPage(driver);
		ProfilePage pp = lp.logInCredential();
		Thread.sleep(5000);
		pp.verifyProfileLogo();
	}

	@Test
	public void gmailInvalidUserLoginTest()
			throws InterruptedException, IOException
	{
		LandingPage lp = new LandingPage(driver);
		ProfilePage pp = lp.invalidUserloginCredential();
		Thread.sleep(5000);
		pp.verifyProfileLogo();
	}

	@Test
	public void gmailInvalidPassLoginTest()
			throws InterruptedException, IOException
	{
		LandingPage lp = new LandingPage(driver);
		ProfilePage pp = lp.invalidPassloginCredential();
		Thread.sleep(5000);
		pp.verifyProfileLogo();
	}
	
	@Test
	public void ebayProduct() throws InterruptedException
	{
		LandingPageEbay lpe= new LandingPageEbay(driver);
		PLPEbay plp= lpe.searchProduct();
		
		plp.firstProduct();
		
		
	}
}
