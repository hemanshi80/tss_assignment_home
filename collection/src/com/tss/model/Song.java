package com.tss.model;

public class Song {

	private String title;
	private String artist;
	private double duration;
	
	
	public Song(String title, String artist, double duration) {
		super();
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}


	public String getTitle() {
		return title;
	}


	public String getArtist() {
		return artist;
	}


	public double getDuration() {
		return duration;
	}


	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", duration=" + duration + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Song)) return false;
	    Song other = (Song) obj;
	    return title.equals(other.title) && artist.equals(other.artist);
	}
	
	@Override
	public int hashCode() {
	    return title.hashCode() + artist.hashCode();
	}

	private String capitalize(String str) {
	    String[] parts = str.split(" ");
	    StringBuilder result = new StringBuilder();
	    for (String part : parts) {
	        if (!part.isEmpty())
	            result.append(Character.toUpperCase(part.charAt(0)))
	                  .append(part.substring(1)).append(" ");
	    }
	    return result.toString().trim();
	}
	
	
}
