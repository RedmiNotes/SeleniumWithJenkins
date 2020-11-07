package com.selenium.testcases;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriver_Examp {
	public static void main(String[] args) {
		
		//.setProperty("", "");
		
		HtmlUnitDriver driver = new HtmlUnitDriver();
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.manage().window().getSize());
	}
}