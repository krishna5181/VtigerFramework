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

public class CreateOrganizationWithIndrstryDropdownWithDDTandGU 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Step1: Create objects for all required libraries
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Step2: Read all the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExelSheet("Organization", 4,2)+jUtil.getrandomNumber();
		String INDUSTRY = eUtil.readDataFromExelSheet("Organization", 4, 3);
		
		//Step3: Launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
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
		
		//step4: Login to application with valid creadentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step5: Click on Oraganization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step6: Click on Organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
		//Step7:Create Organization with mandatory fileds
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step8: click on industry dropdown and select "Chemicals" option
		WebElement element = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(element, "Chemicals");
		
		//Step9: Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step10: Validation
		String IndustryName = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
		if(IndustryName.contains(INDUSTRY))
		{
			System.out.println(IndustryName);
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step11: Logout
		WebElement element1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, element1);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(4000);
		driver.close();	
	}
}
