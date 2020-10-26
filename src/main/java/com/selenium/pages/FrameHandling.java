package com.selenium.pages;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.common.SeleniumCommon;

public class FrameHandling extends SeleniumCommon {

	public FrameHandling(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//label[text()='Name']/..//div/input")
	WebElement entername;


	public void frame_size() {
		List<WebElement> framesize = driver.findElements(By.tagName("iframe"));
		System.out.println(framesize.size());
		test.log(LogStatus.INFO, "The Frame Size is : " + framesize.size());
		driver.switchTo().frame(framesize.get(0));
		wait(3);
	}

	public void enter_name(String name) {
		try {
		entername.sendKeys(name);
		test.log(LogStatus.INFO, "The Name is : " + name);
		wait(3);
		}catch (Exception e) {
		   test.log(LogStatus.FAIL, "Unable to enter name");
		}
	}
}