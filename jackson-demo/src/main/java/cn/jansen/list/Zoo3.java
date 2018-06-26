package cn.jansen.list;

import java.util.ArrayList;
import java.util.List;

public class Zoo3 {
	
	private String name;
	private String location;
	private List<Animal> animals = new ArrayList<Animal>();
	
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
	public List<Animal> getAnimals() {
		return animals;
	}
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
	public List<Animal> addAnimal(Animal animal){
		this.animals.add(animal);
		return this.animals;
	}
	@Override
	public String toString() {
		return "Zoo3 [name=" + name + ", location=" + location + ", animals=" + animals + "]";
	}
}
