package com.excel.reading;

import java.util.*;
import org.testng.annotations.*;

import com.excel.read.Excel_Read_01;

public class Excel_Read_Implement_01 extends Excel_Read_01 {
	
	Map<String,String> map = new Excel_Read_01().excelreaddata(new Random().nextInt(5));
	
	@DataProvider(name = "readdata")
	public Object[][] readdata(){
		return new Excel_Read_01().excel_read(new Random().nextInt(5));
	}
	
	@Test(enabled = true)
	public void excel_read_1() {
		String s1 = map.get("FIRSTNAME");
		String s2 = map.get("LASTNAME");
		String s3 = map.get("LOCATION");
		String s4 = map.get("EMAIL");
		String s5 = map.get("PHONENO");
		System.out.println("FirstName : " + s1);
		System.out.println("LastName  : " + s2);
		System.out.println("Location  : " + s3);
		System.out.println("Email     : " + s4);
		System.out.println("PhoneNo   : " + s5);
	}
	
	@Test(alwaysRun = true,dependsOnMethods = "excel_read_1")
	public void one() {
		System.out.println("-----------------------------------------------");
	}
	
	@Test(enabled = true,dataProvider = "readdata",dependsOnMethods = "one")
	public void excel_read_2(Map<String,String> map1) {
		String s1 = map1.get("FIRSTNAME");
		String s2 = map1.get("LASTNAME");
		String s3 = map1.get("LOCATION");
		String s4 = map1.get("EMAIL");
		String s5 = map1.get("PHONENO");
		System.out.println("FirstName : " + s1);
		System.out.println("LastName  : " + s2);
		System.out.println("Location  : " + s3);
		System.out.println("Email     : " + s4);
		System.out.println("PhoneNo   : " + s5);
	}
	
}