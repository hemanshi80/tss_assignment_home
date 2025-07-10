package com.tss.model;

public class Movie {

	private String id ;
	private String genre;
	private int year;
	private String name;
	
	
	public Movie(String id, String genre, int year, String name) {
		super();
		this.id = id;
		this.genre = genre;
		this.year = year;
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", genre=" + genre + ", year=" + year + ", name=" + name + "]";
	}
	
	
}
