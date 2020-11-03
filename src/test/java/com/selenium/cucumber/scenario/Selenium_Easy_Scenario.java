package com.selenium.cucumber.scenario;

import java.util.Map;

import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.common.CucumberCommon;
import com.selenium.pages.SeleniumEasyPage;

import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class Selenium_Easy_Scenario extends CucumberCommon {

	//Map<String, Map<String,Object>> map = readjson();
	Map<String, Object> map1 = readjson().get("selenium_easy");

	SeleniumEasyPage easy = PageFactory.initElements(driver, SeleniumEasyPage.class);

	@Given("^Navigate to the Selenium easy website$")
	public void Navigate_to_the_Selenium_easy_website() {
		String s1 = (String)map1.get("url");
		driver.get(s1);
		driver.manage().window().maximize();
		wait(4);
		scroll_to(0, 375);
		wait(3);
	}
	@When("^Enter FirstName And LastName$")
	public void enter_FirstName_And_LastName() {
		String firstname = (String)map1.get("firstname");
		easy.first_name(firstname);
		String lastname = (String)map1.get("lastname");
		easy.last_name(lastname);
	}
	@Then("^Enter Email And Phone no$")
	public void enter_Email_And_Phone_no() {
		String mail = (String)map1.get("email");
		easy.e_mail(mail);
		String phone = (String)map1.get("phone");
		easy.phone_no(phone);
	}
	@Then("^Enter Address And City$")
	public void enter_Address_And_City() {
		String address = (String)map1.get("address");
		easy.a_address(address);
		String city = (String)map1.get("city");
		easy.a_city(city);
	}
	@Then("^Select the State$")
	public void select_the_State() {
		String state = (String)map1.get("state");
		easy.sel_state(state);
	}
	@Then("^Enter Zipcode and Domain$")
	public void enter_Zipcode_and_Domain() {
		easy.zip_code();
		String domain = (String)map1.get("domain");
		easy.a_domain(domain);
	}
	@Then("^Select Hosting and Enter Description$")
	public void select_Hosting_and_Enter_Description() {
		easy.hosting();
		String descr = (String)map1.get("desc");
		easy.desc(descr);
	}
	@Then("^Click Send Button$")
	public void click_Send_Button() {
		easy.send_button();
	}
}