package seleniumPractice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus 
{
	public static void main(String[] args) throws Exception 
	{
		Date d = new Date();
		String dateandtime = d.toString();
		System.out.println(dateandtime);
		//Wed Dec 21 21:22:55 IST 2022  current date format
		//  0   1  2     3      4    5
		String a[] = dateandtime.split(" ");

		String month=a[1];
		String date=a[2];
		String year=a[5];

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		driver.findElement(By.xpath("//text[text()='Date']")).click();
		String monthandyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();

		if(monthandyear.contains(month+" "+year))
		{
			driver.findElement(By.xpath("//td[text()='"+date+"']")).click();
		}
		else
		{
			System.out.println("wrong month");
		}
		System.out.println("date added");
	}

}
