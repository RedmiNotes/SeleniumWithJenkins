package com.selenium.practice;

import java.util.*;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public WebDriver driver;

	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchFirefoxBrowser() {
		try {
			// System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriverManager.chromedriver().arch32().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
			wait(2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void navigatetoAjio() {
		try {
			driver.get("https://www.ajio.com/");
			driver.manage().window().maximize();
			wait(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Actions action() {
		return new Actions(driver);
	}
	public void selectWomenandBrands() {
		try {
			WebElement women = driver.findElement(By.xpath("//div/ul//li/a[text()='WOMEN']"));
			action().moveToElement(women).build().perform();
			wait(3);
			WebElement brand = driver.findElement(By.xpath("//div/ul//li/a[text()='BRANDS']"));
			action().moveToElement(brand).build().perform();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clicktheLinkthathasMostNumberofLowerCaseCharacter() {
		try {
			String s1 = "(//div/ul//li/a[text()='BRANDS']/../div/div[contains(@class,'menu-lsec-full')])[2]//div[@class='items']/span/a";
			List<WebElement> allItemsname = driver.findElements(By.xpath(""+s1+""));
			List<String> nameofItem = new ArrayList<String>();
			for(WebElement name : allItemsname) {
				nameofItem.add(name.getText());
			}

			System.out.println("The Name of the Product : " + nameofItem);

			Map<String, Integer> mostlowercasecharacter = new LinkedHashMap<String, Integer>();
			int count;
			for(int i=0;i<nameofItem.size();i++) {
				char[] ch = nameofItem.get(i).toCharArray();
				count = 0;
				for(int j=0;j<ch.length;j++) {
					if(Character.isLowerCase(ch[j])) {
						count++;
					}
				}
				mostlowercasecharacter.put(nameofItem.get(i), count);
			}
			System.out.println("The Product Name and Lower Case Count : " + mostlowercasecharacter);

			String key = null;
			int value;
			for(Entry<String, Integer> map : mostlowercasecharacter.entrySet()) {
				value = map.getValue();
				if(value>15) {
					key = map.getKey();
				}
			}
			System.out.println("The Most Lower Case Character is : " + key);

			WebElement mostnumberlowercasecharcter_link = driver.findElement(By.xpath("//span/a[text()='"+key+"']"));
			mostnumberlowercasecharcter_link.click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	String before_numberofItems;
	public void printandStoreNumberofItems() {
		try {
			WebElement no_of_items = driver.findElement(By.xpath("//div/div[@class='length']"));
			before_numberofItems = no_of_items.getText();
			System.out.println("Before Number of Items : " + before_numberofItems);
			wait(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectSizeandFitasS() {
		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
			wait(3);
			WebElement sizeandfit = driver.findElement(By.xpath("//span[text()='size & fit']"));
			sizeandfit.click();
			wait(3);
			String s1 = "//span[text()='size & fit']//following::div[@class='facet-body']//ul/li[1]";
			WebElement selectsizeS = driver.findElement(By.xpath(""+s1+""));
			selectsizeS.click();
			wait(3);
			WebElement size_verify_2 = driver.findElement(By.xpath("//div[@class='fnl-plp-afliter']/span"));
			String s2 = size_verify_2.getText();
			if(s2.equals("S")) {
				System.out.println("Successfully Selected Size.");
			}else {
				System.out.println("Unable to Select the  Size.");
			}
			wait(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	String after_numberofItems;
	public void printandStoreNumberofItems_afterselectionSizeandfit() {
		try {
			WebElement no_of_items = driver.findElement(By.xpath("//div/div[@class='length']"));
			after_numberofItems = no_of_items.getText();
			System.out.println("After Number of Items : " + after_numberofItems);
			wait(1);
			if(!before_numberofItems.equals(after_numberofItems)) {
				System.out.println("Successfully the Item Number is reduced.");
			}else {
				System.out.println("Unable to reduce the Item Number.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sortbtDiscount() {
		try {
			WebElement discountselect = driver.findElement(By.xpath("//div/select"));
			discountselect.click();
			wait(2);
			WebElement discount = driver.findElement(By.xpath("//div/select/option[text()='Discount']"));
			discount.click();
			action().sendKeys(Keys.ESCAPE).build().perform();
			wait(2);
			List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class,'list__item')]//div/span[@class='price  ']"));
			List<Integer> all_sorted_price = new ArrayList<Integer>();
			for(WebElement p : price) {
				all_sorted_price.add(Integer.parseInt(p.getText().replaceAll("Rs. ", "")));
			}
			System.out.println("Sorted Discount is : " + all_sorted_price);
			wait(2);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebDriver closeChromeBrowser() {
		try {
			driver.close();
			driver.quit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public static void main(String[] args) {
		try {
			Ajio ajio = new Ajio();
			ajio.launchFirefoxBrowser();
			ajio.navigatetoAjio();
			ajio.selectWomenandBrands();
			ajio.clicktheLinkthathasMostNumberofLowerCaseCharacter();
			ajio.printandStoreNumberofItems();
			ajio.selectSizeandFitasS();
			ajio.printandStoreNumberofItems_afterselectionSizeandfit();
			ajio.sortbtDiscount();
			ajio.closeChromeBrowser();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}