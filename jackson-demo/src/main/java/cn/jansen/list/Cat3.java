package cn.jansen.list;

public class Cat3 extends Animal3 {
	
	private String home;

	public Cat3() {
		super();
	}

	public Cat3(String name, Integer age, String home) {
		super(name, age);
		this.home = home;
	}

	@Override
	public String toString() {
		return "Cat3 [home=" + home + "]";
	}

}
