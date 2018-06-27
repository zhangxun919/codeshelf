package cn.jansen.filter;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterDemo {

	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void testFilterWhenBeanToJson() throws JsonGenerationException, JsonMappingException, IOException {
		Student jack = new Student();
		jack.setName("jack");
		jack.setAge(22);
		jack.setAddress("上海");
		mapper.writeValue(System.out, jack);
		// 无任何过滤的时候输出内容为：{"name":"jack","age":22,"address":"上海","grade":null}
		// 在Bean的类级别上加上@JsonIgnoreProperties过滤注解后输出内容为：{"name":"jack","age":22}
		// 在Bean的属性级别上加上@JsonIgnore过滤注解后的输出内容为：{"name":"jack"}
	}
	
}
