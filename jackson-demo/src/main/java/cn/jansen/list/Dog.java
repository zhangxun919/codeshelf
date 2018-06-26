package cn.jansen.list;

public class Dog extends Animal {
	
	private String home;

	public Dog() {
	}

	public Dog(String name, Integer age, String home) {
		super(name, age);
		this.home = home;
	}

	@Override
	public String toString() {
		return "Dog [home=" + home + "]";
	}
	
}
