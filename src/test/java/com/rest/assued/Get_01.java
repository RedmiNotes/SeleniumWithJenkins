package com.rest.assued;

import java.util.*;
import org.json.simple.JSONObject;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get_01 {

	@Test(priority = 1,alwaysRun = true)
	public void tc_01() {
		try {
			baseURI = "http://localhost:7070";
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test(priority = 2,enabled = false)
	public void tc_02() {
		given().log().all().
		get("/gets/").
		then().assertThat().statusCode(200).log().all();
	}
	@Test(priority = 3,enabled = false)
	public void tc_03() {
		given().log().all().
		get("/gets/4").
		then().assertThat().statusCode(200).log().all();
	}
	@SuppressWarnings("unchecked")
	@Test(priority = 4,enabled = false)
	public void tc_04() {
		JSONObject map = new JSONObject(); 
		map.put("id", "5");
		map.put("name", "Gayathri");
		map.put("salary", "70000");
		map.put("gender", "Women");
		map.put("location", "Andhra");

		given().log().all().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("content-type", "application/json").
		body(map.toJSONString()).
		when().
		post("/gets/").
		then().log().all();
	}
	@SuppressWarnings("unchecked")
	@Test(priority = 5,enabled = true)
	public void tc_05() {
		JSONObject map = new JSONObject();
		
		map.put("id", "5");
		map.put("name", "Shruthy");
		map.put("salary", "90000");
		map.put("gender", "WOMen");
		map.put("location", "Kerala");
		
		given().log().all().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("content-type", "application/json").
		body(map.toJSONString()).
		when().
		put("/gets/5").
		then().log().all();
	}
}