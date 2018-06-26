package cn.jansen.list;

import java.util.ArrayList;
import java.util.List;

public class Zoo4 {
	
	private String name;
	private String location;
	private List<Animal2> animals = new ArrayList<Animal2>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Animal2> getAnimals() {
		return animals;
	}
	public void setAnimals(List<Animal2> animals) {
		this.animals = animals;
	}
	public List<Animal2> addAnimal(Animal2 animal){
		this.animals.add(animal);
		return this.animals;
	}
	@Override
	public String toString() {
		return "Zoo4 [name=" + name + ", location=" + location + ", animals=" + animals + "]";
	}
}
