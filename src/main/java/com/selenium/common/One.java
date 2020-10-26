package com.selenium.common;

import org.openqa.selenium.WebDriver;

public class One {
	protected WebDriver driver;
	
	public One(WebDriver driver) {
		this.driver = driver;
	}
	
	public String title() {
		System.out.println("GOOGLE PAGE");
		return driver.getTitle();
	}
}