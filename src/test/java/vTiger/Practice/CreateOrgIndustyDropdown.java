package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgIndustyDropdown {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("fizer");
		
		WebElement dd = driver.findElement(By.name("industry"));dd.click();
		Select se = new Select(dd);
		se.selectByValue("Chemicals");
		
		WebElement dd1 = driver.findElement(By.name("accounttype"));dd1.click();
		Select se1 = new Select(dd1);
		se1.selectByValue("Competitor");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String indName = driver.findElement(By.xpath("//span[@id='dtlview_Industry']")).getText();
		if(indName.contains("Chemicals"))
		{
			System.out.println(indName);
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		String indType = driver.findElement(By.xpath("//div[@id='tblOrganizationInformation']/table/tbody/tr[8]/td[2]/span")).getText();
		if(indType.contains("Competitor"))
		{
			System.out.println("Industry type:"+indType);
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		WebElement logOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(logOut).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
