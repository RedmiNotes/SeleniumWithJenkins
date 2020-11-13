package com.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;

public class HTMLUnitDriver_Examp {
	public static void main(String[] args) {
		
		WebDriver driver = new HtmlUnitDriver(true);
		
		driver.get("https://www.google.co.in/");
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.manage().window().getSize());
	}
}