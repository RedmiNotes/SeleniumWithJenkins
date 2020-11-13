package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Espncricinfo {

	public WebDriver driver;

	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchChromeBrowser(boolean window_max) {
		try {
			// System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriverManager.chromedriver().arch32().setup();
			ChromeOptions option = new ChromeOptions();
			if(window_max==true) {
				option.addArguments("--headless");
				option.addArguments("--start-maximized");
			}else if(window_max==false) {
				option.addArguments("--window-size=1920,1080");
			}
			driver = new ChromeDriver(option);
			wait(2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void navigatetoEspncricinfo() {
		try {
			driver.get("https://www.espncricinfo.com/");
			wait(20);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ad_popup() {
		try {
			boolean popup_1 = driver.findElements(By.xpath("//div/div[@class='wzrk-alert wiz-show-animate']")).size() != 0;
			if(popup_1==true) {
				WebElement popup1 = driver.findElement(By.xpath("//div/button[text()='Not Now']"));
				popup1.click();
				wait(3);
			}
			WebElement frame_1 = driver.findElement(By.xpath("//div[@class=\"adSlot bannerTopRoW \"]/div/iframe"));
			driver.switchTo().frame(frame_1);
			wait(3);
			String s1 = "//div[@id='cbb']";
			boolean element = driver.findElements(By.xpath(""+s1+"")).size() != 0;
			if(element==true) {
				driver.findElement(By.xpath(""+s1+"")).click();
				wait(2);
				if(driver.findElements(By.xpath("//div[@class='panel-content fade']/div/span[@id='closed_text']")).size()!=0==true) {
					System.out.println("successfully closed ad pop-up");
				}
			}else {
				System.out.println("Ad Pop-up not present or Close button not present or Unable to close ad pop-up");
			}
			driver.switchTo().defaultContent();
			wait(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void select_ipl_2020() {
		try {
			WebElement ipl_2020 = driver.findElement(By.xpath("//a/span[text()='IPL 2020']"));
			ipl_2020.click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void full_screen_of_page() {
		try {
			driver.manage().window().fullscreen();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void second_batting_scored() {
		try {
			boolean team = driver.findElements(By.xpath("//div[@class='scorecard-container scorecard-without-separator']")).size() != 0;
			if(team==true) {
				WebElement team_name = driver.findElement(By.xpath("(//div[@class=\"d-flex justify-content-between align-items-center competitor\"]//p)[1]"));
				String s1 = team_name.getText();
				WebElement team_score = driver.findElement(By.xpath("(//div[@class=\"d-flex justify-content-between align-items-center competitor\"]//div/span//span)[2]"));
				String s2 = team_score.getText();
				System.out.println("Team Name is : " + s1);
				System.out.println("Team Score is : " + s2);
				wait(2);
				team_score.click();
				wait(3);
			}else {
				System.out.println("Unable to get the score and unable click");
				driver.close();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickSummery() {
		try {
			WebElement summery = driver.findElement(By.xpath("//div[text()='Summary']"));
			summery.click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void players_name() {
		try {
			List<WebElement> players = driver.findElements(By.xpath("(//table[@class='table batsman'])[1]//tr/td/a"));
			List<String> players_name = new ArrayList<String>();
			for(WebElement names : players) {
				players_name.add(names.getText());
			}
			System.out.println("The Playes Name is : " + players_name);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeChromeBrowser() {
		try {
			driver.close();
			driver.quit();
			System.out.println("Success...");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			Espncricinfo espncricinfo = new Espncricinfo();
			espncricinfo.launchChromeBrowser(true);
			espncricinfo.navigatetoEspncricinfo();
			espncricinfo.ad_popup();
			espncricinfo.select_ipl_2020();
			espncricinfo.full_screen_of_page();
			espncricinfo.second_batting_scored();
			espncricinfo.players_name();
			espncricinfo.closeChromeBrowser();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}