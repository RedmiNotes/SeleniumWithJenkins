package com.excel.read;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json_Read_With_Jakson {

	String JSON_FILE_PATH = "./DataFile/DataJson.json";

	public Map<String, Map<String,Object>> readjson() {

		Map<String, Map<String,Object>> map = null;

		try {

			ObjectMapper mapper = new ObjectMapper();

			File file = new File(JSON_FILE_PATH);

			map = mapper.readValue(file, new TypeReference<Map<String, Map<String,Object>>>() {});

		}catch (Exception e) {
			e.getMessage();
		}

		return map;

	}

	public void bulkdata() {
		
		Map<String, Map<String,Object>> map = null; map = null;
		
		try {

			ObjectMapper mapper = new ObjectMapper();

			File file = new File(JSON_FILE_PATH);

			map = mapper.readValue(file, new TypeReference<Map<String, Map<String,Object>>>() {});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}