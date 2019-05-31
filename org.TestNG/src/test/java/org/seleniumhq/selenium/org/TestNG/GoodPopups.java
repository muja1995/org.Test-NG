package org.seleniumhq.selenium.org.TestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoodPopups {
  WebDriver driver;
	@Test
  public void Handle_PopUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1187494\\Downloads\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://popuptest.com/goodpopups.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Good PopUp #2")).click();
		
		Set <String> windows= driver.getWindowHandles();
		Iterator <String> ite = windows.iterator();
		String parent= ite.next();
		System.out.println("Parent ID is "+parent);
		String child= ite.next();
		System.out.println("Child ID is "+child);
		
		driver.switchTo().window(child);
		Thread.sleep(4000);
		System.out.println("Child Title:"+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parent);
		Thread.sleep(4000);
		System.out.println("Parent Title:"+driver.getTitle());
		
		driver.close();
		
  }
}
