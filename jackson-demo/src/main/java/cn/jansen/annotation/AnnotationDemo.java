package cn.jansen.annotation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AnnotationDemo {
	
	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void testJasonToBean() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		// 当需要解析的Json中属性名和需要绑定的类中的属性名称不同时，需要使用注解+构造函数的形式才能成功绑定上
		Zoo zoo = mapper.readValue(new FileReader("zoo.json"), Zoo.class);
		System.out.println(zoo);
	}
	
	@Test
	public void testJasonToBean2() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		// 当Json中有很多属性的时候，我们可以选择自己需要的属性在绑定类中建立对应属性，
		//如此，没有建立属性的值将会被忽略解析，这个在上面的测试用例中已经证实了
		
		// 但是如果我们既不想在绑定类中建立那么多属性，又不想丢失这些属性怎么办呢？
		// 我们可以使用map和@JsonAnyGetter和@JsonAnySetter来保存其它的属性
		Zoo2 zoo = mapper.readValue(new FileReader("zoo2.json"), Zoo2.class);
		System.out.println(zoo);
	}
	
	@Test
	public void testBeanToJsonWithCommAnnotation() throws JsonGenerationException, JsonMappingException, IOException {
		// 常用的几个注解：@JsonIgnoreProperties(在类级别上定义需要忽略的属性)、@JsonIgnore、@JsonFormat、@JsonInclude
		Zoo3 zoo = new Zoo3();
		zoo.setName("上海野生动物园");
		zoo.setLocation("上海市浦东新区");
		//zoo.setOfficer("张三");
		zoo.setStartDate(new Date());
		// 让控制台输出的Json数据美观
		mapper.configure(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);
		mapper.writeValue(System.out, zoo);
	}
	
	

}
