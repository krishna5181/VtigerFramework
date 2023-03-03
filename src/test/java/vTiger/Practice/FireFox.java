package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFox 
{
	@Test
	public void launcBrowser()
	{
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxDriver dr = new FirefoxDriver();
		
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		dr.get("https://www.w3schools.com/python/default.asp");
		
		dr.findElement(By.xpath("//a[text()='SQL']")).click();
		dr.findElement(By.partialLinkText("SQL Update")).click();
		dr.findElement(By.xpath("//a[@class='w3-right w3-btn']")).click();
		System.out.println(dr.getCurrentUrl());	
	}
}
