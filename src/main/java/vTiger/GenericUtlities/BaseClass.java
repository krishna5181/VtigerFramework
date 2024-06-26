package vTiger.GenericUtlities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This method contains all the basic configuration annotations
 * @author balar
 *
 */
public class BaseClass 
{
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	
	
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("====== DataBase Connection successfull =====");
	}
	
//	@Parameters("browser")  //for CrossBrowser execution, and comment the readDataFromProperty bcz we are not reading the property from property file 
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String Browser*/) throws IOException
	{
		String browser = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(browser+" launch successful");
			sdriver = driver; //This is used for takesScreenShot in listners
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(browser+" launch successful");
			sdriver = driver; //This is used for takesScreenShot in listners
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);	
	}
	
	@BeforeMethod (groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login to application successful");	
	}
	
	@AfterMethod (groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logOutOfApp(driver);
		System.out.println("Logout successful");
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("==== browswer Closed =====");
	}
	
	@AfterSuite (groups = {"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("==== DataBase connection closed =====");
		driver.close();
	}
}
