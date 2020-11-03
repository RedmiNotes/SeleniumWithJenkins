package com.selenium.pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.cucumber.common.CucumberCommon;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumEasyPage extends CucumberCommon {

	@FindBy(xpath = "//input[@name='first_name']")
	public WebElement firstname;

	@FindBy(xpath = "//input[@name='last_name']")
	public WebElement lastname;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@name='phone']")
	public WebElement phoneno;

	@FindBy(xpath = "//input[@name='address']")
	public WebElement address;

	@FindBy(xpath = "//input[@name='city']")
	public WebElement city;

	@FindBy(xpath = "//select[@name='state']")
	public WebElement state;

	@FindBy(xpath = "//input[@name='zip']")
	public WebElement zipcode;

	@FindBy(xpath = "//input[@name='website']")
	public WebElement domain;

	@FindBy(xpath = "//textarea[@name='comment']")
	public WebElement description;
	
	@FindBy(xpath = "//button[contains(text(),'Send')]")
	public WebElement sendbutton;

	public void first_name(String name) {
		firstname.sendKeys(name);
		test.log(LogStatus.INFO, "Firt_Name : " + name);
		wait(2);
	}
	public void last_name(String name) {
		lastname.sendKeys(name);
		test.log(LogStatus.INFO, "Last_Name : " + name);
		wait(2);
	}
	public void e_mail(String mail) {
		email.sendKeys(mail);
		test.log(LogStatus.INFO, "E-Mail : " + mail);
		wait(2);
	}
	public void phone_no(String phone) {
		phoneno.sendKeys(phone);
		test.log(LogStatus.INFO, "Phone_No : " + phone);
		wait(2);
	}
	public void a_address(String addresss) {
		address.sendKeys(addresss);
		test.log(LogStatus.INFO, "Address : " + addresss);
		wait(2);
	}
	public void a_city(String cities) {
		city.sendKeys(cities);
		test.log(LogStatus.INFO, "City : " + cities);
		wait(2);
	}
	public void sel_state(String s1) {
		state.click();
		wait(3);
		List<WebElement> states = driver.findElements(By.xpath("//select[@name='state']/option[not(@value=' ')]"));
		int n = states.size();
		String s2 = null;
		for(int i=1;i<=n;i++) {
			if(i==1) {
				continue;
			}
			WebElement select_state = driver.findElement(By.xpath("(//select[@name='state']/option)["+i+"]"));
			wait(1);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ARROW_DOWN).build().perform();
			wait(1);
			s2 = select_state.getText().trim();
			wait(1);
			if(s2.equals(s1)) {
				act.sendKeys(Keys.ENTER).build().perform();
				wait(2);
				break;
			}
		}
		test.log(LogStatus.INFO, "State : " + s2);
		wait(2);
	}
	public void zip_code() {
		String s1 = zips();
		zipcode.sendKeys(s1);
		test.log(LogStatus.INFO, "Zip_Code : " + s1);
		wait(2);
	}
	public String zips() {
		String s1 = "0123456789";
		char[] ch = s1.toCharArray();
		String s2 = "";
		for(int i=0;i<=5;i++) {
			s2 += ch[new Random().nextInt(s1.length())];
		}
		return s2;
	}
	public void a_domain(String s1) {
		domain.sendKeys(s1);
		test.log(LogStatus.INFO, "Domain : " + s1);
		wait(2);
	}
	public void hosting() {
		List<WebElement> host = driver.findElements(By.xpath("//input[@type='radio']"));
		int n = new Random().nextInt(host.size());
		host.get(n).click();
		String s1 = host.get(n).getAttribute("value");
		test.log(LogStatus.INFO, "Hosting : " + s1);
		wait(2);
	}
	public void desc(String s1) {
		description.sendKeys(s1);
		test.log(LogStatus.INFO, "Description : " + s1);
		wait(2);
	}
	public void send_button() {
		sendbutton.click();
		test.log(LogStatus.PASS, "Successfully Clicked Send Button");
		wait(2);
	}
}