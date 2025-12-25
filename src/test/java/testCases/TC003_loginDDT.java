package testCases;

import java.lang.System.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_loginDDT extends BaseClass
{
	@Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class , groups = "DataDriven")
	public void verifyLoginDDT (String username, String password, String res)
	{
		logger.info("******** starting TC003_loginDDT test********");
		try
		{
			//homepage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//loginpage
			loginPage lp = new loginPage(driver);
			lp.enterEmail(username);
			lp.enterPassword(password);
			lp.clickLogin();
			
			//myAccount page
			myAccountPage mac = new myAccountPage(driver);
			boolean result = mac.myAccountPageExists();
			
			if(res.equalsIgnoreCase("valid"))
			{
				if(result==true)
				{
					Assert.assertTrue(true);
					mac.clickLogout();
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(res.equalsIgnoreCase("invalid"))
			{
				if(result==true)
				{
					mac.clickLogout();
					Assert.assertTrue(false);
					
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
		}
		catch (Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("******** finished TC003_loginDDT test********");
		
	}
}
