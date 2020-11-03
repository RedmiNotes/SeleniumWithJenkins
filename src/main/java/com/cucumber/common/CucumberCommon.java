package com.cucumber.common;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public static Map<String, Map<String,Object>> readjson() {
		Map<String, Map<String,Object>> map = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File("./DataFile/DataJson.json");
			
			map = mapper.readValue(file, new TypeReference<Map<String, Map<String,Object>>>() {});
	
		}catch (Exception e) {
			e.getMessage();
		}
		return map;
	}
	public JavascriptExecutor scroll_to(int x,int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		return js;
	}
	public static List<Map<String,String>> readdata() {
		List<Map<String,String>> allvalue = null;
		Map<String,String> map = null;
		DataFormatter format = new DataFormatter();
		try {
			FileInputStream file = new FileInputStream(Filepath);
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheetAt(1);
			int lastrow = sheet.getLastRowNum();
			int lastcolumn  = sheet.getRow(0).getLastCellNum();

			List<String> list = new ArrayList<String>();
			for(int i=0;i<lastrow;i++) {
				Row row = sheet.getRow(0);
				Cell cell = row.getCell(i);
				String headername = format.formatCellValue(cell);
				list.add(headername.toString().trim());
			}
			allvalue = new ArrayList<Map<String,String>>();
			for(int i=1;i<=lastrow;i++) {
				Row row = sheet.getRow(i);
				map = new HashMap<String,String>();
				for(int j=0;j<lastcolumn;j++) {
					Cell cell = row.getCell(j);
					String cellvalue = format.formatCellValue(cell);
					map.put((String)list.get(j), cellvalue.toString().trim());
				}
				allvalue.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allvalue;
	}
}