package cn.jansen.annotation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Zoo3 {
	
	private String name;
	@JsonIgnore
	private String location;
	@JsonFormat(pattern="yyyy-mm-dd hh:mm:ss a", locale="zh", timezone="GMT+8")
	private Date startDate;
	@JsonInclude(Include.NON_NULL)
	private String officer;
	// 用来统一保存其它的属性
	private Map<String,Object> otherProperties = new HashMap<String,Object>();
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getOfficer() {
		return officer;
	}
	public void setOfficer(String officer) {
		this.officer = officer;
	}
	public Map<String, Object> getOtherProperties() {
		return otherProperties;
	}
	public void setOtherProperties(Map<String, Object> otherProperties) {
		this.otherProperties = otherProperties;
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
