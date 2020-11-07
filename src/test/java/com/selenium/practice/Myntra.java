package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
	public WebDriver driver;

	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void maximize_window() {
		driver.manage().window().maximize();
	}
	public WebDriver launchIncognitoBrowser(boolean b1) {
		try {
			WebDriverManager.chromedriver().arch32().setup();
			ChromeOptions op = new ChromeOptions();
			op.addArguments("-incognito");
			driver = new ChromeDriver(op);
			if(b1==true) {
				maximize_window();
			}
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public Dimension windowDimension() {
		Dimension window_dimension = null;
		try {
			window_dimension = driver.manage().window().getSize();
			int height = window_dimension.getHeight();
			int width = window_dimension.getWidth();
			System.out.println("The Window Dimension is     : " + window_dimension);
			System.out.println("The Height of the Window is : " + height);
			System.out.println("The Width of the Window is  : " + width);
			wait(2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return window_dimension;
	}
	public void navigatetoMyntra(boolean b1) {
		try {
			driver.get("https://myntra.com/");
			if(b1==true) {
				maximize_window();
			}
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void searchSunglasses(String s1) {
		try {
			WebElement search_sunglasses = driver.findElement(By.xpath("//div[@class='desktop-query']/input"));
			search_sunglasses.sendKeys(s1);
			wait(3);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void filterPolaroidGlass(String glass) {
		try {
			WebElement view_more = driver.findElement(By.xpath("//div/span[text()='Brand']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", view_more);
			wait(3);
			driver.findElement(By.xpath("//div[@class='brand-more']")).click();
			wait(2);
			WebElement polaroid = driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']/input"));
			polaroid.sendKeys(glass);
			wait(2);
			driver.findElement(By.xpath("//input[@value='"+glass+"']/..")).click();
			wait(2);
			driver.findElement(By.xpath("//span[contains(@class,'close')]")).click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void productSizeofMenRectangleSunglasses() {
		try {
			List<WebElement> sunglasses_product = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']//h4[@class='product-product']"));
			List<String> MRGsize = new ArrayList<String>();
			for(WebElement e : sunglasses_product) {
				MRGsize.add(e.getText());
			}
			System.out.println("The Toal Sun Glasses Name : " + MRGsize);
			List<String> men_rect_angle = new ArrayList<String>();
			List<String> sunglassSize = new ArrayList<String>();
			for(int i=0;i<MRGsize.size();i++) {
				if(MRGsize.get(i).equals("Men Rectangle Sunglasses")) {
					men_rect_angle.add(MRGsize.get(i));
				}
			}
			System.out.println("The Men Sun Glasses Name : " + men_rect_angle);
			for(int i=0;i<men_rect_angle.size();i++) {
				WebElement ele = driver.findElement(By.xpath("//h4[text()='"+men_rect_angle.get(i)+"']/../../div[@class='product-imageSliderContainer']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView", ele);
				wait(1);
				mouse_hover(ele).build().perform();
				wait(1);
				WebElement view_size = driver.findElement(By.xpath("//h4[text()='"+men_rect_angle.get(i)+"']/../h4[@class='product-sizes']/span"));
				String s1 = view_size.getText();
				sunglassSize.add(s1);
				wait(1);
			}
			System.out.println("The Men Rectangle Sunglass Size is : " + sunglassSize);
			new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Actions mouse_hover(WebElement element) {
		return new Actions(driver).moveToElement(element);
	}
	public void clickViewSimilarItemButton() {
		try {
			WebElement firstimage = driver.findElement(By.xpath("//ul/li[@class='product-base'][1]"));
			mouse_hover(firstimage).build().perform();
			wait(4);
			WebElement similar_icon = driver.findElement(By.xpath("//span[contains(@class,'similarProductsIcon')]"));
			mouse_hover(similar_icon).build().perform();
			wait(4);
			WebElement view_similar = driver.findElement(By.xpath("//div//span[text()='VIEW SIMILAR']"));
			view_similar.click();
			wait(4);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void numberofSimilarProduct() {
		try {
			List<WebElement> sizeofsimilarproduct = driver.findElements(By.xpath("//div[@class='halfcard-paddedContent']//ul/li/div"));
			System.out.println("The Number of Similar Items is : " + sizeofsimilarproduct.size());
			wait(3);
			driver.findElement(By.xpath("//div[contains(@class,'close')]/span")).click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebDriver closeBrowser() {
		try {
			driver.close();
			driver.quit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public static void main(String[] args) {
		try {
			Myntra myntra = new Myntra();
			myntra.launchIncognitoBrowser(true);
			myntra.windowDimension();
			myntra.navigatetoMyntra(false);
			myntra.searchSunglasses("Sunglasses");
			myntra.filterPolaroidGlass("Polaroid");
			myntra.productSizeofMenRectangleSunglasses();
			myntra.clickViewSimilarItemButton();
			myntra.numberofSimilarProduct();
			myntra.closeBrowser();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}