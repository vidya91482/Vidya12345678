package campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampaign {
	 public static WebDriver driver;
		public static void main(String[] args) throws IOException, InterruptedException {
			
			System.out.println("Hello");
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commanData.properties");

			Properties p = new Properties();
			p.load(fis);                                                    
			String Browser = p.getProperty("Browser");
			String Url = p.getProperty("Url");
			String Username = p.getProperty("Username");
			String Password = p.getProperty("Password");
			if (Browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(2000);
			WebElement target = driver.findElement(By.xpath("src=\"themes/softed/images/menuDnArrow.gif\""));                                                 
			Actions a=new Actions(driver);
			a.moveToElement(target).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//option[text()='Campaigns']")).click();	
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();

}
}

