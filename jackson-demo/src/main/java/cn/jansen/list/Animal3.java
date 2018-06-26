package cn.jansen.list;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

// 下面的注释是告知mapper在创建Json的时候，需要将类型信息一起写进去
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property="@class")
// 下面的注释是告知mapper该父类拥有的子类
@JsonSubTypes({@Type(value=Cat3.class, name="cat3"), @Type(value=Dog3.class, name="dog3")})
public abstract class Animal3 {

	private String name;
	private Integer age;

	public Animal3() {
		super();
	}

	public Animal3(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Animal3 [name=" + name + ", age=" + age + "]";
	}
	
}
