package cn.jansen.databind;

import java.util.Map;

public class Song {
	
	private String rain;
	private String wind;
	private Map<String,Object> otherProperties;
	
	public Map<String, Object> getOtherProperties() {
		return otherProperties;
	}
	public void setOtherProperties(Map<String, Object> otherProperties) {
		this.otherProperties = otherProperties;
	}
	public String getRain() {
		return rain;
	}
	public void setRain(String rain) {
		this.rain = rain;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	@Override
	public String toString() {
		return "Song [rain=" + rain + ", wind=" + wind + ", otherProperties=" + otherProperties + "]";
	}

}
