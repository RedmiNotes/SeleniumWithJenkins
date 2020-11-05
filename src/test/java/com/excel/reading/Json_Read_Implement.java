package com.excel.reading;

import java.util.*;
import org.testng.annotations.*;
import com.excel.read.Json_Read_With_Jakson;

public class Json_Read_Implement {
	
	Json_Read_With_Jakson json = new Json_Read_With_Jakson();
	Map<String, Object> map = json.readjson().get("selenium_easy");
	
	@Test(enabled = true)
	public void json_read() {
		String s1 = (String) map.get("url");
		String s2 = (String) map.get("firstname");
		String s3 = (String) map.get("lastname");
		String s4 = (String) map.get("email");
		String s5 = (String) map.get("phone");
		System.out.println("URL       : " + s1);
		System.out.println("FisrtName : " + s2);
		System.out.println("LastName  : " + s3);
		System.out.println("E-Mail    : " + s4);
		System.out.println("Phone     : " + s5);
	}
}