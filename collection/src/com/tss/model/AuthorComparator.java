package com.tss.model;

import java.util.Comparator;

import com.tss.model.Book;

public class AuthorComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
	}


	
}
