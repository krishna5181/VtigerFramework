package actiTimeTestScripts;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeElements
{
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameEdt;
	
	@FindBy(xpath = "//input[@name='pwd']")
	private WebElement passwordEdt;
	
	@FindBy(xpath = "//div[text()='Login ']")
	private WebElement logginBtn;
	
	@FindBy(xpath = "//div[@id='container_tasks']")
	private WebElement taskLnk;
	
	@FindBy(xpath = "//div[@class='addNewButton']/div[3]")
	private WebElement addNewBtn;
	
	@FindBy(xpath = "//div[@class='item createNewCustomer']")
	private WebElement createNewCustomerLnk;
	
	@FindBy(xpath = "//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement customerNameEdt;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement descrptionEdt;
	
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(id="logoutLink")
	private WebElement logOutLnk;
	
	
//	Declaration
	public ActiTimeElements(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLogginBtn() {
		return logginBtn;
	}

	public WebElement getTaskLnk() {
		return taskLnk;
	}

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public WebElement getCreateNewCustomerLnk() {
		return createNewCustomerLnk;
	}

	public WebElement getCustomerNameEdt() {
		return customerNameEdt;
	}

	public WebElement getDescrptionEdt() {
		return descrptionEdt;
	}

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}

	public WebElement getLogOutLnk() {
		return logOutLnk;
	}



	//	Business Libaray for Create new customer
	/**
	 * This method is used to Login to application
	 * @param username
	 * @param password
	 */
	public void loginApp(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		logginBtn.click();
	}

	/**
	 * This method will create newCustomer
	 * @param CustomerName
	 * @param Description
	 */
	public void createCustomer(String CustomerName, String Description )
	{
		Random ran = new Random();
		int num = ran.nextInt();
		String custname = CustomerName+num;
		taskLnk.click();
		addNewBtn.click();
		createNewCustomerLnk.click();
		customerNameEdt.sendKeys(custname);
		descrptionEdt.sendKeys(Description);
		createCustomerBtn.click();
	}
	
	/**
	 * this method will help to Logout from the appllication
	 */
	public void logoutApp()
	{
		logOutLnk.click();
	}

}
