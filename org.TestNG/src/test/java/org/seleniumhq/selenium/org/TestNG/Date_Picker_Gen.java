package org.seleniumhq.selenium.org.TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Date_Picker_Gen {
	static WebDriver driver;

	@Test
	public void Choose_Date() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\1187494\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.expedia.ca/");
		// Check_in
		// Month
		String check_in_month = "Sep 2019";
		String check_in_month_caption = "//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[2]/table/caption";
		String Xpath_Next_Button = "//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/button[2]";
		// Day
		String check_in_table_xpath = "//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[2]/table/tbody/tr/td/button";
		String check_in_date = "18";

		driver.findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']")).click();
		Month_Picker_Method(check_in_month_caption, check_in_month, Xpath_Next_Button);
		date_Picker_Method(check_in_table_xpath, check_in_date);

		// Check_out
		// Month
		String check_out_month = "Sep 2019";
		String check_out_month_caption = "//*[@id=\"hotel-checkout-wrapper-hp-hotel\"]/div/div/div[2]/table/caption";
		String Xpath_Next_Button2 = "//*[@id=\"hotel-checkout-wrapper-hp-hotel\"]/div/div/button[2]";
		// Day
		String check_out_table_xpath = "//*[@id=\"hotel-checkout-wrapper-hp-hotel\"]/div/div/div[2]/table/tbody/tr/td/button";
		String check_out_date = "22";

		driver.findElement(By.xpath("//input[@id='hotel-checkout-hp-hotel']")).click();
		Month_Picker_Method(check_out_month_caption, check_out_month, Xpath_Next_Button2);
		date_Picker_Method(check_out_table_xpath, check_out_date);

		Thread.sleep(6000);
		driver.close();

	}

	public static void Month_Picker_Method(String Xpath_string, String month, String Xpath_Next_String) {
		while (true) {
			String text = driver.findElement(By.xpath(Xpath_string)).getText();
			if (text.equals(month)) {
				System.out.println(text);
				break;
			} else {
				driver.findElement(By.xpath(Xpath_Next_String)).click();
			}

		}

	}

	public static void date_Picker_Method(String xpath_value, String date) {

		List<WebElement> elements = driver.findElements(By.xpath(xpath_value));
		System.out.println("No of dates:"+elements.size());
		for (WebElement ele : elements) {

			String ele_text = ele.getText();
			System.out.println(ele_text);
			String date_fin[] = ele_text.split("\n");

			if (date_fin[1].equals(date)) {
				ele.click();
				break;
			}
		}
	}

}
