package com.selenium.cucumber.scenario;

import java.util.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import com.cucumber.common.CucumberCommon;
import com.selenium.pages.EditPage;
import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class TC_01_EditTextbox extends CucumberCommon {
	EditPage edit = PageFactory.initElements(driver, EditPage.class);
	Map<String, String> map = excelread(0);
	
	@Given("^login to teaf leaf website$")
	public void login_to_teaf_leaf_website() {
		String s1 = map.get("URL");
		System.out.println("URL is : " + s1);
		driver.get(s1);
		driver.manage().window().maximize();
		wait(5);
	}

	@When("^navigate to edit page$")
	public void navigate_to_edit_page() {
		edit.edit_page();
	}

	@Then("^enter the firstname$")
	public void enter_the_firstname() {
		String s1 = map.get("Email");
		System.out.println("Email is : " + s1);
		edit.e_mail(s1);
	}

	@Then("^enter the lastname$")
	public void enter_the_lastname() {
		String s1 = map.get("Name");
		System.out.println("Name is : " + s1);
		edit.enter_name(" " + s1);
	}
}