package vTigerOrganizationTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtlities.ExcelFileUtility;
import vTiger.GenericUtlities.JavaUtility;
import vTiger.GenericUtlities.PropertyFileUtility;
import vTiger.GenericUtlities.WebDriverUtility;

public class CreateOrganizationWithDDTandGU 
{
	public static void main(String[] args) throws IOException 
	{
	//Step1: Create object of all the required libraries
		PropertyFileUtility pUtil = new PropertyFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		
	//Step2: Read all the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExelSheet("Organization", 1, 2)+jUtil.getrandomNumber();
		
	//Step3: Launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalild browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
	//Step4: Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//Step5: Click on Oraganization link
		driver.findElement(By.linkText("Organizations")).click();
		
	//Step6: Click on Organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
	//Step7:Create Organization with mandatory fileds
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
	//Step8: Save the Organization
		driver.findElement(By.name("button")).click();
		
	//Step9: Validation
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("TonyStarks"))
		{
			System.out.println(orgHeader);
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
	//Step10: Logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
