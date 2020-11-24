package com.selenium.practice;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import java.awt.image.BufferedImage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageDownload {
	WebDriver driver;
	@BeforeTest
	public void initialize() {
		WebDriverManager.chromedriver().arch32().setup();
	}
	public void navigate(String s1) {
		try {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("-incognito");
			driver = new ChromeDriver(option);
			driver.get(s1);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@AfterTest
	public void finish() {
		driver.close();
		driver.quit();
	}
	@Test(enabled = true,priority = 1)
	public void google() throws MalformedURLException, IOException {
		navigate("https://www.google.com/");
		WebElement google = driver.findElement(By.xpath("//img[@alt='Google']"));
		String imageurl = google.getAttribute("src");
		System.out.println(imageurl);
		imagedownload(imageurl);
	}
	public BufferedImage imagedownload(String url) throws MalformedURLException, IOException {
		BufferedImage bufferedImage = ImageIO.read(new URL(URLDecoder.decode(url, "UTF-8")).openStream());
		File folder = new File(System.getProperty("user.dir")+"/Image/");
		folder.mkdir();
		File outputfile = new File(folder, new Random().nextInt(100)+".png");
		ImageIO.write(bufferedImage, "png", outputfile);
		return bufferedImage;
	}
	@Test(enabled = true,priority = 2)
	public void flipkart() throws MalformedURLException, IOException {
		String s1 = "https://www.flipkart.com/realme-narzo-20-victory-blue-128-gb/p/itm4ac58d879006d?pid=MOBFVEATJGZZNHHA&lid=LSTMOBFVEATJGZZNHHABOVSYZ&marketplace=FLIPKART&srno=s_1_1&otracker=search&otracker1=search&fm=SEARCH&iid=a723b552-2234-491e-b6c9-101f02a2019d.MOBFVEATJGZZNHHA.SEARCH&ppt=sp&ppn=sp&ssid=hhdei1epkw0000001606137524050&qH=eb4af0bf07c16429";
		navigate(s1);
		WebElement realme = driver.findElement(By.xpath("(//div/img)[1]"));
		String imgurl = realme.getAttribute("src");
		System.out.println(imgurl);
		imagedownload(imgurl);
	}
	@Test(enabled = true,priority = 3)
	public void amazon() throws MalformedURLException, IOException {
		String s1 = "https://www.amazon.in/Samsung-Galaxy-Midnight-Blue-Storage/dp/B07HGJJ559/ref=sr_1_1?dchild=1&keywords=mobile&qid=1606142835&sr=8-1";
		navigate(s1);
		WebElement samsung = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']/img"));
		String imageurl = samsung.getAttribute("src");
		System.out.println(imageurl);
		imagedownload(imageurl);
	}
	@Test(enabled = false,priority = 4)
	public void jewelleryroom() throws MalformedURLException, IOException, InterruptedException {
		String s1 = "https://thejewelleryroom.com/georg-jensen-whitegold-bangle-bracelet-in-diamonds-and-whitegold-fusion-bangle-whitegold-2-06-diamonds";
		navigate(s1);
		WebElement clickimg = driver.findElement(By.xpath("(//div[@class='glide__slides']//a/div/div)[1]"));
		clickimg.click();
		Thread.sleep(5000);
		WebElement bangle = driver.findElement(By.xpath("//div[@class='viewer-canvas']/img"));
		String imgurl = bangle.getAttribute("src");
		System.out.println(imgurl);
		imagedownload(imgurl);
		new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(5000);
	}
	@Test(enabled = true,priority = 5)
	public void ajio() throws MalformedURLException, IOException {
		String s1 = "https://www.ajio.com/nike-flex-experience-rn-9-lace-up-sports-shoes/p/460624566_blue";
		navigate(s1);
		WebElement sniker = driver.findElement(By.xpath("(//div[@class='slick-slide']/div/img)[1]"));
		String imgurl = sniker.getAttribute("src");
		System.out.println(imgurl);
		imagedownload(imgurl);
	}
}