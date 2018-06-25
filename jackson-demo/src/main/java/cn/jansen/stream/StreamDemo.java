package cn.jansen.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class StreamDemo {
	
	private JsonFactory jsonFactory = null;
	
	@Before
	public void before() {
		jsonFactory = new JsonFactory();
	}
	
	@Test
	public void testSteamToJson() throws IOException {
		JsonGenerator generator = jsonFactory.createGenerator(new FileWriter("album.json"));
		
		// “{”被视为第一个开始对象，下面这行语句就是表示写入“{”
		generator.writeStartObject();
		
		generator.writeFieldName("title");
		generator.writeString("寂静的春天");
		
		generator.writeFieldName("songs");
		// 相当于写入“[”
		generator.writeStartArray();
		generator.writeStartObject();
		generator.writeStringField("rain", "冰雨");
		generator.writeStringField("wind", "等风来");
		generator.writeEndObject();
		// 相当于写入“]”
		generator.writeEndArray();
		
		// 相当于写入“}”
		generator.writeEndObject();
		generator.close();
		// 执行结果如下：
		// {"title":"寂静的春天","songs":[{"rain":"冰雨","wind":"等风来"}]}
	}
	
	@Test
	public void testJsonToStream () throws JsonParseException, FileNotFoundException, IOException {
		JsonParser parser = jsonFactory.createParser(new FileReader("album.json"));
		while(!parser.isClosed()) {
			JsonToken token = parser.nextToken();
			// 最后一个token将退出程序
			if(token == null) {
				break;
			}
			// 寻找到“songs”对应的key
			if(JsonToken.FIELD_NAME.equals(token) && "songs".equals(parser.getCurrentName())) {
				// 获取“songs”对应的值的第一个token
				token = parser.nextToken();
				// 该值应该以数组的“[”开头
				if(!JsonToken.START_ARRAY.equals(token)) {
					break;
				}
				// 获取“songs”对应的值的第二个token
				token = parser.nextToken();
				// 该值应该以对象的“{”开头
				if(!JsonToken.START_OBJECT.equals(token)) {
					break;
				}
				// 当前“songs”的值遍历完就结束循环
				while(true) {
					token = parser.nextToken();
					// 退出while-ture的条件
					if(token == null) {
						break;
					}
					// 找到“rain”对应的值
					if(JsonToken.FIELD_NAME.equals(token) && "wind".equals(parser.getCurrentName())) {
						// 找到“rain”对应的值并将其打印出来
						token = parser.nextToken();
						System.out.println(parser.getText());
					}
				}
			}
		}
	}

}
