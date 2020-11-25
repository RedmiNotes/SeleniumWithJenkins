package com.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.*;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class AllureReport {
	public WebDriver driver;
	@BeforeTest
	public void ValidateTitle() {
		try {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Step("Get Title of the Page")
	public String title() {
		return driver.getTitle();
	}
	@Test
	@Description("Test Case 01")
	@Severity(SeverityLevel.BLOCKER)
	@Story("[JIRA-1345] This story checks the basic element of web page")
	@Feature("Title Page")
	public void tc_01() {
		Assert.assertEquals(title(), "Google");
	}
	@Test
	@Description("Test Case 02")
	@Severity(SeverityLevel.NORMAL)
	@Story("[JIRA-1445] This story checks the basic element of web page")
	@Feature("Search Page")
	public void tc_02() {
		driver.findElement(By.name("q")).sendKeys("Allure Report");
		WebElement search = driver.findElement(By.xpath("//input[@title='Search']"));
		Assert.assertEquals(isSearch(search), true);
	}
	@Step("Verify Search Title")
	public boolean isSearch(WebElement ele) {
		return ele.isDisplayed();
	}
	@AfterTest
	public void Finish() {
		driver.close();
		driver.quit();
	}
}