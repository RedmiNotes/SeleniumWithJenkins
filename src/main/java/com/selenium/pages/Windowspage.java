package com.selenium.pages;

import java.util.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.common.SeleniumCommon;

public class Windowspage extends SeleniumCommon{

	public Windowspage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//button[@id='multi']")
	public WebElement multiplewindow;
	@FindBy(id = "prompt")
	public WebElement promptalert;
	
	public void one() {
		try {
		multiplewindow.click();
		wait(3);
		List<String> al1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(al1.get(2));
		wait(2);
		promptalert.click();
		wait(2);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Alert Test");
		wait(2);
		alert.accept();
		wait(2);
		driver.close();
		wait(3);
		driver.switchTo().window(al1.get(0));
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to navigate windows");
		}
	}
}