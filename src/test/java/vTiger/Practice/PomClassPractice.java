package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class PomClassPractice 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameEdit().sendKeys("admin");
//		lp.getPasswordEdit().sendKeys("admin");
//		lp.getSubmitBtn().click();	
		
		lp.loginToApp("admin", "admin");
		
		HomePage hp = new HomePage(driver);
		hp.getOpportunitiesLnk().click();
		
		driver.navigate().back();
		hp.getProductsLnk().click();
		
		hp.getHomeBtn().click();
		
	
	}
}
