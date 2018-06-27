package cn.jansen.mixin;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MixinDemo {

	private ObjectMapper mapper = null;
	
	@Before
	public void before() {
		mapper = new ObjectMapper();
	}
	
	@Test
	public void testMixinBeanToJson() throws JsonGenerationException, JsonMappingException, IOException {
		mapper.addMixInAnnotations(Bird.class, BirdMixin.class);
		Bird kitty= new Bird("red");
		kitty.setName("kitty");
		kitty.setCategory("small");
		kitty.setWeight("12.4");
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, kitty);
	}
	
}
