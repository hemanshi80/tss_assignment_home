package com.tss.model;

import java.util.Comparator;

public class Book implements Comparator{

	private String bookTitle ;
	private int bookId;
	private String author;
	private boolean isIssued = false;
	
	public Book(String bookTitle, int bookId, String author, boolean isIssued) {
		super();
		this.bookTitle = bookTitle;
		this.bookId = bookId;
		this.author = author;
		this.isIssued = isIssued;
	}
	
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}


	@Override
	public int compare(Object o1, Object o2) {
		
		return 0;
	}
	
	
}
