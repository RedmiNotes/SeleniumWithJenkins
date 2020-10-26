package com.selenium.projectspecify;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.*;
import com.selenium.common.SeleniumCommon;
import com.utils.ExcelRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecify  {
	
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public String desc;
	public static int n;
	
	@DataProvider(name = "datas")
	public Object[][] datas() {
		return ExcelRead.excelread(n);
	}

	@BeforeSuite(alwaysRun = true)
	public void reportgen() {
		String path = System.getProperty("user.dir")+"/htmlreport/";
		File file = new File(path);
		File[] f1 = file.listFiles();
		for(int i=0;i<f1.length;i++) {
			File f3 = new File(f1[i].getAbsolutePath());
			File f4[] = f3.listFiles();
			for(int j=0;j<f4.length;j++) {
				f4[j].delete();
			}
			f3.delete();
		}
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH mm ss aa");
		String s1 = path + sdf.format(d);
		File f2 = new File(s1);
		if(!f2.exists()) {
			f2.mkdir();
		}else {
			System.out.println("File Already Present..!!");
		}
		report = new ExtentReports(f2+"/"+sdf.format(d)+".html",true,DisplayOrder.NEWEST_FIRST);
	}
	@BeforeMethod
	public void startreport(ITestResult method) {
		test = report.startTest(method.getMethod().getMethodName(), desc);
	}
	@AfterMethod
	public void endreport() {
		report.endTest(test);
	}
	@AfterSuite
	public void flushreport() {
		report.flush();
	}
	public WebDriver startbrowser(String browser,String s1) {
		try {
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/Driver/IEServerDriver.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			WebDriverManager.chromedriver().arch32().setup();
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.get(new SeleniumCommon(driver).prodatas().getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		new SeleniumCommon(driver).selectWebpage(s1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}
}