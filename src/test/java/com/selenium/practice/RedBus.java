package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RedBus {
	public WebDriver driver;

	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launch_edgeBrowser() {
		try {
			WebDriverManager.edgedriver().arch32().setup();
			EdgeOptions option = new EdgeOptions();
			option.setCapability("disable-infobars", true);
			option.setCapability("--disable-notifications", true);
			driver = new EdgeDriver(option);
			wait(2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void edgeBrowserVersion() {
		try {
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = caps.getBrowserName();
			String browserVersion = caps.getVersion();
			System.out.println("The Current Browser Name : " + browserName);
			System.out.println("The Current Edge Browser Version : " + browserVersion);
			wait(2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void navigatetoRedbus() {
		try {
			driver.get("https://www.redbus.in/");
			driver.manage().window().maximize();
			wait(10);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void enterToLocation() {
		try {
			WebElement to_location = driver.findElement(By.xpath("//input[@id='dest']"));
			to_location.sendKeys("Bangalore (All Locations)");
			wait(5);
			new Actions(driver).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
			wait(3);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void enterFromLocation() {
		try {
			String s1 = "Chennai (All Locations)";
			new Actions(driver).sendKeys(s1.toLowerCase()).build().perform();
			wait(2);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			wait(3);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void select_mondayonNextMonth() {
		try {
			driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
			wait(2);
			driver.findElement(By.xpath("//td[@class='next']/button")).click();
			wait(2);
			List<WebElement> sel_date = driver.findElements(By.xpath("//tr/td[contains(@class,'day')][1][not (contains(@class,'empty day'))]"));
			List<String> list = new ArrayList<String>();
			for(WebElement d : sel_date) {
				list.add(d.getText());
			}
			System.out.println("The Monday Dates : " + list);
			System.out.println("The First Monday Date : " + list.get(0));
			wait(3);
			driver.findElement(By.xpath("//tr/td[text()='"+list.get(0)+"']")).click();
			wait(3);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void search_Buses() {
		try {
			driver.findElement(By.id("search_btn")).click();
			wait(5);
			WebElement found_buses = driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
			String s1 = found_buses.getText();
			String s2[] = s1.split(" ");
			int found_bus = Integer.parseInt(s2[0]);
			System.out.println("Total Found Buses : " + found_bus);


			List<WebElement> total_buses = driver.findElements(By.xpath("//div/li[@class='row-sec clearfix']"));
			int tot_bus = total_buses.size();
			System.out.println("Total Count Buses : " + tot_bus);

			if(found_bus==tot_bus) {
				System.out.println("The Total Bus Count is Same.");
			}else {
				System.out.println("The Total Bus Count is Mismatch.");
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		wait(3);
	}
	public WebDriver close_edgeBrowser() {
		try {
			driver.close();
			driver.quit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public static void main(String[] args) {
		try {
			RedBus redbus = new RedBus();
			redbus.launch_edgeBrowser();
			redbus.edgeBrowserVersion();
			redbus.navigatetoRedbus();
			redbus.enterToLocation();
			redbus.enterFromLocation();
			redbus.select_mondayonNextMonth();
			redbus.search_Buses();
			redbus.close_edgeBrowser();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}