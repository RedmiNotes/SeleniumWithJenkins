package com.selenium.projectspecify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.selenium.common.One;
import com.selenium.pages.Two;

public class Three {

	public WebDriver driver;

	public WebDriver startbrowser(String s1) {
		switch(s1) {
		case "ch":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Select your browser");
			break;
		}
		driver.get("https://www.google.com/");
		return driver;
	}
	
	@AfterSuite
	public void finish() {
		driver.close();
		driver.quit();
	}
}
