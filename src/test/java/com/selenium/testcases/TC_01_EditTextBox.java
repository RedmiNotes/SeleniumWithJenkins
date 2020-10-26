package com.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import com.selenium.common.SeleniumCommon;
import com.selenium.pages.EditTextbox;
import com.selenium.projectspecify.ProjectSpecify;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

public class TC_01_EditTextBox extends ProjectSpecify {
	
	
	Fairy fake = Fairy.create();
	Person person = fake.person();

	//EditTextbox textbox = PageFactory.initElements(driver, EditTextbox.class);
	
	
	@BeforeClass
	public void startpage() {	
		startbrowser("chrome","input");
		desc = "TC_01 Edit Textbox";
	}
	@Test
	public void one() {
		EditTextbox textbox = PageFactory.initElements(driver, EditTextbox.class);
		textbox.one(person.getFullName()); 
		textbox.two(person.getFirstName());
		textbox.three();
	}
	@AfterSuite
	public void closebrowser() {
		driver.close();
		driver.quit();
	}
}