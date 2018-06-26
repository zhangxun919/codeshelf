package cn.jansen.annotation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Zoo {
	
	private String name;
	private String location;
	
	public Zoo() {
		super();
	}
	
	@JsonCreator
	public Zoo(@JsonProperty("zooName") String name, @JsonProperty("zooLocation") String location) {
		super();
		this.name = name;
		this.location = location;
	}
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
	@Override
	public String toString() {
		return "Zoo [name=" + name + ", location=" + location + "]";
	}
}
