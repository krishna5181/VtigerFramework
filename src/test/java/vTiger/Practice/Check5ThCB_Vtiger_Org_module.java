package vTiger.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtlities.BaseClass;
import vTiger.ObjectRepository.HomePage;

public class Check5ThCB_Vtiger_Org_module extends BaseClass
{
	public WebDriver driver;
	@Test
	public void check5thCB()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.partialLinkText("Organizations")).click();
		driver.findElement(By.id("10")).click();

	}
	
	@Test
	public void printAllOrgNames()
	{

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		List<WebElement> org = driver.findElements(By.xpath("//a[@title='Organizations']"));
		for(WebElement name:org)
		{
			System.out.println(name.getText());
		}
	}

}
