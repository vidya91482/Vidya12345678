package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cpatcha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoapps.qspiders.com/ui/captcha/imagecaptcha?sublist=1");
        driver.findElement(By.xpath("//input[@placeholder='Enter your name']")).sendKeys("xyz");
        driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("vid");
        String text = driver.findElement(By.xpath("//canvas[@class='border-2 w-40 h-12  bg-orange-500 border-none flex items-center ']")).getText();
        driver.findElement(By.xpath("//input[@placeholder='Enter Captcha']")).sendKeys(text);
	}

}

