package vTigerOrganizationTestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtlities.CreateNewOrganizationPage;
import vTiger.GenericUtlities.ExcelFileUtility;
import vTiger.GenericUtlities.JavaUtility;
import vTiger.GenericUtlities.PropertyFileUtility;
import vTiger.GenericUtlities.WebDriverUtility;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateMultipleOrganizations 
{
		//Step1: Create object of all the required libraries
			PropertyFileUtility pUtil = new PropertyFileUtility();
			JavaUtility jUtil = new JavaUtility();
			WebDriverUtility wUtil = new WebDriverUtility();
			ExcelFileUtility eUtil = new ExcelFileUtility();
	
	@Test(dataProvider = "OrgName")
	public void createMultipleOrgTest(String ORG, String INDUSTRY) throws IOException
	{
		String ORGNAME = ORG+jUtil.getrandomNumber();
		
		//Step2:  Read all the required data
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			String USERNAME = pUtil.readDataFromPropertyFile("usename");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
		//Step 3: Launch the browser
			WebDriver driver =null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();	
			}
			else if (BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("Invalid browser name");
			}
			
			wUtil.maximizeWindow(driver);
			wUtil.waitForPageLoad(driver);
			driver.get(URL);
			
		//Step4: Login to application
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
		//Step5: Click on Organization link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();
			
		//Step6: Click on create Organization lookup image
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrgLookUpImg();
		
		//Step7: Create Organization with mandatory fieds with industry and save
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME, INDUSTRY);
		
		//Step8: Validation
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String OrgHeader = oip.getOrganizationHeader();
			if(OrgHeader.contains(ORGNAME))
			{
				System.out.println(OrgHeader+" ====> PASS");
			}
			else
			{
				System.out.println(" Fail ");
			}
			
		//Step9: Logout of application
			hp.logOutOfApp(driver);
			
	}
	
	@DataProvider(name = "OrgName")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.readMultipleData("MultipleData");
		return data;
	}
}
