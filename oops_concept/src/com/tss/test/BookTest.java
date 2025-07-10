package com.tss.test;

import java.util.Scanner;

import com.tss.model.Book;

public class BookTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Book book1 = new Book();
		
		displayBookInfo(book1 , scanner);
		
	}

	public static void displayBookInfo (Book book , Scanner scanner) {
		
		
		System.out.println("Enter the book name :");
		String name = scanner.nextLine();
		book.setName(name);
		
		System.out.println("Enter book-id :");
		int bookid = scanner.nextInt();
		book.setBookid(bookid);
		
		scanner.nextLine();
		System.out.println("Enter book Author:");
		String author = scanner.nextLine();
		book.setAuthor(author);
		
		System.out.println("Enter Publication:");
		String publication = scanner.nextLine();
		book.setPublication(publication);
		
		System.out.println("Enter book price :");
		int price = scanner.nextInt();
		book.setPrice(price);
		
		book.display();
	}
}
