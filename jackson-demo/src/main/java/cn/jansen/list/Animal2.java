package cn.jansen.list;

public abstract class Animal2 {

	private String name;
	private Integer age;

	public Animal2() {
		super();
	}

	public Animal2(String name, Integer age) {
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
		return "Animal2 [name=" + name + ", age=" + age + "]";
	}
	
}
