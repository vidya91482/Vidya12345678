package genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void maximiseWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
	
	public void minimizeWindow(WebDriver driver)
	
	{
		driver.manage().window().minimize();
	}
	
	public void waitForPageLoad(WebDriver driver, int sec) 
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	public void waitUntilElementToBeVisible(WebDriver driver, int sec, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilEleToBeClickable(WebDriver driver, int sec, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilTogetTitle(WebDriver driver, int sec, String title)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public Actions performActions(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		performActions(driver).dragAndDrop(src, dst).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement element,int x,int y)
	{
		performActions(driver).dragAndDropBy(element, x, y).perform();
	}
	
	public void mouseHover(WebDriver driver,WebElement element)
	{
		performActions(driver).click().perform();
	}
	
	public void doubleclick(WebDriver driver,WebElement element)
	{
		performActions(driver).doubleClick().perform();
	}
	
	public void contextClick(WebDriver driver,WebElement element)
	{
		performActions(driver).contextClick().perform();
	}
	
	public void contexClick(WebDriver driver,WebElement element)
	{
		performActions(driver).contextClick(element).perform();
	}
	
	public void switchToWindow(WebDriver driver,String expWind)
	{
	 Set<String> window = driver.getWindowHandles();
	 Iterator<String>it=window.iterator();
	 while(it.hasNext())
	 {
		 String win=it.next();
		 String currentTitle=driver.switchTo().window(win).getTitle();
		 if(currentTitle.contains(expWind))
		 {
			 break;
		 }
	 }
	}
	
	public Robot robotobj() throws AWTException
	{
		Robot r=new Robot();
		return r;
	}
	
	public void enterKey(WebDriver driver) throws AWTException 
	{
		robotobj().keyPress(KeyEvent.VK_ENTER);
		robotobj().keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement frameEle)
	{
		driver.switchTo().frame(frameEle);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String getAlertText(WebDriver driver)
	{
		String altText = driver.switchTo().alert().getText();
		return altText;
	}
	public void selectByVisibleText(WebDriver driver,WebElement ele,String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public void selectByValue(WebDriver driver,WebElement ele,String value)
	{
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	public void selectByIndex(WebDriver driver,WebElement ele,int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".screenshot/"+screenShotName+".png";
		File dst=new File(path);
		String scrpath=dst.getAbsolutePath();
		FileUtils.copyFile(src, dst);
		return scrpath;
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("Window.scrollBy(0,800)","");
	}
	
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		jse.executeScript("Window.scrollBy(0,"+y+")",element);
	}
	
	public void scrollDownTillBottomOfThePage(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("Window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scollTillElementToBeVisible(WebDriver driver,WebElement element,String expData)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void clickOnElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
	}
	
	public void jseUsingSendKeys(WebDriver driver,WebElement element,String expData)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value=arguments[1]", element,expData);
	}
	
	public void scrollUpTillElementToBeVisible(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Point loc=element.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		jse.executeScript("Window.scrollBy("+x+","+y+")");
	}

	



	

	

}


