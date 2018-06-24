package cn.jansen.start;

import java.util.Date;

public class Student {
	
	private String name;
	private Integer age;
	private Date birthdate;
	
	public Student() {
		super();
	}
	
	public Student(String name, Integer age, Date birthdate) {
		super();
		this.name = name;
		this.age = age;
		this.birthdate = birthdate;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", birthdate=" + birthdate + "]";
	}
}
