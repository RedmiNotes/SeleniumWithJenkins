package com.jackson.json;

import java.io.*;
import java.util.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Json_02 {

	String filename = "./DataFile/DataJson.json";

	@SuppressWarnings("unchecked")
	@Test
	public void read_01() {
		try {

			ObjectMapper mapper = new ObjectMapper();

			File file = new File(filename);

			Map<String, Map<String, Object>> map = null;

			map = mapper.readValue(file, new TypeReference<Map<String, Map<String, Object>>>() {});

			System.out.println(map.get("Emp").get("Name"));

			Map<String, List<Object>> map1 = null;

			map1 = mapper.readValue(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map.get("Emp").get("MultipleDatas")),Map.class);

			System.out.println(map1.get("id").get(new Random().nextInt(2)));
 
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void read_02() {
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			
			File file = new File(filename);
			
			Map<String, Map<String,Object>> map = null;
			
			map = mapper.readValue(file, new TypeReference<Map<String, Map<String,Object>>>() {});
			
			System.out.println(map.get("detail").get("name"));
			
			Map<String, List<Object>> map1 = null;

			map1 = mapper.readValue(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map.get("detail")),Map.class);

			System.out.println(map1.get("names").get(new Random().nextInt(5)));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}