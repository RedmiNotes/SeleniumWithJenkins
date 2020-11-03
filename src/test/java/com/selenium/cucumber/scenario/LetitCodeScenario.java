package com.selenium.cucumber.scenario;

import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;
import java.util.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import com.cucumber.common.CucumberCommon;
import com.selenium.pages.LetitCodePage;

@RunWith(Cucumber.class)
public class LetitCodeScenario extends CucumberCommon {

	List<Map<String,String>> map = readdata();
	LetitCodePage letcode = PageFactory.initElements(driver, LetitCodePage.class);

	@Given("^Navigate to Let it Code Website$")
	public void navigate_to_Let_it_Code_Website() {
		String s1 = map.get(2).get("URL");	
		driver.get(s1);
		driver.manage().window().maximize();
		wait(3);
	}
	@Then("^Enter your Fullname$")
	public void enter_your_Fullname() {
		String s1 = map.get(2).get("Name");
		letcode.fill_name(s1);
	}
}