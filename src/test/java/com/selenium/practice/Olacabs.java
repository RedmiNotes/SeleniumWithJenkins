package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Olacabs {
	public WebDriver driver;
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchChromeBrowser() {
		try {
			//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriverManager.chromedriver().arch32().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public void navigatetoOlacab() {
		try {
			driver.get("https://www.olacabs.com/");
			driver.manage().window().setSize(new Dimension(800, 1280));
			wait(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Actions action() {
		return new Actions(driver);
	}
	public void clickOutstation() {
		try {
			WebElement outstation = driver.findElement(By.xpath("//div/a[text()='Outstation']"));
			action().click(outstation).build().perform();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void switchtoFrame() {
		try {
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(frames.get(0));
			wait(2);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void pickupanddropLocation(String s1,String s2,String s3) {
		try {
			WebElement pickupanddrop = driver.findElement(By.xpath(""+s2+""));
			pickupanddrop.click();
			wait(2);
			action().sendKeys(s1).build().perform();
			wait(3);
			List<WebElement> selectoptionofpickupanddrop = driver.findElements(By.xpath(""+s3+""));
			for(int i=1;i<selectoptionofpickupanddrop.size();i++) {
				if(i==1) {
					WebElement firstoption = driver.findElement(By.xpath(""+s3+"["+i+"]"));
					action().moveToElement(firstoption).build().perform();
					wait(1);
					firstoption.click();
					wait(3);
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	String s3 = "//div/div[@class='row results ola-ripple ptr']";
	public void pickupLocation(String pick_up) {
		try {
			switchtoFrame();
			String s2 = "//div//div[text()='Current location']";
			pickupanddropLocation(pick_up,s2,s3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void dropLocation(String drop) {
		try {
			String s2 = "//div//div[contains(text(),'destination')]";
			pickupanddropLocation(drop,s2,s3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void searchOutStationCabs() {
		try {
			WebElement outstationcab = driver.findElement(By.xpath("//button/span"));
			outstationcab.click();
			wait(5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebElement expandRootElement(WebElement element) {
		return (WebElement) ((JavascriptExecutor)driver)
				.executeScript("return arguments[0].shadowRoot", element);
	}
	public WebElement shadowroot() {
		WebElement root1 = driver.findElement(By.tagName("ola-app"));
		WebElement shadowRoot1 = expandRootElement(root1);
		WebElement root2 = shadowRoot1.findElement(By.cssSelector("ola-home"));
		WebElement shadowRoot2 = expandRootElement(root2);
		WebElement root3 = shadowRoot2.findElement(By.cssSelector("ola-home-outstation"));
		WebElement shadowRoot3 = expandRootElement(root3);
		WebElement root4 = shadowRoot3.findElement(By.cssSelector("ola-cabs-outstation"));
		WebElement shadowRoot4 = expandRootElement(root4);
		return shadowRoot4;
	}
	public void carTypeandaboveAveragePrice() {
		try {
			List<String> tab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab.get(1));
			wait(3);
			List<WebElement> allcarname = shadowroot().findElements(By.cssSelector("div[class='text value cab-name']"));
			List<String> carname = new ArrayList<String>();
			for(WebElement name : allcarname) {
				carname.add(name.getText().replaceAll("[^A-Za-z ]", "").trim());
			}
			wait(2);
			System.out.println("The Car Name is          : "  + carname);
			List<WebElement> allcar = shadowroot().findElements(By.cssSelector("span[class='text value price']>span"));
			List<String> price = new ArrayList<String>();
			for(WebElement money : allcar) {
				price.add(money.getText().replaceAll("₹", ""));
			}
			System.out.println("The Out Station Price is : " + price);
			wait(2);
			String s1 = "";
			for(int i=0;i<carname.size();i++) {
				if(carname.get(i).contains("Sedan")) {
					s1 += i;
				}
			}
			int n = Integer.parseInt(s1);
			WebElement sedan = shadowroot().findElements(By.cssSelector("div[class='row cab-row ptr ola-ripple available-true']")).get(n);
			sedan.click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebElement clickContinue() {
		WebElement root1 = driver.findElement(By.tagName("ola-app"));
		WebElement shadowRoot1 = expandRootElement(root1);
		WebElement root2 = shadowRoot1.findElement(By.cssSelector("ola-modal"));
		WebElement shadowRoot2 = expandRootElement(root2);
		WebElement root3 = shadowRoot2.findElement(By.cssSelector("ola-confirm-ride-outstation"));
		WebElement shadowRoot3 = expandRootElement(root3);
		return shadowRoot3;
	}
	public WebElement olaLogin() {
		WebElement root1 = driver.findElement(By.tagName("ola-app"));
		WebElement shadowRoot1 = expandRootElement(root1);
		WebElement root2 = shadowRoot1.findElement(By.cssSelector("ola-modal"));
		WebElement shadowRoot2 = expandRootElement(root2);
		return shadowRoot2;
	}
	public void clickContinueandVerifyPhonePage() {
		try {
			WebElement continue_click = clickContinue().findElement(By.cssSelector("button[class='nxt-btn-active ola-ripple']"));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", continue_click);
			continue_click.click();
			wait(3);
			WebElement phonetext = olaLogin().findElement(By.cssSelector("button[class='nxt-btn-active ola-ripple']"));
			String s1 = phonetext.getText().trim();
			if(s1.equals("")) {
				System.out.println("Successfully Navigaed to Phone Number Page.");
			}else {
				System.out.println("Failed to Navigate Phone Number Page.");
			}
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
		Olacabs olacab = new Olacabs();
		olacab.launchChromeBrowser();
		olacab.navigatetoOlacab();
		olacab.clickOutstation();
		olacab.pickupLocation("Chennai One");
		olacab.dropLocation("Bangalore");
		olacab.searchOutStationCabs();
		olacab.carTypeandaboveAveragePrice();
		olacab.clickContinueandVerifyPhonePage();
		olacab.closeChromeBrowser();
	}
}