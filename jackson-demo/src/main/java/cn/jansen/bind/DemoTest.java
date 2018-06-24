package cn.jansen.bind;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.jansen.start.StartDemo;
import cn.jansen.start.Student;

public class DemoTest {

	private Logger log = LoggerFactory.getLogger(StartDemo.class);
	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void convertBeanToString() {
		String jsonString = null;
		Map<String,Object> paramMap = new HashMap<>();
		Student jansen = new Student("jansen",22,getDate("1999-09-01"));
		paramMap.put("student", jansen);
		int[] score = {89,90,92};
		paramMap.put("score", score);
		paramMap.put("isAdult", Boolean.TRUE);
		try {
			jsonString = mapper.writeValueAsString(paramMap);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(jsonString);
	}
	
	@Test
	public void convertStringToBean() {
		Map<String,Object> paramMap = new HashMap<>();
		String jsonString = "{\"isAdult\":true,\"score\":[89,90,92],\"student\":{\"name\":\"jansen\",\"age\":22,\"birthdate\":936115200000}}";
		try {
			paramMap = mapper.readValue(jsonString, Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Student:" + paramMap.get("student"));
		System.out.println("Score:" + paramMap.get("score"));
		System.out.println("isAdult:" + paramMap.get("isAdult"));
	}
	
	private Date getDate(String dateString) {
		Date birthdate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			birthdate = formatter.parse(dateString);
		} catch (ParseException e) {
			log.error("解析日期字符串失败");
			e.printStackTrace();
			return birthdate;
		}
		return birthdate;
	}
	
}
