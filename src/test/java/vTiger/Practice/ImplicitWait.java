package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImplicitWait {
	
	@Test
	public void t1() throws InterruptedException {
		WebDriver dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.manage().window().maximize();
		dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		dr.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		dr.findElement(By.name("password")).sendKeys("admin123");
//		dr.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		dr.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();
		Thread.sleep(10000);
//		dr.close();
		dr.quit();
	}

}
