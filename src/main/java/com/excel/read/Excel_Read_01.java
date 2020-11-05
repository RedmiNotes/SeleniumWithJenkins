package com.excel.read;

import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_01 {

	String EXCEL_FILE_PATH = "./DataFile/testdata.xlsx";

	@SuppressWarnings("resource")
	public Map<String,String> excelreaddata(int n){

		Map<String,String> map = new HashMap<String, String>();

		try {

			FileInputStream fis = new FileInputStream(new File(EXCEL_FILE_PATH));

			XSSFWorkbook book = new XSSFWorkbook(fis);

			XSSFSheet sheet = book.getSheet("data_read_01");

			int lastcell = sheet.getRow(0).getLastCellNum();

			DataFormatter format = new DataFormatter();

			for(int i=0;i<lastcell;i++) {

				String key = sheet.getRow(0).getCell(i).toString();

				XSSFCell cell = sheet.getRow(n+1).getCell(i);

				String value = format.formatCellValue(cell);

				map.put(key, value);
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return map;
	}

	@SuppressWarnings("resource")
	public Object[][] excel_read(int n){

		Map<String,String> map = new HashMap<String, String>();

		try {

			FileInputStream fis = new FileInputStream(new File(EXCEL_FILE_PATH));

			XSSFWorkbook book = new XSSFWorkbook(fis);

			XSSFSheet sheet = book.getSheet("data_read_01");

			int lastcell = sheet.getRow(0).getLastCellNum();

			DataFormatter format = new DataFormatter();

			for(int i=0;i<lastcell;i++) {
				
				String key = sheet.getRow(0).getCell(i).toString();

				XSSFCell cell = sheet.getRow(n+1).getCell(i);

				String value = format.formatCellValue(cell);

				map.put(key, value);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Object[][] {{map}};
		
	}
}