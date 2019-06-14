package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("url is opened");
		Thread.sleep(1000);
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user is provided");
		lp.setPassword(password);
		logger.info("pwd is provided");

		
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("login is passed");

		}
		else
		{	
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login is failed");
			
			
		}
	}
	
}
 