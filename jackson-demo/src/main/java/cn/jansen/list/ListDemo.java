package cn.jansen.list;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListDemo {

	private ObjectMapper mapper = null;

	@Before
	public void before() {
		mapper = new ObjectMapper();
	}

	// 当Bean中的list包含的是具体的类时序列化和反序列化案例
	@Test
	public void testBeanToJson() throws JsonGenerationException, JsonMappingException, IOException {
		Animal animal1 = new Animal("tom", 6);
		Animal animal2 = new Animal("zolo", 4);
		Zoo3 zoo = new Zoo3();
		zoo.setName("上海野生动物园");
		zoo.setLocation("上海市浦东新区");
		zoo.addAnimal(animal1).add(animal2);
		mapper.writeValue(new FileWriter("zoo3.json"), zoo);
		
		Zoo3 targetZoo = new Zoo3();
		targetZoo = mapper.readValue(new FileReader("zoo3.json"), Zoo3.class);
		System.out.println(targetZoo);
	}
	
	// 当Bean中的list包含的对象是具体的子类的时候序列化和反序列化的案例
	// 可以看到其序列化的时候只能按照Bean中list包含的对象进行序列化，子类扩展的属性是无法序列化的
	@Test
	public void testBeanToJson2() throws JsonGenerationException, JsonMappingException, IOException {
		Cat tom = new Cat("tom", 6, "UK");
		Dog zolo = new Dog("zolo", 4, "Canada");
		Zoo3 zoo = new Zoo3();
		zoo.setName("上海野生动物园");
		zoo.setLocation("上海市浦东新区");
		zoo.addAnimal(tom).add(zolo);
		mapper.writeValue(new FileWriter("zoo3.json"), zoo);
		
		Zoo3 targetZoo = new Zoo3();
		targetZoo = mapper.readValue(new FileReader("zoo3.json"), Zoo3.class);
		System.out.println(targetZoo);
	}
	
	// 当Bean中的list包含的对象是抽象的父类的时候序列化和反序列化的案例
	// 和上面的测试用例一样，在序列化的时候照样不能序列化子类的扩展属性，但是反序列化的时候报错，不能反序列化绑定到一个抽象的类
	@Test
	public void testBeanToJson3() throws JsonGenerationException, JsonMappingException, IOException {
		Cat2 tom2 = new Cat2("tom", 6, "UK");
		Dog2 zolo2 = new Dog2("zolo", 4, "Canada");
		Zoo4 zoo = new Zoo4();
		zoo.setName("上海野生动物园");
		zoo.setLocation("上海市浦东新区");
		zoo.addAnimal(tom2).add(zolo2);
		mapper.writeValue(new FileWriter("zoo3.json"), zoo);
		
		// ERROR
		Zoo4 targetZoo = new Zoo4();
		targetZoo = mapper.readValue(new FileReader("zoo3.json"), Zoo4.class);
		System.out.println(targetZoo);
	}
	
	// 当Bean中的list包含的对象是抽象的父类的时候序列化和反序列化的案例
	// 和上面的测试用例一样，在序列化的时候照样不能序列化子类的扩展属性，但是反序列化的时候报错，不能反序列化绑定到一个抽象的类
	// 为了解决这个问题，我们在抽象父类中加上注解，问题就得到了解决
	@Test
	public void testBeanToJson4() throws JsonGenerationException, JsonMappingException, IOException {
		Cat3 tom3 = new Cat3("tom", 6, "UK");
		Dog3 zolo3 = new Dog3("zolo", 4, "Canada");
		Zoo5 zoo = new Zoo5();
		zoo.setName("上海野生动物园");
		zoo.setLocation("上海市浦东新区");
		zoo.addAnimal(tom3).add(zolo3);
		mapper.writeValue(new FileWriter("zoo3.json"), zoo);
		
		Zoo5 targetZoo = new Zoo5();
		targetZoo = mapper.readValue(new FileReader("zoo3.json"), Zoo5.class);
		System.out.println(targetZoo);
	}
	
	// 直接序列化和反序列化list
	@Test
	public void testBeanToJson5() throws JsonGenerationException, JsonMappingException, IOException {
		List<Animal3> animalList = new ArrayList<Animal3>();
		Cat3 tom3 = new Cat3("tom", 6, "UK");
		Dog3 zolo3 = new Dog3("zolo", 4, "Canada");
		animalList.add(tom3);
		animalList.add(zolo3);
		// 虽然抽象父类上有注解，但是还是没有list中包含对象的类的信息
		//mapper.writeValue(System.out, animalList);
		// 使用下面的方法将输出类的信息
		//mapper.writerWithType(new TypeReference<List<Animal3>>() {}).writeValue(System.out, animalList);
		
		String targetJson = "[{\"@class\":\"cn.jansen.list.Cat3\",\"name\":\"tom\",\"age\":6},{\"@class\":\"cn.jansen.list.Dog3\",\"name\":\"zolo\",\"age\":4}]";
		List<Animal3> targetAnimalList = new ArrayList<Animal3>();
		targetAnimalList = mapper.readValue(targetJson, List.class);
		System.out.println(targetAnimalList);
	}
	
}
