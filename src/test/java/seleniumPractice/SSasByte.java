package seleniumPractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSasByte 
{
	@Test(priority = 1)
	public void chromeSS() throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com/");
		
		byte[] byteArraySS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		File destSS = new File(System.getProperty("user.dir")+"\\Screenshots\\youtubeSS1.png");
		FileOutputStream fos = new FileOutputStream(destSS);
		fos.write(byteArraySS);
		System.out.println("Screen shot taken successfully");
		driver.close();
	}
	
	@Test(priority = 2)
	public void TakeSS() throws IOException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver dr = new FirefoxDriver();
		
		dr.manage().window().maximize();
		dr.get("https://testng.org/doc/");
		
//		File screenShotFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
//		File src = new File(System.getProperty("user.dir"+"\\Screenshots\\TestNGss.jpeg"));
//		FileOutputStream fos = new FileOutputStream(src);
//		fos.write(screenShotFile);
		
		TakesScreenshot ts = (TakesScreenshot) dr;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+"SSname"+".png");
		FileUtils.copyFile(src, dst);
		
		dr.close();
		
		
		
		
	}

}
