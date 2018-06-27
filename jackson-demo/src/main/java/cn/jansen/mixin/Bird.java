package cn.jansen.mixin;

public class Bird {
	
	private String name;
	private String category;
	private Integer age;
	private String color;
	private String weight;
	private String size;
	
	public Bird(String color) {
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Bird [name=" + name + ", category=" + category + ", age=" + age + ", color=" + color + ", weight="
				+ weight + ", size=" + size + "]";
	}
	
}
