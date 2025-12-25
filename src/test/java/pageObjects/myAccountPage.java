package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage 
{

	public myAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement MyAccountmsg;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutlnk;
	
	
	//here we are not doing validation we just implementing one method based on that result we can validate in test case
	public boolean myAccountPageExists()
	{
		try 
		{
			return MyAccountmsg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		logoutlnk.click();
	}

}
