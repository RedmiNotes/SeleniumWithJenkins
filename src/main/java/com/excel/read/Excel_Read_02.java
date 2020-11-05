package com.excel.read;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_02 {

	String EXCEL_FILE_PATH = "./DataFile/testdata.xlsx";

	public List<Map<String,String>> exceread(){

		List<Map<String,String>> map = new ArrayList<Map<String,String>>();

		DataFormatter format = new DataFormatter();

		try {

			FileInputStream fis = new FileInputStream(new File(EXCEL_FILE_PATH));

			XSSFWorkbook book = new XSSFWorkbook(fis);

			XSSFSheet sheet = book.getSheetAt(2);

			int lastrow = sheet.getLastRowNum();

			int lastcell = sheet.getRow(0).getLastCellNum();

			List<String> list = new ArrayList<String>();

			for(int i=0;i<lastrow;i++) {

				Row row_header = sheet.getRow(0);

				Cell cell = row_header.getCell(i);

				String header_name = format.formatCellValue(cell);

				list.add(header_name.toString().trim());

			}


			for(int i=1;i<lastrow;i++) {

				Row row_value = sheet.getRow(i);

				Map<String, String> mapvalue = new HashMap<String, String>();

				for(int j=0;j<lastcell;j++) {

					Cell cell_value = row_value.getCell(j);

					String cel_format_value = format.formatCellValue(cell_value);

					mapvalue.put((String)list.get(j), cel_format_value);

				}

				map.add(mapvalue);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	public Object[][] readdata() {
		
		List<Map<String,String>> map = new ArrayList<Map<String,String>>();
		
		DataFormatter format = new DataFormatter();

		try {
			
			FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
			
			XSSFWorkbook book = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = book.getSheetAt(2);
			
			int lastrow = sheet.getLastRowNum();
			
			int lastcell = sheet.getRow(0).getLastCellNum();
			
			List<String> list = new ArrayList<String>();
			
			for(int i=0;i<lastrow;i++) {
				
				XSSFRow row = sheet.getRow(0);
				
				XSSFCell cell = row.getCell(i);
				
				String cell_header = format.formatCellValue(cell);
				
				list.add(cell_header.trim());
				
			}
			
			for(int i=1;i<lastrow;i++) {
				
				XSSFRow row_value = sheet.getRow(i);
				
				Map<String, String> value = new HashMap<String, String>();
				
				for(int j=0;j<lastcell;j++) {
					
					XSSFCell cell_value = row_value.getCell(j);
					
					String cell_format = format.formatCellValue(cell_value);
					
					value.put((String)list.get(j), cell_format);
					
				}
				
				map.add(value);
				
			}
			
			

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Object[][] {{map}};
		
	}
}