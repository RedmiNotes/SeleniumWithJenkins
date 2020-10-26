package com.utils;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static String Filepath = System.getProperty("user.dir")+"/DataFile/testdata.xlsx";

	@SuppressWarnings("resource")
	public static Object[][] excelread(int n){
		Map<String, String> map = new HashMap<String,String>();
		try {
			
			FileInputStream fis = new FileInputStream(new File(Filepath));
			
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sheet = book.getSheetAt(0);
			
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
		return new Object[][] {{map}};
	}
}