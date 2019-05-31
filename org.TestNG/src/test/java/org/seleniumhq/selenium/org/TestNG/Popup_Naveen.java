package org.seleniumhq.selenium.org.TestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Popup_Naveen {
  WebDriver driver;
	@Test
  public void ChildWindow() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1187494\\Downloads\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://popuptest.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Come & Go Test")).click();
		Thread.sleep(3000);
		
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> iter = windows.iterator();
		String parent= iter.next();
		System.out.println("Parent is - "+parent);
		
		String child= iter.next();
		driver.switchTo().window(child);
		System.out.println("Child is - "+child);
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		driver.close();
		
		driver.switchTo().window(parent);
		Thread.sleep(4000);
		System.out.println("Parent title is "+driver.getTitle());
	}
	
	@Test
	public void ChildWindow2() throws InterruptedException 
	{
		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/input")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Come & Go Test")));
		
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> iter = windows.iterator();
		String parent= iter.next();
		System.out.println("Parent is "+parent);
		String child= iter.next();
		System.out.println("Second child is - "+child);
		
		driver.switchTo().window(child);
		System.out.println("Child title "+driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		
		driver.switchTo().window(parent);
		System.out.println("Parent title "+driver.getTitle());
		Thread.sleep(3000);
		
		driver.close();
	  
  }
}
