package cn.jansen.start;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StartDemo {
	
	private Logger log = LoggerFactory.getLogger(StartDemo.class);
	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void convertBeanToString() {
		String jsonString = null;
		Date birthDate = this.getDate("1999-09-01");
		Student jansen = new Student("jansen",22,birthDate);
		try {
			jsonString= mapper.writeValueAsString(jansen);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonString);
	}
	
	@Test
	public void convertStringToBean() {
		Student jansen = null;
		String jsonString = "{\"name\":\"jansen\",\"age\":22,\"birthdate\":936115200000}";
		try {
			jansen = mapper.readValue(jsonString, Student.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(jansen);
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
