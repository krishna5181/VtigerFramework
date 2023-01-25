package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest 
{
	public static void main(String[] args) 
	{
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		WebElement e1 = driver.findElement(By.name("user_password"));
		e1.sendKeys("admin");
		e1.submit();
		
		//Click on Organization link 
		driver.findElement(By.linkText("Organizations")).click();
		
		//Click on Organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Create Organization with mandatory fileds
		driver.findElement(By.name("accountname")).sendKeys("TonyStarks");
		
		//Save the Organization
		driver.findElement(By.name("button")).click();
		
		//Validation
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains("TonyStarks"))
		{
			System.out.println(OrgHeader);
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
