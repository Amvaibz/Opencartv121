package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath ="//input[@id='input-firstname']" ) WebElement firstname;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement lastname;
	@FindBy(xpath = "//input[@id='input-email']") WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']") WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement cnfmpassword;
	
	@FindBy(xpath = "//input[@name='agree']") WebElement agreebtn;
	@FindBy(xpath = "//input[@value='Continue']") WebElement continuebtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	
	public void setFistname(String fstname)
	{
		firstname.sendKeys(fstname);
	}
	
	public void setlastname(String lstname)
	{
		lastname.sendKeys(lstname);
	}
	
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setTelephone(String phone)
	{
		telephone.sendKeys(phone);
	}
	
	
	public void setPassword(String psswrd)
	{
		password.sendKeys(psswrd);
	}
	
	public void setconfirmPassword(String psswrd)
	{
		cnfmpassword.sendKeys(psswrd);
	}
	
	public void agreeToggle()
	{
		agreebtn.click();
	}
	
	public void continueButtonClick()
	{
		continuebtn.click();
	}
	
	public String getConfirmationMessege()
	{
		try {
			return(msgConfirmation.getText());
		}catch (Exception e) {
			return(e.getMessage());
		}
	}
}
