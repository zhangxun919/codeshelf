package cn.jansen.databind;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataBindDemo {
	
	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void testJasonToBean() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		// 当需要反序列化的Json中有未知的属性时，数据绑定会失败，下面这句可以防止这种情况
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		AlbumNew album = mapper.readValue(new FileReader("album2.json"), AlbumNew.class);
		System.out.println(album);
	}

}
