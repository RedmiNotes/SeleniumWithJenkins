package com.selenium.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.pages.Buttonpage;
import com.selenium.pages.EditTextbox;
import com.selenium.projectspecify.ProjectSpecify;

public class TC_03_Buttons extends ProjectSpecify {

	@BeforeClass
	public void startpage() {	
		startbrowser("chrome","btn");
		desc = "TC_03 Button Page";
	}
	@Test
	public void Button_Page() {
		Buttonpage button = PageFactory.initElements(driver, Buttonpage.class);
		button.one(); 
		button.two();
		button.three();
	}
	@AfterSuite
	public void closebrowser() {
		driver.close();
		driver.quit();
	}
}
