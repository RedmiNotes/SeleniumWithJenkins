package com.cucumber.common;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CucumberCommon {
	public static String Filepath = System.getProperty("user.dir")+"/DataFile/testdata.xlsx";
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void wait(int n) {
		try {
			Thread.sleep(n * (1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void startbrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	public static Map<String, String> excelread(int n){
		Map<String, String> map = new HashMap<String,String>();
		try {
			
			FileInputStream fis = new FileInputStream(new File(Filepath));
			
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheetAt(1);
			
			int lastcell = sheet.getRow(0).getLastCellNum();
			
			DataFormatter format = new DataFormatter();
			
			for(int i=0;i<lastcell;i++) {
				String key = sheet.getRow(0).getCell(i).toString();
				XSSFCell value = sheet.getRow(n+1).getCell(i);
				String valueformat = format.formatCellValue(value);
				map.put(key, valueformat);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}