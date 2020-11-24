package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TheJewelleryRoom {
	public WebDriver driver;
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchFirefoxBrowserinPrivate() {
		try {
			// System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			WebDriverManager.firefoxdriver().arch32().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--disable-notifications");
			option.addArguments("-private");
			driver = new FirefoxDriver();
			wait(2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void navigatetoTheJewelleryRoom() {
		try {
			driver.get("https://thejewelleryroom.com/");
			driver.manage().window().maximize();
			wait(8);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public JavascriptExecutor scroll_to() {
		return ((JavascriptExecutor)driver);
	}
	public void selectBanglesinCategory() {
		try {
			WebElement category = driver.findElement(By.xpath("//div/div/p[contains(text(),'categories')]"));
			scroll_to().executeScript("arguments[0].scrollIntoView(true)", category);
			wait(3);
			String bangles = "//a/div/div[contains(text(),'Bangles')]";
			boolean verifybangle = driver.findElements(By.xpath(""+bangles+"")).size() != 0;
			if(verifybangle==true) {
				WebElement selectbangale = driver.findElement(By.xpath(""+bangles+""));
				selectbangale.click();
				wait(3);
			}else {
				System.out.println("Unable to select Bangales in Category");
			}
			String url = driver.getCurrentUrl();
			String s1 = url.split("/{1,}")[3];
			if(s1.equals("bangles")) {
				System.out.println("Successfully navigated to Bangles page.");
			}else {
				System.out.println("Failed tp navigate Bangles page.");
				closePrivateFirefoxBrowser();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sortBanglesPriceHightoLow() {
		try {
			WebElement sortprice = driver.findElement(By.xpath("//div[@class='dropdown']/div/button/span[text()='Popular']"));
			sortprice.click();
			wait(3);
			WebElement hightolow = driver.findElement(By.xpath("//div[@class='dropdown-content']/a[normalize-space(text())='Price (high-low)']"));
			hightolow.click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void printandBanglesnameandPrice() {
		try {
			Map<String,String> nameandprice = new LinkedHashMap<String, String>();

			List<WebElement> banglename = driver.findElements(By.xpath("//div[@class='product-name']"));
			List<String> bangle_name = new ArrayList<String>();
			for(WebElement name : banglename) {
				bangle_name.add(name.getText().trim());
			}

			List<WebElement> bangleprice = driver.findElements(By.xpath("//span[@class='currency-dkk']"));
			List<String> bangle_price = new ArrayList<String>();
			for(WebElement price : bangleprice) {
				bangle_price.add(price.getText().trim());
			}

			for(int i=0;i<bangle_name.size();i++) {
				for(int j=i;j<bangle_price.size();) {
					nameandprice.put(bangle_name.get(i), bangle_price.get(j));
					break;
				}
			}
			System.out.println("The Bangle Name and Price is : " + nameandprice);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickFirstMatchingResult() {
		try {
			String s1 = "//div[contains(@class,'product-container')]";
			List<WebElement> allproduct = driver.findElements(By.xpath(""+s1+""));
			for(int i=1;i<allproduct.size();i++) {
				if(i==1) {
					WebElement firstproduct = driver.findElement(By.xpath("("+s1+")["+i+"]"));
					firstproduct.click();
					wait(3);
					break;
				}
			}
			wait(2);
			WebElement productdetail = driver.findElement(By.xpath("//div/h2[text()='Details about the product']"));
			if(productdetail.isDisplayed()) {
				System.out.println("Successfully selected first result");
			}else {
				System.out.println("Failed to select first result");
				closePrivateFirefoxBrowser();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	String banglename;
	String bangleprice;
	List<String> usimageurl = new ArrayList<String>();
	public void downloadImageoftheBangles() {
		try {
			List<WebElement> usimage = driver.findElements(By.xpath("//div[@class='glide__slides']//div[@class='product-image-container']/div"));
			for(int i=0;i<usimage.size();i++) {
				WebElement us_imageurl = driver.findElement(By.xpath("(//div[@class='glide__slides']//div[@class='product-image-container']/div)["+(i+1)+"]"));
				String s1 = us_imageurl.getAttribute("style");
				String s2[] = s1.split("url");
				String s3 = s2[1].replaceAll("[^A-Za-z0-9:./_-]", "");
				usimageurl.add(s3);
				wait(2);
			}
			System.out.println("The US Image URL is : " + usimageurl);
			WebElement bangle_name = driver.findElement(By.xpath("//div/h1"));
			banglename = bangle_name.getText().trim();
			WebElement bangle_price = driver.findElement(By.xpath("//div/h1//following::span/span[@class='currency-dkk']"));
			bangleprice = bangle_price.getText().trim();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickDanishFlag() {
		try {
			WebElement danishflag = driver.findElement(By.xpath("//div[@class='language-switcher flags-only']/div/a[contains(@href,'da')]"));
			danishflag.click();
			wait(10);
			WebElement productdetail = driver.findElement(By.xpath("//div/h2[text()='Detaljer om produktet']"));
			if(productdetail.isDisplayed()) {
				System.out.println("Successfully Navigated to Danish page");
			}else {
				System.out.println("Failed to select Danish flag");
				closePrivateFirefoxBrowser();
			}
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void popup() {
		boolean pop_up = driver.findElements(By.xpath("//section[@id='sleeknote-form']")).size() != 0;
		if(pop_up==true) {
			WebElement popupclose = driver.findElement(By.xpath("//div[@data-id='close-1']"));
			popupclose.click();
			wait(3);
		}
	}
	public void verifynameandprice() {
		try {
			List<String> denishimageurl = new ArrayList<String>();
			popup();
			WebElement name = driver.findElement(By.xpath("//div/h1"));
			String banglesname = name.getText().trim();
			WebElement price = driver.findElement(By.xpath("//div/h1//following::span/span[@class='currency-dkk']"));
			String banglesprice = price.getText().trim();
			if(banglesname.equals(banglename)){
				System.out.println("The Bangle name is same.");
			}else {
				System.out.println("The Bangle name is mismatching.");
			}
			if(banglesprice.equals(bangleprice)) {
				System.out.println("The price is same");
			}else {
				System.out.println("The price is mismatching");
			}
			List<WebElement> denishimage = driver.findElements(By.xpath("//a[@class='product-gallery-item']/div[@class='product-image-container']/div"));
			for(int i=0;i<denishimage.size();i++) {
				WebElement denish_imageurl = driver.findElement(By.xpath("(//a[@class='product-gallery-item']/div[@class='product-image-container']/div)["+(i+1)+"]"));
				String s1 = denish_imageurl.getAttribute("style");
				String s2[] = s1.split("url");
				String s3 = s2[1].replaceAll("[^A-Za-z0-9:./_-]", "");
				denishimageurl.add(s3);
				wait(2);
			}
			System.out.println("The Denish Image URL is : " + denishimageurl);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebDriver closePrivateFirefoxBrowser() {
		try {
			driver.quit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public static void main(String[] args) {
		TheJewelleryRoom jewelleryroom = new TheJewelleryRoom();
		jewelleryroom.launchFirefoxBrowserinPrivate();
		jewelleryroom.navigatetoTheJewelleryRoom();
		jewelleryroom.selectBanglesinCategory();
		jewelleryroom.sortBanglesPriceHightoLow();
		jewelleryroom.printandBanglesnameandPrice();
		jewelleryroom.clickFirstMatchingResult();
		jewelleryroom.downloadImageoftheBangles();
		jewelleryroom.clickDanishFlag();
		jewelleryroom.verifynameandprice();
		jewelleryroom.closePrivateFirefoxBrowser();
	}
}