package cn.jansen.list;

public class Dog3 extends Animal3 {
	
	private String home;

	public Dog3() {
	}

	public Dog3(String name, Integer age, String home) {
		super(name, age);
		this.home = home;
	}

	@Override
	public String toString() {
		return "Dog3 [home=" + home + "]";
	}
	
}
