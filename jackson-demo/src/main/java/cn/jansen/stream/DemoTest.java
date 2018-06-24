package cn.jansen.stream;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.jansen.start.Student;

public class DemoTest {
	
	private JsonFactory simpleJsonFactory = null;
	private JsonFactory complexJsonFactory = null;
	
	@Before
	public void before() {
		simpleJsonFactory = new JsonFactory();
		complexJsonFactory = new ObjectMapper().getFactory();
	}
	
	@Test
	public void writeSimpleJsonStream() {
		try {
			JsonGenerator jsonGenerator = simpleJsonFactory.createGenerator(new File("data.json"), JsonEncoding.UTF8);
			jsonGenerator.writeStartObject();
			
			jsonGenerator.writeBooleanField("isAdult", Boolean.TRUE);
			jsonGenerator.writeStringField("school", "交大附属一中");
			jsonGenerator.writeNumberField("age", 99);
			
			jsonGenerator.writeEndObject(); 
			jsonGenerator.flush();  
	        jsonGenerator.close();   
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeComplexJsonStream() {
		Student jansen = new Student("jansen",22,new Date());
		try {
			JsonGenerator jsonGenerator = complexJsonFactory.createGenerator(new File("data2.json"), JsonEncoding.UTF8);
			jsonGenerator.writeStartObject();
			
			jsonGenerator.writeBooleanField("isAdult", Boolean.TRUE);
			jsonGenerator.writeStringField("school", "交大附属一中");
			jsonGenerator.writeNumberField("age", 99);
			
			jsonGenerator.writeObjectField("student", jansen);
			jsonGenerator.writeObjectField("score", new int[] {90,91,99});
			
			jsonGenerator.writeEndObject(); 
			jsonGenerator.flush();  
	        jsonGenerator.close();   
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void readJsonStream() {
		JsonParser jsonParser = null;
		try {
			jsonParser = simpleJsonFactory.createParser(new File("data2.json"));
			while(!jsonParser.isClosed()) {
				JsonToken token = jsonParser.nextToken();
				if(token == null) {
					break;
				}
				if("isAdult".equals(jsonParser.getCurrentName())) {
					System.out.println(jsonParser.getText());
					jsonParser.nextToken();
					System.out.println(jsonParser.getText());
				}
				if("school".equals(jsonParser.getCurrentName())) {
					System.out.println(jsonParser.getText());
					jsonParser.nextToken();
					System.out.println(jsonParser.getText());
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
