package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Zomato {
	public WebDriver driver;
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchChromeHeadlessBrowser() {
		try {
			//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriverManager.chromedriver().arch32().setup();
			ChromeOptions option = new ChromeOptions();                               
			//option.addArguments("--headless");              //When I tried to run in headless mode, it throwing error as NoSuchElementException: no such element: Unable to locate element: 'A2B' in search box. Normal  run it working.
			//option.addArguments("window-size=1800x1080");
			driver = new ChromeDriver(option);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public void navigatetoZomato() {
		try {
			driver.get("https://www.zomato.com/chennai");
			driver.manage().window().maximize();
			wait(7);
			boolean cookie = driver.findElements(By.xpath("//button/span/span[text()='Accept']")).size() != 0;
			if(cookie==true) {
				driver.findElement(By.xpath("//button/span/span[text()='Accept']")).click();
				wait(3);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void TypeinRestaurantand_Cusinetextbook(String restaurant) {
		try {
			WebElement search = driver.findElement(By.xpath("(//div/input[@value])[2]"));
			search.sendKeys(restaurant);
			wait(2);
			search.click();
			wait(2);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void chooseLastListedOption() {
		try {
			String s1 = "//div/div[@class='sc-iNhVCk GSAgl']";
			List<WebElement> auto_suggest = driver.findElements(By.xpath(""+s1+""));
			int n = auto_suggest.size();
			for(int i=1;i<=n;i++) {
				WebElement lastoption = driver.findElement(By.xpath(""+s1+"["+i+"]"));
				Actions action = new Actions(driver);
				action.moveToElement(lastoption).build().perform();
				wait(2);
				if(i==1) {
					//if(i==n) {                                                       // Last Auto Suggestion option has not shown online order tab.
					lastoption.click();
					wait(3);
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onlineOrderandCheckOpenorClose() {
		try {
			boolean onlineorder = driver.findElements(By.xpath("//span[@id='TabLink__1']")).size() != 0;
			if(onlineorder==true) {
				driver.findElement(By.xpath("//span[@id='TabLink__1']")).click();
				wait(3);
			}else {
				closeChromeHeadlessBrowser();
				System.out.println("Unable to click Order Online Button.");
			}
			WebElement openorclose = driver.findElement(By.xpath("//section/section/span"));
			String s1 = openorclose.getText();
			System.out.println("The Restaurant is '" + s1 + "'");
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void musttryItems() {
		try {
			List<WebElement> musttryitemcount = driver.findElements(By.xpath("//div[text()='MUST TRY']"));
			int count = musttryitemcount.size();
			System.out.println("The MUST TRY Item count is : " + count);
			wait(3);
			List<WebElement> musttryitemname = driver.findElements(By.xpath("//div[text()='MUST TRY']/../../../h4"));
			List<String> itemname = new ArrayList<String>();
			for(WebElement name : musttryitemname) {
				itemname.add(name.getText());
			}
			System.out.println("The MUST TRY Item name is : " + itemname);
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void costliestItem() {
		try {
			List<WebElement> costliestSweetItem = driver.findElements(By.xpath("//h4[text()='Sweets']//following::div[2]//div/span[@class='sc-17hyc2s-1 fnhnBd']"));
			List<Integer> price = new ArrayList<Integer>();
			for(WebElement ele : costliestSweetItem) {
				price.add(Integer.parseInt(ele.getText().replaceAll("₹", "")));
			}
			System.out.println("The Sweet Item Price is : " + price);
			int max = price.get(0);
			for(int i=0;i<price.size();i++) {
				if(max<price.get(i)) {
					max = price.get(i);
				}
			}
			System.out.println("The Costliset Sweet Price is : " + max);
			WebElement costliestsweetname = driver.findElement(By.xpath("//h4[text()='Sweets']//following::span[contains(text(),'"+max+"')][1]/../../h4"));
			String s1 = costliestsweetname.getText();
			System.out.println("The Costliest Sweet Name is : " + s1);
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void validatePhotos() {
		try {
			WebElement photo = driver.findElement(By.xpath("//span/a[text()='Photos']"));
			photo.click();
			wait(3);
			List<WebElement> allphoto = driver.findElements(By.xpath("//div/div//img[@alt='Gallery Image']"));
			int n1 = allphoto.size();
			WebElement all_photo = driver.findElement(By.xpath("(//button/span/span)[2]"));
			String s1 = all_photo.getText().replace("(", "").replace(")", "");
			String s2[] = s1.split(" ");
			int n2 = Integer.parseInt(s2[1]);
			if(n1==n2) {
				System.out.println("Image Count Matching");
			}else {
				System.out.println("Image Count Mismatching");
			}
		}catch (Exception e) {
			e.getMessage();
		}
	}
	public WebDriver closeChromeHeadlessBrowser() {
		try {
			driver.close();
			driver.quit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public static void main(String[] args) {
		Zomato zomato = new Zomato();
		zomato.launchChromeHeadlessBrowser();
		zomato.navigatetoZomato();
		zomato.TypeinRestaurantand_Cusinetextbook("A2B");
		zomato.chooseLastListedOption();
		zomato.onlineOrderandCheckOpenorClose();
		zomato.musttryItems();
		zomato.costliestItem();
		zomato.validatePhotos();
		zomato.closeChromeHeadlessBrowser();
	}
}