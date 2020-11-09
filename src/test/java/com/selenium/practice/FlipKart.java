package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart {

	public WebDriver driver;
	List<String> item_name = null;
	String p_name;

	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchFirefoxBrowser() {
		try {
			// System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			WebDriverManager.firefoxdriver().arch32().setup();
			driver = new FirefoxDriver();
			wait(2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void navigatetoFlipkartWebsite() {
		try {
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			wait(5);
			boolean login_popup = driver.findElements(By.xpath("//span/span[text()='Login']")).size() != 0;
			if(login_popup==true) {
				WebElement close_login_popup = driver.findElement(By.xpath("//div/div/button"));
				new Actions(driver).click(close_login_popup).build().perform();
			}else {
				System.out.println("The Login Pop-up is not Appeared.");
				wait(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void searchHomeTeaters(String search) {
		try {
			WebElement search_ht = driver.findElement(By.name("q"));
			search_ht.sendKeys(search);
			wait(2);
			WebElement click_search = driver.findElement(By.xpath("//button[@type='submit']"));
			click_search.click();
			wait(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebElement rating() {
		return driver.findElement(By.xpath("//div[contains(text(),'4★')]"));
	}
	public WebElement showing_result() {
		return driver.findElement(By.xpath("//div//span[@class='_2yAnYN']"));
	}
	public void chooseCustomRating() {
		try {	
			String before_showing_selection_result = showing_result().getText();
			System.out.println("Before Showing Selection Result : " + before_showing_selection_result);
			boolean ratings = driver.findElements(By.xpath("//div[@class=\"_1HmYoV _35HD7C col-12-12\"]//following::section//div[text()='Customer Ratings']//following::div[@class=\"_36jUgy\"]")).size() != 0;
			if(ratings==true) {
				rating().click();
				wait(3);
			}else {
				WebElement cus_rat = driver.findElement(By.xpath("//section//div[text()='Customer Ratings']"));
				cus_rat.click();
				wait(2);
				rating().click();
				wait(3);
			}
			String after_showing_selection_result = showing_result().getText();
			System.out.println(" After Showing Selection Result : " + after_showing_selection_result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickPriceHightoLow() {
		try {
			WebElement high_to_low = driver.findElement(By.xpath("//div[contains(text(),'High to Low')]"));
			high_to_low.click();
			wait(3);
			String s1 = high_to_low.getAttribute("class");
			String s2 = high_to_low.getText();
			if(s1.equals("_1xHtJz xufquN") && s2.equals("Price -- High to Low")) {
				System.out.println("Successfully Selected Price High to Low Tab.");
			}else {
				System.out.println("Failed to Select Price High to Low Tab.");
				driver.close();
			}
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<String> sortedPrice() {
		List<String> sort_price = new ArrayList<String>();
		try {
			List<WebElement> price = driver.findElements(By.xpath("//div/div[contains(@class,'1vC4OE')]"));
			for(WebElement prod_sort_price : price) {
				sort_price.add(prod_sort_price.getText().replaceAll("₹", ""));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sort_price;
	}
	public void select_two_product_for_compare() {
		try {
			List<WebElement> total = driver.findElements(By.xpath("//div[@class='_3liAhj']"));
			for(int i=1;i<total.size();i++) {
				WebElement select_add_to_compar = driver.findElement(By.xpath("(//div[@class='_3liAhj'])["+i+"]"));

				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true)", select_add_to_compar);
				wait(2);

				Actions action = new Actions(driver);
				action.moveToElement(select_add_to_compar).build().perform();
				wait(2);

				boolean checkbox = driver.findElements(By.xpath("(//div[@class='_3liAhj'])["+i+"]//following::div//label/span")).size() != 0;
				if(checkbox==true) {
					WebElement add_to_compare = driver.findElement(By.xpath("(//div[@class='_3liAhj'])["+i+"]//following::div//label/span"));
					String s1 = add_to_compare.getText();
					if(s1.equals("Add to Compare")) {
						add_to_compare.click();
						wait(2);
						WebElement compare = driver.findElement(By.xpath("(//span[text()='COMPARE']//following::div/span)[2]"));
						String s2 = compare.getText();
						wait(3);
						if(s2.equals("2")) {
							driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
							break;
						}
					}
				}else {
					System.out.println("Unable to Select The Product");
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void compareProduct() {
		try {
			String s1 = "//a//span[text()='COMPARE']";
			boolean b1 = driver.findElements(By.xpath(""+s1+"")).size() != 0;
			if(b1==true) {
				driver.findElement(By.xpath(""+s1+"")).click();
			}else {
				System.out.println("Unable to see Compare Button");
				driver.close();
			}
			WebElement name = driver.findElement(By.xpath("(//a[@class='_3YNWH1'])[1]"));
			String s2 = name.getText();
			if(p_name.equals(s2)) {
				System.out.println("Product Name Same");
			}else {
				System.out.println("Product Name Mismatching");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebDriver closeFirefoxBrowser() {
		try {
			driver.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public static void main(String[] args) {
		try {
			FlipKart flipkart = new FlipKart();
			flipkart.launchFirefoxBrowser();
			flipkart.navigatetoFlipkartWebsite();
			flipkart.searchHomeTeaters("Home Theaters");
			flipkart.chooseCustomRating();
			flipkart.clickPriceHightoLow();
			System.out.println("The Sorted Price is : " + flipkart.sortedPrice());
			flipkart.select_two_product_for_compare();
			//flipkart.select_2_product_for_compare();
			//flipkart.compareProduct();
			//flipkart.closeFirefoxBrowser();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}