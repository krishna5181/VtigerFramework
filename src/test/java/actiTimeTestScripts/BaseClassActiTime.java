package actiTimeTestScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassActiTime 
{
	public PropertyFile pUtil = new PropertyFile();
	public ExcelFileUtil eUtil = new ExcelFileUtil();
	public WebDriver driver=null;
	
	@BeforeClass
	public void LanchBrowser() throws IOException
	{	
		String Browser = pUtil.readDataFromPropertyFile("browser");
		String Url = pUtil.readDataFromPropertyFile("url");
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);
		driver.manage().window().maximize();
	}
		
	@BeforeMethod
	public void loginToApp() throws IOException
	{
	
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		ActiTimeElements act = new ActiTimeElements(driver);
		act.loginApp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod
	public void logOutApp() throws InterruptedException
	{
		ActiTimeElements act = new ActiTimeElements(driver);
		Thread.sleep(2000);
		act.logoutApp();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		
	}

}
