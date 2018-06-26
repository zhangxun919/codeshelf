package cn.jansen.list;

import java.util.ArrayList;
import java.util.List;

public class Zoo5 {
	
	private String name;
	private String location;
	private List<Animal3> animals = new ArrayList<Animal3>();
	
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
	public List<Animal3> getAnimals() {
		return animals;
	}
	public void setAnimals(List<Animal3> animals) {
		this.animals = animals;
	}
	public List<Animal3> addAnimal(Animal3 animal){
		this.animals.add(animal);
		return this.animals;
	}
	@Override
	public String toString() {
		return "Zoo5 [name=" + name + ", location=" + location + ", animals=" + animals + "]";
	}
}
