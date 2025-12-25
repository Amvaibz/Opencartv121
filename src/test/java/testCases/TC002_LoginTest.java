package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass 
{
	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("******* Starting login test ********");
		
		try 
		{
			//homepage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//loginpage
			loginPage lp = new loginPage(driver);
			lp.enterEmail(prop.getProperty("email"));
			lp.enterPassword(prop.getProperty("password"));
			lp.clickLogin();
			
			//myAccount page
			myAccountPage mac = new myAccountPage(driver);
			boolean result = mac.myAccountPageExists();
			
			//Assert.assertEquals(result, true,"login Failed");
			Assert.assertTrue(result);
		}
		catch (Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("******* Finished login test ********");

		
	}
}
