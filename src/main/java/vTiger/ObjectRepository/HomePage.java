package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtlities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declarartion
	@FindBy(className = "tabUnSelected") private WebElement HomeBtn;
	
	@FindBy(linkText = "Calendar")
	private WebElement CalendarLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsLnk;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement DocumentsLnk;
	
	@FindBy(linkText = "Email")
	private WebElement EmailLnk;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTicketsLnk;
	
	@FindBy(linkText = "Dashboard")
	private WebElement DashboardLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministrationImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	
	//Intialization
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCalendarLnk() {
		return CalendarLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getDocumentsLnk() {
		return DocumentsLnk;
	}

	public WebElement getEmailLnk() {
		return EmailLnk;
	}

	public WebElement getTroubleTicketsLnk() {
		return TroubleTicketsLnk;
	}

	public WebElement getDashboardLnk() {
		return DashboardLnk;
	}
	
	public WebElement getHomeBtn() {
		return HomeBtn;
	}

	public WebElement getAdministrationImg() {
		return AdministrationImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Libraries
	/**
	 * This method will click on Organization link
	 */
	public void clickOnOrganizationLink() 
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * This method will click on Contacts Link
	 */
	public void clickOnContactsLink() 
	{
		ContactsLnk.click();	
	}
	
	/**
	 * This method will logout of the application
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver) 
	{
		mouseHoverAction(driver, AdministrationImg);
		SignOutLnk.click();
	}
}
