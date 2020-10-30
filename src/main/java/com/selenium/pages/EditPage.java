package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.common.CucumberCommon;
import com.relevantcodes.extentreports.LogStatus;

public class EditPage extends CucumberCommon {

	public WebDriver driver;

	public EditPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//h5[text()='Edit']")
	public WebElement editpage;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement email;

	@FindBy(xpath = "//input[contains(@value,'Append')]")
	public WebElement entername;

	public void edit_page() {
		editpage.click();
		wait(5);
		test.log(LogStatus.INFO, "Navigate to Edit Page");
	}

	public void e_mail(String mail) {
		email.sendKeys(mail);
		wait(3);
		test.log(LogStatus.INFO, "Successfully Entered Email : " + mail);
	}

	public void enter_name(String name) {
		entername.click();
		wait(2);
		entername.sendKeys(name);
		wait(3);
		test.log(LogStatus.INFO, "Successfully Entered Name : " + name);
	}
}