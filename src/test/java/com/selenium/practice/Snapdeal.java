package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	public WebDriver driver;
	Map<String, Integer> product = new LinkedHashMap<String, Integer>();
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchEdgeBrowser() {
		try {
			//System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			WebDriverManager.edgedriver().arch32().setup();
			driver = new EdgeDriver();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void navigatetoSnapdeal() {
		try {
			driver.get("https://www.snapdeal.com/");
			driver.manage().window().maximize();
			wait(10);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Actions action() {
		return new Actions(driver);
	}
	public void hoveAllOffersandClickWatches(String s1) {
		try {
			WebElement all_offers = driver.findElement(By.xpath("//li/a/span[text()='All Offers']"));
			action().moveToElement(all_offers).build().perform();
			wait(3);
			List<WebElement> product = driver.findElements(By.xpath("//div[@id='category1Data']//p/a/span[@class='linkTest']"));
			List<String> product_name = new ArrayList<String>();
			for(WebElement name : product) {
				product_name.add(name.getText().trim());
			}
			System.out.println("The Product Name is : " + product_name);
			wait(2);
			for(int i=0;i<product_name.size();i++) {
				if(product_name.get(i).equals(s1)) {
					WebElement watch = driver.findElement(By.xpath("//div[@id='category1Data']//p/a/span[text()='"+product_name.get(i)+"']"));
					watch.click();
					wait(3);
					break;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void clickIPL2020onLeftMenu() {
		try {
			String s1 = "//ul/li/a//span[text()='IPL 2020']";
			boolean ipl_2020 = driver.findElements(By.xpath(""+s1+"")).size() != 0;
			if(ipl_2020==true) {
				WebElement ipl2020 = driver.findElement(By.xpath(""+s1+""));
				ipl2020.click();
				wait(3);
			}else {
				System.out.println("--UNABLE TO CLICK 'IPL 2020' ON  LEFT MENU--");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void takeSnapofEveryWatchIndividually() {
		product.clear();
		Map<String, Integer> map1 = null;
		try {
			List<WebElement> individual_product = driver.findElements(By.xpath("//div[@id='products']//section/div"));
			for(int i=0;i<individual_product.size();i++) {
				action().moveToElement(individual_product.get(i)).build().perform();
				wait(2);
				map1 = prodnameandprice(i);
			}
			System.out.println("Every Individual Watch Name and Price is : " + map1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public Map<String, Integer> prodnameandprice(int i){
		WebElement product_name = driver.findElement(By.xpath("(//div[@id='products']//div/a/p)["+(i+1)+"]"));
		String s1 = product_name.getText();
		WebElement product_price = driver.findElement(By.xpath("(//div[@id='products']//div[@class='product-price-row clearfix']/div//span[contains(@id,'display-price')])["+(i+1)+"]"));
		String s2 = product_price.getText().replaceAll("Rs.", "").trim();
		int n = Integer.parseInt(s2);
		product.put(s1, n);
		return product;
	}
	public void nameofTrendingWatch() {
		product.clear();
		Map<String, Integer> map2 = null;
		try {
			List<WebElement> individual_product = driver.findElements(By.xpath("//div[@id='products']//section/div//div[@class='nudge-image-top-left']"));
			for(int i=0;i<individual_product.size();i++) {
				WebElement trend = driver.findElement(By.xpath("(//div[@id='products']//section/div//div[@class='nudge-image-top-left']/../a)["+(i+1)+"]"));
				action().moveToElement(trend).build().perform();
				wait(2);
				map2 = prodnameandprice(i);
			}
			System.out.println("The Trending Product Name and Price is : " + map2);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void abovetheAverageCostofAllWatches() {
		List<Integer> price = new ArrayList<Integer>();
		try {
			List<WebElement> allprice = driver.findElements(By.xpath("//div[@id='products']//div[@class='product-price-row clearfix']/div//span[contains(@id,'display-price')]"));
			for(WebElement ele : allprice) {
				price.add(Integer.parseInt(ele.getText().replaceAll("Rs.", "").trim()));
			}
			int max = price.get(0);
			int min = price.get(0);
			for(int i=0;i<price.size();i++) {
				if(max<price.get(i)) {
					max = price.get(i);
				}
				if(min>price.get(i)) {
					min = price.get(i);
				}
			}
			System.out.println("The All Watches Price      : " + price);
			System.out.println("The Maximum Watch Price is : " + max);
			System.out.println("The Minimum Watch Price is : " + min);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void clickLikeButton() {
		try {
			String s1 = "(//div[@id='products']//section/div)";
			List<WebElement> all_individual_product = driver.findElements(By.xpath(""+s1+""));
			WebElement last_watch = driver.findElement(By.xpath(""+s1+"["+(all_individual_product.size())+"]"));
			//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", last_watch);
			wait(2);
			action().moveToElement(last_watch).build().perform();
			wait(3);
			WebElement likebutton = driver.findElement(By.xpath("//div/div/span[@class='animated-icon']/i"));
			likebutton.click();
			wait(5);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void confirmLoginScreen() {
		try {
			List<WebElement> al1 = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(al1.get(0));
			wait(2);
			boolean login_screen = driver.findElements(By.xpath("//div//ul/following::div[@class='userAuth-card']")).size() != 0;
			if(login_screen==true) {
				System.out.println("Successfully Login Screen Appeared.");
			}else {
				System.out.println("Failed to Login Screen Appeare");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void closeLoginScreenandTitle() {
		try {
			WebElement closeloginscreen = driver.findElement(By.xpath("//div[@id='close-pop']/i"));
			closeloginscreen.click();
			wait(3);
			String title = driver.getTitle();
			System.out.println("The Title is : " + title);
			wait(3);
			driver.switchTo().defaultContent();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver closeEdgeBrowser() {
		try {
			driver.close();
			driver.quit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void snapdeal_watch(String sel_product) {
		try {
			launchEdgeBrowser();
			navigatetoSnapdeal();
			hoveAllOffersandClickWatches(sel_product);
			clickIPL2020onLeftMenu();
			takeSnapofEveryWatchIndividually();
			nameofTrendingWatch();
			abovetheAverageCostofAllWatches();
			clickLikeButton();
			confirmLoginScreen();
			closeLoginScreenandTitle();
			closeEdgeBrowser();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		Snapdeal snapdeal = new Snapdeal();
		snapdeal.snapdeal_watch("Watches");
		System.out.println("Success...!!!");
	}
}