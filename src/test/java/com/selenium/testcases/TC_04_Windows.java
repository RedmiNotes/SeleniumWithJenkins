package com.selenium.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.selenium.pages.Windowspage;
import com.selenium.projectspecify.ProjectSpecify;

public class TC_04_Windows extends ProjectSpecify {

	@BeforeClass
	public void startpage() {	
		startbrowser("chrome","windows");
		desc = "TC_04_Windows and TAB";
	}
	@Test
	public void Windows_Tab() {
		Windowspage window = PageFactory.initElements(driver, Windowspage.class);
		window.one();
	}
	@AfterSuite
	public void closebrowser() {
		driver.close();
		driver.quit();
	}
}
