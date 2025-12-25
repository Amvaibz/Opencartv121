package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage 
{

	public loginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']") WebElement emailbox;
	@FindBy(xpath = "//input[@id='input-password']") WebElement passwordbox;
	@FindBy(xpath = "//input[@value='Login']") WebElement loginbtn;
	
	public void enterEmail(String email)
	{
		emailbox.sendKeys(email);
	}

	public void enterPassword(String pass)
	{
		passwordbox.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}
}
