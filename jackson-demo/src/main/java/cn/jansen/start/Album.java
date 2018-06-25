package cn.jansen.start;

import java.util.List;
import java.util.Map;

public class Album {

	private String title;
	private String description;
	private String[] links;
	private Integer[] clicks;
	private List<String> songs;
	private Artist artist;
	private Map<String,String> tools;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer[] getClicks() {
		return clicks;
	}
	public void setClicks(Integer[] clicks) {
		this.clicks = clicks;
	}
	public String[] getLinks() {
		return links;
	}
	public void setLinks(String[] links) {
		this.links = links;
	}
	public List<String> getSongs() {
		return songs;
	}
	public void setSongs(List<String> songs) {
		this.songs = songs;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Map<String, String> getTools() {
		return tools;
	}
	public void setTools(Map<String, String> tools) {
		this.tools = tools;
	}

}
