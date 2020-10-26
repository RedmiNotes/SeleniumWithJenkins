package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.common.SeleniumCommon;

public class EditTextbox extends SeleniumCommon {

	public EditTextbox(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='fulName']")
	public WebElement fullname;
	
	@FindBy(xpath = "//input[@id='append']")
	public WebElement appendname;
	
	@FindBy(xpath = "//input[@id='getme']")
	public WebElement getvalue;

	
	public void one(String s1) {
		try {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+s1+"'",fullname);
		//fullname.sendKeys(s1);
		test.log(LogStatus.INFO, "Successfully Enter Fullname : " + s1);
		wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Enter Fullname");
		}
	}
	public void two(String s1) {
		try {
		appendname.click();
		wait(2);
		new Actions(driver).sendKeys(Keys.SPACE).build().perform();
		wait(2);
		appendname.sendKeys(s1);
		test.log(LogStatus.INFO, "Successfully append text : " + s1);
		wait(3);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to append text");
		}
	}
	public void three() {
		try {
			String s1 = getvalue.getAttribute("value");
			test.log(LogStatus.INFO, "Successfully get text : " + s1);
			wait(3);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to get text");
		}
	}
}