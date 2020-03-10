package com.techelevator.model;

public class Song {

	private Long id;
	private String artist;
	private String title;
	private String album;
	
	public Song(Long id, String a, String t, String al) {
		this.id = id;
		this.artist = a;
		this.title = t;
		this.album = al;
	}
	
	public Song() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
}
