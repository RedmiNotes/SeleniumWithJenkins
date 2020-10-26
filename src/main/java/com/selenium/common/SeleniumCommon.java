package com.selenium.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.selenium.projectspecify.ProjectSpecify;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCommon extends ProjectSpecify {

	protected WebDriver driver;
	
	public SeleniumCommon(WebDriver driver) {
		this.driver = driver;
	}
	
	public Properties prodatas() {
		Properties pro = null;
		try {
			pro = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/testdata.properties");
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	

	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectWebpage(String s1) {
		prodatas();
		wait(3);
		WebElement webpage = driver.findElement(By.xpath("//button[@name='"+s1+"']"));
		webpage.click();
		wait(3);
	}
}