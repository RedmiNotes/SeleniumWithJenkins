package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.common.CucumberCommon;

public class LetitCodePage extends CucumberCommon {
	public WebDriver driver;
	
	public LetitCodePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//input[@id='fulName']")
	public WebElement fullname;

	public void fill_name(String s1) {
		fullname.sendKeys(s1);
		wait(3);
	}
}
