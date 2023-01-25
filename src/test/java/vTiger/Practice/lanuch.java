package vTiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class lanuch {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
	}

}
