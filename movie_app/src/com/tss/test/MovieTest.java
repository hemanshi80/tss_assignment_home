package com.tss.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tss.model.Movie;
import com.tss.model.MovieListEmpty;
import com.tss.model.MovieListFull;

public class MovieTest {
	
	static Scanner scanner = new Scanner(System.in);
	static List<Movie> movies = new ArrayList<>();
	static final String FILE_NAME = "movies.ser";
	static final int maxMovies = 5;
	public static void main(String[] args) {
		deserializeMovies();
		 		 
		 while(true) {
			 
			 System.out.println("1. Add Movie");
			 System.out.println("2. Delete Movie");
			 System.out.println("3. Clear All Movie");
			 System.out.println("4. Display All Movie");
			 System.out.println("5. Quit!!");
			 System.out.println("Enter your choice :");
			 int choice = scanner.nextInt();
			
			 switch(choice) {
			 
			 case 1: {
				 try {
					addMovies();
				 } catch (MovieListFull e) {
					e.printStackTrace();
				 }
				 break;
			 }
			 
			 case 2: {
				 deleteMovies();
				 break;
			 }
			 
			 case 3: {
				 clearAllMovies();
				 break;
			 }
			 
			 case 4: {
				 displayMovies();
				 break;
			 }
			 
			 case 5:{
				 serializeMovies();
				 System.out.println("Thanks for Visiting !!");
				 return;
			 }
			 
			 default : {
				 System.out.println("Invalid Choice !!");
			 }
			 }
				 
			 
		 }
	}

	private static void displayMovies() {
		
		try {
	        if (movies.isEmpty()) {
	            throw new MovieListEmpty("Movie list is empty.");
	        }
	        for (Movie m : movies) {
	            System.out.println(m);
	        }
	    } catch (MovieListEmpty e) {
	        System.out.println(e.getMessage());
	    }
	}

	private static void clearAllMovies() {
		 if (movies.isEmpty()) {
	            System.out.println("List is already empty.");
	            return;
	        }
	        movies.clear();
	        System.out.println("All movies cleared.");
		
	}

	private static void deleteMovies() {
		 try {
		        if (movies.isEmpty()) {
		            throw new MovieListEmpty("List is empty! Nothing to delete.");
		        }
		        System.out.print("Enter Movie ID to delete: ");
		        String id = scanner.nextLine().trim();

		        boolean removed = movies.removeIf(m -> m.getId().equalsIgnoreCase(id));
		        if (removed) {
		        	System.out.println("Movie with ID " + id + " deleted.");
		        } else {
		            System.out.println("Movie ID not found.");
		        }
		    } catch (MovieListEmpty e) {
		        System.out.println(e.getMessage());
		    }
	}

	private static void addMovies() throws MovieListFull {
		
		try {
		if (movies.size() == maxMovies) {
			 throw new MovieListFull("List is full! Cannot add more than 5 movies.");
		}
		
		
		System.out.print("Enter Movie Name :");
		String movieName = scanner.next();
		scanner.nextLine();
		
		System.out.println("Enter Movie Genre :");
		String genre = scanner.nextLine();
		
		System.out.println("Enter Release Year :");
		int year = scanner.nextInt();
		
		String id = generateId(movieName,  genre , year);
		
		Movie movie = new Movie(id, genre, year, movieName);
        movies.add(movie);
        
        System.out.println("ID: " + id);
        System.out.println("Movie added successfully!");
		}
		
		catch (MovieListFull e) {
	        System.out.println(e.getMessage());
	    }
	}

	private static String generateId(String movieName, String genre, int year) {
		 String id = "";
	        id += movieName.length() >= 2 ? movieName.substring(0, 2) : movieName;
	        id += genre.length() >= 2 ? genre.substring(0, 2) : genre;
	        id += String.valueOf(year).substring(2);
	        return id;
	}
	
	private static void serializeMovies() {
		System.out.println("Attempting to save movies...");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(movies);
            System.out.println("Movies saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
        }
    }
	
	@SuppressWarnings("unchecked")
	private static void deserializeMovies() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            movies = (List<Movie>) ois.readObject();
            System.out.println("Movies loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading movies: " + e.getMessage());
        }
    }
		
	}
	
	


