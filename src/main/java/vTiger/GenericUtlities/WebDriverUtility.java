package vTiger.GenericUtlities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of all generic methods realted to webdriver actions
 * @author balar
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) 
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for 20 seconds for all elements to get loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait until a particular element becomes visible
	 * @param driver
	 * @param element
	 */
	public void waitForPageLoad(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait until a particular element becomes clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickabe(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle the Dropdown by using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) 
	{
		Select s = new Select(element);
		s.selectByIndex(index);	
	}
	
	/**
	 * This method will handle the Dropdown by using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) 
	{
		Select s = new Select(element);
		s.selectByValue(value);	
	}
	
	/**
	 * This method will handle the Dropdown by using visibleText
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element) 
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse Hover actions on specifeid element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform Right-click anywhere on page
	 * @param driver
	 */
	public void doubleClickAction( WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();;
	}
	
	/**
	 * This method will perform Right-click on specific element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform dragAndDraop action from source and destination
	 * @param driver
	 * @param srcElement
	 * @param destElement
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement destElement) 
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, destElement).perform();
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver, int frameIndex) 
	{
		driver.switchTo().frame(frameIndex);
		
	}
	
	/**
	 * This method will switch to frame based on frameName or FrameID
	 * @param driver
	 * @param frameIDorName
	 */
	public void switchToFrame(WebDriver driver, String frameIDorName) 
	{
		driver.switchTo().frame(frameIDorName);
	}
	
	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver, WebElement frameElement) 
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will Switch back to immidiate parent frame
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver) 
	{
		driver.switchTo().parentFrame();	
	}
	
	/**
	 * This method will switch back to default frame
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver) 
	{
		driver.switchTo().defaultContent();	
	}
	
	/**
	 * This method will accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();	
	}
	/**
	 * This method will dismiss alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the text of alert pop up and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlerttext(WebDriver driver) 
	{
		return driver.switchTo().alert().getText();
	}
	
	public void switchToWindow(WebDriver driver, String partialWinTitle) 
	{
		//Step1: capture all the window IDs
		Set<String> winIDs = driver.getWindowHandles();
		
		//Step2: Extract individual window IDs
		for(String winID : winIDs)
		{
			//Step3: capture the current window Title
			String currentTitle = driver.switchTo().window(winID).getTitle();
			
			//Step: compare the current window title with require Title
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take ScreenShot and Store it in a folder
	 * @param driver
	 * @param ScreenShotsName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String ScreenShotsName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShots\\"+ScreenShotsName+".png");
		FileUtils.copyFile(src, dest); //from commons io dependency
		
		return dest.getAbsolutePath(); //for extent reports
	}
	
	/**
	 * This method will scroll downwards randomly
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) 
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * This method will scroll down until specific element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+",)", element);
	}
	
}
