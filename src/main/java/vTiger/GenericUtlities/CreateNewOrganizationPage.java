package vTiger.GenericUtlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public  CreateNewOrganizationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logic
	/**
	 * This method will create new organization and save
	 * @param OrgName
	 */
	public void createNewOrganization(String OrgName) 
	{
		OrgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	public void createNewOrganization(String OrgName, String industry) 
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(industryDropDown, industry);
		saveBtn.click();
	}

}
