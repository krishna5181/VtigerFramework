package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.GenericUtlities.IConstantsUtilitity;

public class ReadDataFromProperty 
{
	public static void main(String[] args) throws IOException 
	{
		//Step1: Read the file in java readable format using FileInputStream class
		FileInputStream fis = new FileInputStream(IConstantsUtilitity.PropertyFilePath);
		
		//Step2: Create an object of Properties class from java.util package
		Properties pObj = new Properties();
		
		//Step3: Load the FileInputStream into pObj
		pObj.load(fis);
		
		//step4: Provide the key and read the value
		String URL = pObj.getProperty("url");
		System.out.println(URL);
		
		System.out.println(pObj.getProperty("browser"));
		System.out.println(pObj.getProperty("username"));
		System.out.println(pObj.getProperty("password"));
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(pObj.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(pObj.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		
	}

}
