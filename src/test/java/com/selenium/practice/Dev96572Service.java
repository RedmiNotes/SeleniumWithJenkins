package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dev96572Service {
	public WebDriver driver;
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public boolean verifyelement(String s1) {
		return driver.findElements(By.xpath(s1)).size() != 0;
	}
	public WebDriver launchFirefoxandNavigatetoServicenow() {
		try {
			// System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			WebDriverManager.firefoxdriver().arch32().setup();
			driver = new FirefoxDriver();
			driver.get("https://dev96572.service-now.com/");
			driver.manage().window().maximize();
			wait(7);
			if(verifyelement("//span[text()='ServiceNow Home Page']")==true) {
				System.out.println("Successfully navigated to dev service page.");
			}else {
				System.out.println("Failed to navigate dev service page.");
				closeFirefoxBrowser();
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
		return driver;
	}
	public WebDriver framenavigate() {
		WebElement frames = driver.findElement(By.id("gsft_main"));
		return driver.switchTo().frame(frames);
	}
	public void loginPage(String username,String password) {
		try {
			framenavigate();
			WebElement user_name = driver.findElement(By.xpath("//input[@name='user_name']"));
			user_name.sendKeys(username);
			wait(3);
			WebElement user_password = driver.findElement(By.xpath("//input[@name='user_password']"));
			user_password.sendKeys(password);
			wait(3);
			WebElement login = driver.findElement(By.xpath("//button[text()='Login']"));
			login.click();
			wait(10);
			driver.switchTo().defaultContent();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	public void filterNavigator(String filtervalue) {
		try {
			String fltr = "//input[@id='filter']";
			if(verifyelement(fltr)==true) {
				WebElement filter = driver.findElement(By.xpath(""+fltr+""));
				filter.click();
				filter.sendKeys(filtervalue);
				wait(3);
			}else {
				System.out.println("Unable to enter value in filter");
				closeFirefoxBrowser();
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	public void applicationRegistary() {
		try {
			String ar = "//div[text()='Application Registry']";
			if(verifyelement(ar)==true) {
				WebElement application_registery = driver.findElement(By.xpath(""+ar+""));
				application_registery.click();
				wait(3);
			}else {
				System.out.println("Unable to click Application Registary");
				closeFirefoxBrowser();
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	public void newApplicationRegistary() {
		try {
			framenavigate();
			String newar = "//button[text()='New']";
			if(verifyelement(newar)==true) {
				WebElement newapplicationregistary = driver.findElement(By.xpath(""+newar+""));
				newapplicationregistary.click();
				wait(3);
			}else {
				System.out.println("Unable to click New Application Registary");
				closeFirefoxBrowser();
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	public void clickCreateanOAuthAPIendpointforexternalclients(String s1) {
		try {
			List<WebElement> createoauthapi = driver.findElements(By.xpath("//div[@class='container-fluid wizard-container']/a"));
			List<String>  oauthapi = new ArrayList<String>();
			for(WebElement name : createoauthapi) {
				oauthapi.add(name.getText().trim());
			}
			wait(2);
			for(int i=0;i<oauthapi.size();i++) {
				if(oauthapi.get(i).contains(s1)) {
					WebElement oauth_api = driver.findElement(By.xpath("//a[contains(text(),'"+oauthapi.get(i)+"')]"));
					oauth_api.click();
					wait(3);
					break;
				}
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	String full_name;
	String client_id;
	public void fillName(String s1) {
		try {
			String name = "//input[@name='oauth_entity.name']";
			if(verifyelement(name)==true) {
				Date currentdate = new Date();
				SimpleDateFormat dateformat = new SimpleDateFormat("ddMMyyyy");
				String date = dateformat.format(currentdate);
				full_name = s1+"_"+date;
				WebElement entername = driver.findElement(By.xpath(""+name+""));
				entername.sendKeys(full_name);
				wait(3);
				WebElement clientid = driver.findElement(By.xpath("//input[@name='oauth_entity.client_id']"));
				client_id = clientid.getAttribute("value");
				wait(2);
				System.out.println("Name is   : " + full_name);
				System.out.println("Client id : " + client_id);
			}else {
				System.out.println("Unable to enter name");
				closeFirefoxBrowser();
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	public void clickSubmit() {
		try {
			WebElement submit = driver.findElement(By.xpath("//div/button[text()='Submit']"));
			submit.click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void cofirmOauthCreated() {
		try {
			boolean flag = false;
			WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
			search.sendKeys(full_name);
			wait(3);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			wait(2);
			List<WebElement> oauthname = driver.findElements(By.xpath("//tbody//tr/td[@class='vt'][1]"));
			List<String> name = new ArrayList<String>();
			for(WebElement oname : oauthname) {
				name.add(oname.getText());
			}
			List<WebElement> oauthid = driver.findElements(By.xpath("//tbody//tr/td[@class='vt'][4]"));
			List<String> id = new ArrayList<String>();
			for(WebElement oid : oauthid) {
				id.add(oid.getText());
			}
			for(int i=0;i<name.size();i++) {
				for(int j=0;j<id.size();j++) {
					if(name.get(i).equals(full_name) && id.get(j).equals(client_id)) {
						flag = true;
					}else {
						continue;
					}
				}
			}
			if(flag==true) {
				System.out.println("Successfully created Oauth Application Registary.");
				System.out.println("Created Registary displayed in Application Registary Home page.");
				delete();
				driver.switchTo().defaultContent();
				wait(2);
			}else {
				System.out.println("Failed to create Oauth Application Registary.");
				System.out.println("Created Registary not displayed in Application Registary Home page.");
				closeFirefoxBrowser();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete() {
		try {
			WebElement delete_name = driver.findElement(By.xpath("//a[text()='"+full_name+"']"));
			delete_name.click();
			wait(2);
			WebElement delete_button = driver.findElement(By.xpath("//div/button[text()='Delete']"));
			delete_button.click();
			wait(2);
			WebElement ok_button = driver.findElement(By.xpath("//button[@id='ok_button']"));
			ok_button.click();
			wait(2);
			WebElement oauth = driver.findElement(By.xpath("//b[contains(text(),'OAuth')]"));
			oauth.click();
			wait(2);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebDriver closeFirefoxBrowser() {
		try {
			driver.quit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public static void main(String[] args) {
		Dev96572Service devservice = new Dev96572Service();
		devservice.launchFirefoxandNavigatetoServicenow();
		devservice.loginPage("admin", "Tuna@123");
		devservice.filterNavigator("oauth");
		devservice.applicationRegistary();
		devservice.newApplicationRegistary();
		devservice.clickCreateanOAuthAPIendpointforexternalclients("API");
		devservice.fillName("Dinesh");
		devservice.clickSubmit();
		devservice.cofirmOauthCreated();
		devservice.closeFirefoxBrowser();
	}
}