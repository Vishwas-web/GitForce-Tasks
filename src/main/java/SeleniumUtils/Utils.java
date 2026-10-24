package SeleniumUtils;

import static com.cs.ReadPropertyFile.ReadPropertyFile.prop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.DriverManager.DriverManager;
import com.cs.enums.WaitType;

import reports.ExtentLogger;

public class Utils {

	private static WebElement getWebElement(By by, WaitType waitStrategy, WebDriverWait wait)
	{
		WebElement element;
		
		if (waitStrategy.toString().equalsIgnoreCase("PRESENCE"))
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));	
		else if (waitStrategy.toString().equalsIgnoreCase("CLICKABLE"))
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
		else if (waitStrategy.toString().equalsIgnoreCase("VISIBLE"))
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		else
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));	
	
		
		return element;
	}
	
	private static WebDriverWait waitForElement(By by)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Integer.parseInt(   prop.getProperty("explicitWaitTime"))));
		return wait;
	}
	
	public static void type(By by, String value, WaitType waitStrategy, String elementName)
	{
		WebDriverWait wait = waitForElement(by);

		WebElement element = getWebElement(by, waitStrategy, wait);
		element.sendKeys(value);
		ExtentLogger.pass("'" + value + "'" + " entered successfully in " + elementName);
	}
	
	public static void clickElement(By by,WaitType waitStrategy, String elementName)
	{
		WebDriverWait wait = waitForElement(by);
		
		WebElement element = getWebElement(by, waitStrategy, wait);
		
		element.click();
		ExtentLogger.pass("'" + elementName + "'" + " clicked successfully");
	}
}
