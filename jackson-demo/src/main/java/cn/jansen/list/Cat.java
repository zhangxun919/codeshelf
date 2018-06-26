package cn.jansen.list;

public class Cat extends Animal {
	
	private String home;

	public Cat() {
		super();
	}

	public Cat(String name, Integer age, String home) {
		super(name, age);
		this.home = home;
	}

	@Override
	public String toString() {
		return "Cat [home=" + home + "]";
	}

}
