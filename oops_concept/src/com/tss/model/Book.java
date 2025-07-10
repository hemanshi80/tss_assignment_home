package com.tss.model;

public class Book {

	private int bookid, price;
	private String bookName, author, publication;

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	

	public int getBookid() {
		return bookid;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublication() {
		return publication;
	}
	
	
	public void display()
	{
		System.out.println("Book Name :"+ bookName);
		System.out.println("Book-id :"+ bookid);
		System.out.println("Author :"+ author);
		System.out.println("Publication :"+ publication);
		System.out.println("Price :"+ price);
		discount(price);
		
	}
	
	public void discount(int price) {
		double discount = price * 0.9;
		System.out.println("The discounted (10%) price of book is : " + discount);
	}

}
