package com.selenium.testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SingleLoginultipleTime {
	public WebDriver driver;

	@BeforeTest
	public void startbrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qa.gsihealth.net");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	@Test
	public void tc_01() throws InterruptedException {
		String s1 = "automationone@gsihealth.com";
		String s2 = "Test123#";
		for(int i=1;i<=3;i++) {
			if(i==1) {
				login(s1, randval());
			}else if (i==2) {
				login(randval(), s2);
			}else if(i==3) {
				login(s1, s2);
			}
		}
	}
	public void login(String user,String pass) throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//input[contains(@name,'UserID')]"));
		username.clear();
		Thread.sleep(2000);
		username.sendKeys(user);
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.xpath("//input[contains(@name,'Password')]"));
		password.clear();
		Thread.sleep(2000);
		password.sendKeys(pass);
		Thread.sleep(3000);
	}
	public static String randval() {
		String s = "abcdefghijklmnopqrstuvwxyz";
		String s2 = "";
		char[] ch = s.toCharArray();
		for(int i=0;i<=5;i++) {
			s2 += ch[new Random().nextInt(s.length())]; 
		}
		return s2;
	}
}