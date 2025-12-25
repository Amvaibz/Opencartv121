package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	@Test(groups = {"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("******** Starting TC001_AccountRegistrationTest ******");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***clicked on myAccount link***");
			hp.clickRegister();
			logger.info("***clicked on Register link***");
			
			logger.info("***providing customer details***");
			AccountRegistrationPage registration = new AccountRegistrationPage(driver);
			registration.setFistname(randomString());
			registration.setlastname(randomString());
			registration.setEmail(randomString()+"@gmail.com");
			registration.setTelephone(randomNumber());
			
			String passwrd = randomAlphanumeric();
			registration.setPassword(passwrd);
			registration.setconfirmPassword(passwrd);
			
			registration.agreeToggle();
			registration.continueButtonClick();
			
			logger.info("***validating confirmation messege**");
			String confmsg = registration.getConfirmationMessege();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed");
				logger.debug("debug logs");
				Assert.assertTrue(false);
			}
			
		} 
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******** finished TC001_AccountRegistrationTest ******");

	}

}
