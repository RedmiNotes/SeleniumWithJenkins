package com.selenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class One {
	public WebDriver driver;
	public Actions action;
	
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@BeforeTest
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		action = new Actions(driver);
		wait(2);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}