package vTiger.Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteExecution 
{
	@Test
	public void remoteExecution() throws MalformedURLException
	{
		//Load hub url
		URL url = new URL(" http://192.168.1.57:4444");
		
		//set capabilities for browser
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WINDOWS);
		
		//To launch browser usring remote webdriver
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		
		//Load gmail application
		driver.get("https://www.youtube.com/");
	}

}
