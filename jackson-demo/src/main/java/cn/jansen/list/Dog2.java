package cn.jansen.list;

public class Dog2 extends Animal2 {
	
	private String home;

	public Dog2() {
	}

	public Dog2(String name, Integer age, String home) {
		super(name, age);
		this.home = home;
	}

	@Override
	public String toString() {
		return "Dog2 [home=" + home + "]";
	}
	
}
