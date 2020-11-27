package com.selenium.practice;

import java.util.*;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {
	public WebDriver driver;
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
			e.printStackTrace();
		}
		return driver;
	}
	public void navigatetoLenskart() {
		try {
			driver.get("https://www.lenskart.com/");
			driver.manage().window().maximize();
			wait(4);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Actions action() {
		return new Actions(driver);
	}
	public JavascriptExecutor executor() {
		return ((JavascriptExecutor)driver);
	}
	public Lenskart mouseHoverComputerGlasses() {
		try {
			boolean notification = driver.findElements(By.xpath("//div[contains(@class,'alert ')]")).size() != 0;
			if(notification==true) {
				WebElement nothanks = driver.findElement(By.xpath("//button[contains(@class,'thanks')]"));
				nothanks.click();
				wait(3);
			}
			String india_link = "https://lenskart.com/?ref=https://www.lenskart.us";
			WebElement link = driver.findElement(By.xpath("//div[contains(@class,'country')]//a"));
			executor().executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", link, "href", india_link);
			link.click();
			wait(2);
			WebElement computerglass = driver.findElement(By.xpath("//div/a[text()='Computer Glasses']"));
			action().moveToElement(computerglass).build().perform();
			wait(2);
			WebElement men = driver.findElement(By.xpath("//div[contains(@class,'Computer Glasses')]//span[text()='men']"));
			action().moveToElement(men).build().perform();
			wait(2);
			WebElement primiumrange = driver.findElement(By.xpath("(//div[@class='category-menu_items']/span[text()='PREMIUM RANGE'])[1]"));
			action().moveToElement(primiumrange).build().perform();
			wait(2);
			primiumrange.click();
			wait(4);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Lenskart();
	}
	public Lenskart roundframeShape(String shape) {
		try {
			String frameshape = "//div[text()='FRAME SHAPE']//following::ul/li[@class='list-image']//span/span";
			List<WebElement> allframeshape = driver.findElements(By.xpath(""+frameshape+""));
			List<String> frameshapename = new ArrayList<String>();
			for(WebElement framename : allframeshape) {
				frameshapename.add(framename.getText());
			}
			System.out.println("All Frame Shape is : " + frameshapename);
			wait(2);
			for(int i=0;i<frameshapename.size();i++) {
				if(frameshapename.get(i).equals(shape)) {
					WebElement roundshap = driver.findElement(By.xpath("//div[text()='FRAME SHAPE']//following::span[text()='"+frameshapename.get(i)+"']"));
					roundshap.click();
					break;
				}
			}
			wait(5);
			boolean round = driver.findElements(By.xpath("//b[text()='Frame Shape']")).size() != 0;
			if(round==true) {
				System.out.println("Successfully Round Shape Frame selected.");
			}else {
				System.out.println("Failed to select Round Shape Frame.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Lenskart();
	}
	int highcount;String color;
	public Lenskart frameColorwithHighestCount() {
		try {
			String s1 = "//div[text()='FRAME COLOR']//following::ul/li[@class='list-checkbox']/div//span";
			List<WebElement> framecolor = driver.findElements(By.xpath(""+s1+""));
			List<String> colors = new ArrayList<String>();
			for(WebElement clrs : framecolor) {
				colors.add(clrs.getText());
			}
			List<Integer> highestcost = new ArrayList<Integer>();
			for(int i=0;i<colors.size();i++) {
				String s2 = colors.get(i).replaceAll("[^0-9]", "");
				highestcost.add(Integer.parseInt(s2));
			}
			Map<String, Integer> colorandhighestcount = new LinkedHashMap<String, Integer>();

			for(int i=0;i<(colors.size()/2 + highestcost.size()/2);i++) {
				colorandhighestcount.put(colors.get(i).replaceAll("[^A-Za-z]", ""), highestcost.get(i));
			}
			System.out.println("The Frame Color and Count is : " + colorandhighestcount);
			highcount = (Collections.max(colorandhighestcount.values()));
			for (Entry<String, Integer> entry : colorandhighestcount.entrySet()) { 
				if (entry.getValue()==highcount) {
					color = entry.getKey();
				}
			}
			wait(2);
			WebElement selectcolor = driver.findElement(By.xpath("//span[text()='"+color+"("+highcount+")']"));
			executor().executeScript("arguments[0].scrollIntoView(true)", selectcolor);
			wait(2);
			selectcolor.click();
			wait(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Lenskart();
	}
	public Lenskart verifytheCountShownintheFrame() {
		try {
			boolean frmaeclr = driver.findElements(By.xpath("//b[text()='Frame Color']")).size() != 0;
			if(frmaeclr==true) {
				System.out.println("Successfully selected color");
			}else {
				System.out.println("Failed to select color.");
			}
			WebElement result = driver.findElement(By.xpath("//div[@class='show_count']"));
			String s1 = result.getText();
			String []s2 = s1.split(" ");
			if(Integer.parseInt(s2[3])==highcount) {
				System.out.println("The showing frame count is same.");
			}else {
				System.out.println("The count is mismatching.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Lenskart();
	}
	public Lenskart framesizeCount() {
		int small = 0;
		int medium = 0;
		int large = 0;
		try {
			List<WebElement> framesize = driver.findElements(By.xpath("//*[@class='ReactVirtualized__Grid__innerScrollContainer']//div[@unbxdattr='product']"));
			for(int i=0;i<framesize.size()-1;i++) {
				WebElement product = driver.findElement(By.xpath("(//*[@class='ReactVirtualized__Grid__innerScrollContainer']//div[@unbxdattr='product'])["+(i+1)+"]"));
				action().moveToElement(product).build().perform();
				wait(2);
				WebElement prodsize = driver.findElement(By.xpath("(//p[text()='Size']/span)["+(i+1)+"]"));
				String value = prodsize.getText();
				wait(1);
				if(value.equals("Small")) {
					small++;
				}else if(value.equals("Medium")) {
					medium++;
				}else if(value.equals("Large")) {
					large++;
				}
			}
			System.out.println("Small Count is  : " + small);
			System.out.println("Medium Count is : " + medium);
			System.out.println("Large Count is  : " + large);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Lenskart();
	}
	public WebDriver closeEdgeBrowser() {
		try {
			driver.close();
			driver.quit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	public static void main(String[] args) {
		Lenskart lenskart = new Lenskart();
		lenskart.launchEdgeBrowser();
		lenskart.navigatetoLenskart();
		lenskart.mouseHoverComputerGlasses();
		lenskart.roundframeShape("Round");
		lenskart.frameColorwithHighestCount();
		lenskart.verifytheCountShownintheFrame();
		lenskart.framesizeCount();
		lenskart.closeEdgeBrowser();
	}
}