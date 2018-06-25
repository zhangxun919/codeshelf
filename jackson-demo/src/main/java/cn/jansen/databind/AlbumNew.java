package cn.jansen.databind;

import java.util.Arrays;

public class AlbumNew {
	
	private String title;
	private Song[] songs;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Song[] getSongs() {
		return songs;
	}
	public void setSongs(Song[] songs) {
		this.songs = songs;
	}
	
	@Override
	public String toString() {
		return "AlbumNew [title=" + title + ", songs=" + Arrays.toString(songs) + "]";
	}
	
}
