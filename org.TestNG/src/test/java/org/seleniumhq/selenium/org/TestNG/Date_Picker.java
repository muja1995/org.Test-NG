package org.seleniumhq.selenium.org.TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Date_Picker {
	WebDriver driver;
  @Test
  public void Choose_Date() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\1187494\\Downloads\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.expedia.ca/");
	  
	  driver.findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']")).click();
	  
	  String month= "Sep 2019";
	  String day= "17";
	  while(true)
	  {
		 String text= driver.findElement(By.xpath("//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[2]/table/caption")).getText();
		 if(text.equals(month)) {
			 System.out.println(text);
			 break;
		 }
		 else {
			driver.findElement(By.xpath("//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/button[2]")).click(); 
		 }
		
	  }
	  
	List <WebElement> elements= driver.findElements(By.xpath("//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[2]/table/tbody/tr/td/button"));
	
	for(WebElement ele:elements) {
		String ele_text=ele.getText();
		System.out.println(ele_text);
		String date_fin[]= ele_text.split("\n");
		
		if(date_fin[1].equals(day)) {
			ele.click();
			break;
		}
	}
	 
  }
}
