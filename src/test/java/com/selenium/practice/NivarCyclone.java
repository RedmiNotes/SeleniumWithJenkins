package com.selenium.practice;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NivarCyclone {
	public WebDriver driver;
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public NivarCyclone launchChromeBrowser() {
		try {
			//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriverManager.chromedriver().arch32().setup();
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("-headless");
			driver = new ChromeDriver(option);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	public NivarCyclone gotoGoogleandSearchNivarTrackingLive(String search) {
		try {
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			wait(5);
			WebElement searchbox = driver.findElement(By.name("q"));
			searchbox.sendKeys(search);
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public Actions action() {
		return new Actions(driver);
	}
	public NivarCyclone chooseCycloneNivarTracingLive(String result) {
		try {
			List<WebElement> searchresult = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			wait(2);
			for(int i=1;i<searchresult.size();i++) {
				WebElement searchfilter = driver.findElement(By.xpath("(//ul[@role='listbox']/li//div[@role='option']/div[@class='sbl1']/span)["+i+"]"));
				wait(1);
				action().sendKeys(Keys.ARROW_DOWN).build().perform();
				wait(1);
				String resultvalue = searchfilter.getText();
				wait(1);
				if(resultvalue.equals(result)) {
					action().sendKeys(Keys.ENTER).build().perform();
					wait(3);
					break;
				}
			}
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public NivarCyclone selectresultforZoomEarth(String selectlink) {
		try {
			List<WebElement> searcglink = driver.findElements(By.xpath("//h3/span"));
			List<String> links = new ArrayList<String>();
			for(WebElement link : searcglink) {
				links.add(link.getText());
			}
			for(int i=0;i<links.size();i++) {
				if(links.get(i).contains(selectlink)) {
					WebElement zoomearth = driver.findElement(By.xpath("//h3/span[text()='"+links.get(i)+"']"));
					wait(2);
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", zoomearth);
					wait(2);
					action().moveToElement(zoomearth).build().perform();
					wait(2);
					zoomearth.click();
					break;
				}
			}
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public NivarCyclone presentPressureWindandType() {
		try {

			boolean liveinfo = driver.findElements(By.xpath("//article[contains(@class,'live')]")).size() != 0;
			if(liveinfo==true) {
				System.out.println("Successfully navigated to the zoom earth page.");

				String presenthighlighted = "//tr[@class='rank1 selected']";

				WebElement presentpressure = driver.findElement(By.xpath(""+presenthighlighted+"/td[@class='pressure']"));
				String pressure = presentpressure.getText();
				wait(1);

				WebElement presentwind = driver.findElement(By.xpath(""+presenthighlighted+"/td[@class='wind']"));
				String wind = presentwind.getText();
				wait(1);

				WebElement presenttype = driver.findElement(By.xpath(""+presenthighlighted+"/td[@class='type']/span"));
				String type = presenttype.getText();
				wait(1);

				System.out.println("The Present Pressure is : '" + pressure + "'");
				System.out.println("The Present Wind is     : '" + wind + "'");
				System.out.println("The Present Type is     : '" + type + "'");
			}else {
				System.out.println("Failed to navigte the zoom earth page.s");
				closeChromeBrowser();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public String forecast() {
		return "//tr[@class='rank1 forecast']";
	}
	public NivarCyclone findtheForecastedTimethatitHitsLand() {
		try {

			WebElement forecastdate = driver.findElement(By.xpath(""+forecast()+"/td[@class='date']"));
			String forecast_date = forecastdate.getText();
			wait(1);

			WebElement forecasttime = driver.findElement(By.xpath(""+forecast()+"/td[@class='time']"));
			String forecast_time = forecasttime.getText();
			wait(1);

			WebElement forecasttype = driver.findElement(By.xpath(""+forecast()+"/td[@class='type']/span"));
			String forecast_type = forecasttype.getText();
			wait(1);

			System.out.println("On '" + forecast_date + "', at the time '" + forecast_time + "' the forecast hits the land with the type of '" + forecast_type + "'" );
		}catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public NivarCyclone theEstimatedWindSpeed() {
		try {

			WebElement forecastestimatespeed = driver.findElement(By.xpath(""+forecast()+"/td[@class='wind']"));
			String estimatespeed = forecastestimatespeed.getText();
			wait(1);

			System.out.println("The forecast estimate speed is : '" + estimatespeed + "'");

		}catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public NivarCyclone closeChromeBrowser() {
		try {
			driver.close();
			driver.quit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this;
	}

	public NivarCyclone nivarcyclone(String s1,String s2,String s3) {
		return new NivarCyclone()
				.launchChromeBrowser()
				.gotoGoogleandSearchNivarTrackingLive(s1)
				.chooseCycloneNivarTracingLive(s2)
				.selectresultforZoomEarth(s3)
				.presentPressureWindandType()
				.findtheForecastedTimethatitHitsLand()
				.theEstimatedWindSpeed()
				.closeChromeBrowser();
	}

	public static void main(String[] args) {
		NivarCyclone nivar = new NivarCyclone();
		String search = "cyclone nivar";
		String searchresult ="cyclone nivar live tracking";
		String selectlink = "Zoom Earth";
		nivar.nivarcyclone(search, searchresult, selectlink);
	}
}