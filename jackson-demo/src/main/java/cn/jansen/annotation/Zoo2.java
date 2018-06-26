package cn.jansen.annotation;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Zoo2 {
	
	private String name;
	private String location;
	// 用来统一保存其它的属性
	private Map<String,Object> otherProperties = new HashMap<String,Object>();
	
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
	
	public Object get(String name) {
		return otherProperties.get(name);
	}
	
	@JsonAnyGetter
	public Map<String, Object> any() {
		return otherProperties;
	}
	
	@JsonAnySetter
	public void set(String name, Object value) {
		otherProperties.put(name, value);
	}
	
	@Override
	public String toString() {
		return "Zoo2 [name=" + name + ", location=" + location + ", otherProperties=" + otherProperties + "]";
	}
	
}
