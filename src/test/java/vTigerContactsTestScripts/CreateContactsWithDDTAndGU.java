package vTigerContactsTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtlities.ExcelFileUtility;
//import vTiger.GenericUtlities.JavaUtility;
//import vTiger.GenericUtlities.JavaUtility;
import vTiger.GenericUtlities.PropertyFileUtility;
import vTiger.GenericUtlities.WebDriverUtility;

public class CreateContactsWithDDTAndGU 
{
	public static void main(String[] args) throws IOException 
	{
		//Step1: Create object of all the required libraries
//		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		
		//Step2: Read all the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Step3: Launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		
		//Step4: Launch the browser
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step5: Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 6: Click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
				
		//Step 7: Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
		//Step 8: create Contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(eUtil.readDataFromExelSheet("Contacts", 1, 2));
				
		//Step 9: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Step 10: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(contactHeader.contains("pakeera"))
			{
				System.out.println(contactHeader);
				System.out.println("PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
				
		//Step 11: Logout of Application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
