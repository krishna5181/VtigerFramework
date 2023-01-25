package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	//Rule1: Create pom class for every webpage
	//Rule2: Class name should be Title of the webpage and ending with page
public class LoginPage 
{
	//Rule3: Identify the webElements by using @FindBy, @FindAll and @FindBys annotations
	@FindBy(name="user_name")
	private WebElement UserNameEdit;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdit;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;
	
	//Rule4: Create a constructor to Intialize the variables/web elements
	public LoginPage(WebDriver driver)  
	{									
		PageFactory.initElements(driver, this);
	}
	
	//Rule5: Provide getters to access all the webelements	
	public WebElement getUserNameEdit() {
		return UserNameEdit;
	}

	public WebElement getPasswordEdit() {
		return PasswordEdit;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//Business Library -Generic methods - for this application
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
public void loginToApp(String USERNAME, String PASSWORD) 
	{
		UserNameEdit.sendKeys("admin");
		PasswordEdit.sendKeys("admin");
		SubmitBtn.click();
	}
}
