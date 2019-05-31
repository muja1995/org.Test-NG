package org.seleniumhq.selenium.org.TestNG;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns {

	 WebDriver driver;
	@Test
	public  void Drop() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1187494\\Downloads\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		WebElement day= driver.findElement(By.xpath("//select[@id='day']"));
		WebElement mon= driver.findElement(By.xpath("//select[@id='month']"));
		WebElement yr= driver.findElement(By.xpath("//select[@id='year']"));
		
		String dob= "13-Feb-1995";
		String dobArr[]= dob.split("-");
	
		General_Function(day,dobArr[0]);
		General_Function(mon,dobArr[1]);
		General_Function(yr,dobArr[2]);
		
		Select selmon= new Select(mon);
		List <WebElement> months = selmon.getOptions();		 
		System.out.println(months.size());
		int size = months.size();
		
		for(int i=0;i<size;i++) {
			String month= months.get(i).getText();
			System.out.println(month);
		}
		  		
		driver.quit();
		
	}
	
	public static void General_Function(WebElement ele, String value)
	{
		
		Select sel= new Select(ele);
		sel.selectByVisibleText(value);
		
	}

}
