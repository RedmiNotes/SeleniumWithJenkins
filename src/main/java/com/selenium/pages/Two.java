package com.selenium.pages;
import org.openqa.selenium.WebDriver;

import com.selenium.common.One;

public class Two extends One{

	public Two(WebDriver driver) {
		super(driver);
	}
	public void get_title() {
		System.out.println("Title is : " + title());
	}
}
