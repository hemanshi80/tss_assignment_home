package com.tss.test;
import com.tss.model.AuthorComparator;
import com.tss.model.Book;
import com.tss.model.TitleComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookTest {
	 static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		 List<Book> books = new ArrayList<>();
		 
		 while(true) {
			 
			 System.out.println("1. Add a new Book ");
			 System.out.println("2. Issue a book by id");
			 System.out.println("3. Display all available Book");
			 System.out.println("4. Display all issued books");
			 System.out.println("5. Return Book");
			 System.out.println("6. Sort Books by Author (Ascending)");
			 System.out.println("7. Sort Books by Title (Desencding)");
			 System.out.println("8. Exit!!");
			 System.out.println("Enter your choice :");
			 int choice = scanner.nextInt();
			 
			 switch(choice) {
			 
			 case 1:
			 {
				 addBook(books);
				 break;
			 }
			 
			 case 2:
			 {
				 issuedBook(books);
				 break;
			 }
			 
			 case 3:
			 {
				 displayAvailableBooks(books);
				 break;
			 }
			 case 4:
			 {
				 displayIssuedBooks(books);
				 break;
			 }
			 
			 case 5:
			 {
				 returnBook(books);
				 break;
			 }
			 case 6:
			 {
				 sortBooks(books, new AuthorComparator(), "Author (Ascending)");
				 break;
			 }
			 case 7:
			 {
				 sortBooks(books, new TitleComparator(), "Title (Descending)");
				 break;
			 }
			 case 8:
			 {
				 System.out.println("You exited !!");
				 return;
			 }
			 
			 
			 }
		 }

	}

	 public static void addBook(List<Book> books) {
			System.out.print("Enter Book Id :");
			int id = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Enter Book Title :");
			String title = scanner.nextLine();
			
			System.out.println("Enter Author Name :");
			String author = scanner.nextLine();
			
			books.add(new Book (title,id,author,false));
	 }
		
	 public static void issuedBook(List<Book> books) {
		 
		 System.out.println("Enter Book id :");
		 int id = scanner.nextInt();
		 
		 for (Book book : books) {
			 if (book.getBookId() == id && !book.isIssued()) {
	                book.setIssued(true);
	                System.out.println("Book Issued Successfully.");
	                return;
			 }
		 }
		 System.out.println("No book found or issued !");
		 
	 }
	 
	 public static void displayAvailableBooks(List<Book> books) {
	        System.out.println("Available Books:");
	        boolean found = false;
	        for (Book book : books) {
	            if (!book.isIssued()) {
	                printBook(book);
	                found = true;
	            }
	        }
	        if (!found) System.out.println("No available books.");
	    }
	 
	 public static void displayIssuedBooks(List<Book> books) {
	        System.out.println("Issued Books:");
	        boolean found = false;
	        for (Book book : books) {
	            if (book.isIssued()) {
	                printBook(book);
	                found = true;
	            }
	        }
	        if (!found) System.out.println("No issued books.");
	    }
	 
	 public static void returnBook(List<Book> books) {
	        System.out.print("Enter Book ID to return: ");
	        int id = scanner.nextInt();

	        for (Book book : books) {
	            if (book.getBookId() == id && book.isIssued()) {
	                book.setIssued(false);
	                System.out.println("Book returned successfully.");
	                return;
	            }
	        }
	        System.out.println("Book not found or was not issued.");
	    }
	 
	 private static void printBook(Book book) {
	        System.out.println("ID: " + book.getBookId()
	                + ", Title: " + book.getBookTitle()
	                + ", Author: " + book.getAuthor()
	                + ", Issued: " + (book.isIssued() ? "Yes" : "No"));
	    }
	 
	 public static void sortBooks(List<Book> books, Comparator<Book> comparator, String sortMessage) {
	        books.sort(comparator);
	        System.out.println(" Books sorted by " + sortMessage + ":");
	        for (Book book : books) {
	            printBook(book);
	        }
	    }
	}

