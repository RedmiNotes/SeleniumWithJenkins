package com.selenium.practice;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public WebDriver driver;
	String max_price;

	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--incognito");
			driver = new ChromeDriver(co);
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void selectFurniture(boolean b1) {
		try {
			driver.findElement(By.id("searchDropdownBox")).click();
			wait(2);
			if(b1==true) {
				List<WebElement> furniture = driver.findElements(By.xpath("//select/option"));
				for(int i=1;i<=furniture.size();i++) {
					WebElement sel_fur = driver.findElement(By.xpath("//select/option["+i+"]"));
					String s1 = sel_fur.getText();
					wait(1);
					Actions action = new Actions(driver);
					if(s1.trim().equals("Furniture")) {
						action.sendKeys(Keys.ENTER).build().perform();
						wait(1);
						break;
					}else {
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						wait(1);
					}
				}
			}else {
				driver.findElement(By.xpath("//select/option[text()='Furniture']")).click();
				wait(2);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	public void chairsForComputerTable() {
		String value = "chairs for computer table";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(value);
		wait(2);
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		wait(2);
	}
	public void highestPriceoftheChair() {
		try {
			List<Integer> price = new ArrayList<Integer>();
			List<WebElement> chair_price = driver.findElements(By.xpath("//div[contains(@class,'s-include-content')]//span[@class='a-price']//span[@class='a-price-whole']"));
			for(WebElement ele : chair_price) {
				price.add(Integer.parseInt(ele.getText().replace(",", "")));
			}
			System.out.println("The First Page Price List : " + price);
			int max = price.get(0);
			for(int i=0;i<price.size();i++) {
				if(max<=price.get(i)) {
					max = price.get(i);
				}
			}
			System.out.println("The Maximum Price is : " + max);
			DecimalFormat df = new DecimalFormat("##,##,##0");
			max_price = df.format(max);
			System.out.println("The Maximum Price Format is : " + max_price);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void priceRating() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait(2);
		WebElement higestpricerating = driver.findElement(By.xpath("//span[text()='"+max_price+"']/ancestor::div[6]//i[contains(@class,'aok-align-bottom')]"));
		wait(2);
		js.executeScript("arguments[0].scrollIntoView(true);", higestpricerating);
		wait(3);
		Actions act = new Actions(driver);
		act.moveToElement(higestpricerating).build().perform();
		wait(5);
		WebElement total_rating = driver.findElement(By.xpath("//span[@data-hook='total-rating-count']"));
		String totalrating = total_rating.getText();
		System.out.println("Total Rating : " + totalrating);
		WebElement percentage = driver.findElement(By.xpath("//a[normalize-space(text())='5 star']//following::span/a[@class='a-link-normal']"));
		String percentagerate = percentage.getText();
		System.out.println("Persentage : " + percentagerate);
		
		String s1 = totalrating.replaceAll("[^-?0-9]+", "");
		
		String s2 = percentagerate.replace("%", "");
		
		double a = Integer.parseInt(s2);
		
		int b = Integer.parseInt(s1);
		
		double c = (a/100)*b;
		
		System.out.println("The Value is : " + Math.round(c));
	}
	public WebDriver closeBrowser() {
		wait(3);
		driver.close();
		driver.quit();
		return driver;
	}
	public static void main(String[] args) {
		try {
			Amazon amazon = new Amazon();
			amazon.launchBrowser();
			amazon.selectFurniture(false);
			amazon.chairsForComputerTable();
			amazon.highestPriceoftheChair();
			amazon.priceRating();
			amazon.closeBrowser();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}