package com.selenium.practice;

import java.text.*;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BankBazaar {
	public WebDriver driver;
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebDriver launchBrowser(String s1) {
		try {
			switch(s1) {
			case "chrome":
				//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				WebDriverManager.chromedriver().arch32().setup();
				ChromeOptions option1 = new ChromeOptions();
				option1.addArguments("--disable-notifications");
				driver = new ChromeDriver(option1);
				break;
			case "firefox":
				//System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				WebDriverManager.firefoxdriver().arch32().setup();
				FirefoxOptions option2 = new FirefoxOptions();
				option2.addArguments("--disable-notifications");
				driver = new FirefoxDriver(option2);
				break;
			case "edge":
				//System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
				WebDriverManager.edgedriver().arch32().setup();
				EdgeOptions option3 = new EdgeOptions();
				option3.setCapability("--disable-notifications", true);
				driver = new EdgeDriver(option3);
				break;
			case "ie":
				//System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
				WebDriverManager.iedriver().arch32().setup();
				InternetExplorerOptions option4 = new InternetExplorerOptions();
				option4.addCommandSwitches("--disable-notifications");
				driver = new InternetExplorerDriver(option4);
				break;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
	public void navigatetoBankbazaar() {
		try {
			driver.get("http://bankbazaar.com/personal-loan.html");
			driver.manage().window().maximize();
			wait(15);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Actions action() {
		return new Actions(driver);
	}
	public void chooseSalaryinEmployment() {
		try {
			if((driver.findElements(By.xpath("//div/span[text()='Type of employment']")).size() != 0)==true) {
				WebElement salary_emp = driver.findElement(By.xpath("//label/span[text()='Salaried']/..//span[4]"));
				action().moveToElement(salary_emp).build().perform();
				wait(3);
				salary_emp.click();
				wait(3);
			}else if((driver.findElements(By.xpath("//span[text()='Loading your search...']")).size() !=0) == true){
				closeBrowser();
				System.out.println("Unable to Select Salary in Type of Employment");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void selectCompanynmeasInfosys(String companyname) {
		try {
			WebElement search = driver.findElement(By.xpath("//div[@class='Select-input']/input"));
			search.sendKeys(companyname);
			wait(3);
			for(int i=1;i<=10;i++) {
				action().sendKeys(Keys.ARROW_DOWN).build().perform();
				wait(2);
				if(i==2) {
					action().sendKeys(Keys.ENTER).build().perform();
					wait(2);
					break;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void selectMidoftheSalaryScale() {
		try {
			WebElement salary = driver.findElement(By.xpath("//div[@class='rangeslider rangeslider-horizontal']"));
			String s1 = salary.getAttribute("aria-valuemax");
			int maxsal = Integer.parseInt(s1);
			int max = maxsal/2;
			DecimalFormat df = new DecimalFormat("##,##,##0");
			String maximum_salary = df.format(max);
			wait(3);
			WebElement enter_salary = driver.findElement(By.xpath("//div/input[@name='netMonthlyIncome']"));
			enter_salary.sendKeys(String.valueOf(max));
			wait(3);
			WebElement selected_salary = driver.findElement(By.xpath("//div[@class='rangeslider__handle']/div/span"));
			String sal = selected_salary.getText();
			if(maximum_salary.equals(sal)) {
				System.out.println("Successfully Selected Mid range Salary");
			}else {
				System.out.println("Failed to select Mid range Salary");
			}
			clickContinueorSubmit().click();
			wait(4);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public WebElement clickContinueorSubmit() {
		return driver.findElement(By.xpath("//div/span/a"));
	}
	public void enterPincode(String code) {
		try {
			WebElement pincode = driver.findElement(By.xpath("//input[@autocomplete='postal-code']"));
			pincode.sendKeys(code);
			wait(3);
			clickContinueorSubmit().click();
			wait(4);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void confirmMobileNumberScreen() {
		try {
			String s1 = "//div[contains(@class,'ContactInfo_phoneNumber') and //span[text()='Provide your mobile number']]";
			boolean mobilenoscreen = driver.findElements(By.xpath(""+s1+"")).size() != 0;
			if(mobilenoscreen==true) {
				System.out.println("Mobile Number Screen is displayed.!");
			}else {
				closeBrowser();
				System.out.println("Mobile Number Screen is not displayed.!");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String wrongmobilenumber() {
		String num = "0123456789";
		String wrong_no = "";
		char ch[] = num.toCharArray();
		for(int i=0;i<=5;i++) {
			wrong_no += ch[new Random().nextInt(ch.length)];
		}
		return wrong_no;
	}
	public void enterWrongPhoneNumber() {
		try{
			String number = "0431"+wrongmobilenumber();
			WebElement mobile_number = driver.findElement(By.xpath("//div/input[@name='mobileNumber']"));
			mobile_number.sendKeys(number);
			wait(4);
			clickContinueorSubmit().click();
			wait(3);
			String s1 = "//div[contains(@class,'errorContainer')]//span//span[@class='errorMessage']";
			WebElement error_message = driver.findElement(By.xpath(""+s1+""));
			if(error_message.isDisplayed()) {
				String ErrorMSG = error_message.getText();
				System.out.println("The Error Message is : '" + ErrorMSG + "'");
				wait(3);
			}else {
				closeBrowser();
				System.out.println("Error Message has not displayed.");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
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
	public void Bank_Bazaar(String browser,String companyname,String pincode) {
		launchBrowser(browser);
		navigatetoBankbazaar();
		chooseSalaryinEmployment();
		selectCompanynmeasInfosys(companyname);
		selectMidoftheSalaryScale();
		enterPincode(pincode);
		confirmMobileNumberScreen();
		enterWrongPhoneNumber();
		closeBrowser();
	}
	
	
	public static void main(String[] args) {
		BankBazaar bankbazaar = new BankBazaar();
		String browser = "chrome";
		String company_name = "INFOSYS";
		String code = "600001";
		bankbazaar.Bank_Bazaar(browser, company_name, code);
	}
}