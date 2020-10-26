package com.selenium.pages;

import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebDriver;

import com.selenium.common.SeleniumCommon;

public class Buttonpage extends SeleniumCommon {

	public Buttonpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@id='position']")
	public WebElement xycoor;
	
	@FindBy(xpath = "//button[@id='color']")
	public WebElement getcolor;
	
	@FindBy(xpath = "//button[@id='property']")
	public WebElement heiwid;
	
	public void one() {
		try {
			int x = xycoor.getLocation().getX();
			int y = xycoor.getLocation().getY();
			test.log(LogStatus.INFO, "X Location : " + x + "\nY Location : " + y);
			wait(2);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to get location of the button");
		}
	}
	public void two() {
		try {
			String s1 = getcolor.getCssValue("color");
			test.log(LogStatus.INFO, "Color is : " + s1);
			wait(2);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to get color");
		}
	}
	public void three() {
		try {
			int height = heiwid.getSize().getHeight();
			int width = heiwid.getSize().getWidth();
			test.log(LogStatus.INFO, "Height is : " + height + "\nWidth is : " + width);
			wait(2);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to get Height and Width");
		}
	}
}
