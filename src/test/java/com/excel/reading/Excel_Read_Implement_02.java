package com.excel.reading;

import java.util.*;
import org.testng.annotations.*;
import com.excel.read.Excel_Read_02;

public class Excel_Read_Implement_02 extends Excel_Read_02 {
	
	List<Map<String,String>> map = new Excel_Read_02().exceread();
	
	@DataProvider(name = "readdata")
	public Object[][] readdata(){
		return new Excel_Read_02().readdata();
	}
	
	@Test(enabled = true)
	public void excel_read_1() {
		int n = new Random().nextInt((5-1));
		String s1 = map.get(n).get("FIRSTNAME");
		String s2 = map.get(n).get("LASTNAME");
		String s3 = map.get(n).get("LOCATION");
		String s4 = map.get(n).get("EMAIL");
		String s5 = map.get(n).get("PHONENO");
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
	public void excel_read_2(List<Map<String,String>> map1) {
		int n = new Random().nextInt((5-1));
		String s1 = map1.get(n).get("FIRSTNAME");
		String s2 = map1.get(n).get("LASTNAME");
		String s3 = map1.get(n).get("LOCATION");
		String s4 = map1.get(n).get("EMAIL");
		String s5 = map1.get(n).get("PHONENO");
		System.out.println("FirstName : " + s1);
		System.out.println("LastName  : " + s2);
		System.out.println("Location  : " + s3);
		System.out.println("Email     : " + s4);
		System.out.println("PhoneNo   : " + s5);
	}

}
