package cn.jansen.list;

public class Cat2 extends Animal2 {
	
	private String home;

	public Cat2() {
		super();
	}

	public Cat2(String name, Integer age, String home) {
		super(name, age);
		this.home = home;
	}

	@Override
	public String toString() {
		return "Cat2 [home=" + home + "]";
	}

}
