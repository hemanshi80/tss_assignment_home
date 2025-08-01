package com.tss.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.tss.model.Song;

public class SongTest {

	 static private List<Song> playlist = new ArrayList<>();
	static private Scanner scanner = new Scanner(System.in);
	 
	public static void main(String[] args) {
		
		SongTest manager = new SongTest();
		
		while(true) {
			    System.out.println("1. Add Song");
			    System.out.println("2. Remove Song");
			    System.out.println("3. Search Song by Title");
			    System.out.println("4. Display All Songs");
			    System.out.println("5. Shuffle Playlist");
			    System.out.println("0. Exit");
			    System.out.println("Enter Your Choice :");
			    int choice = scanner.nextInt();
			    
			    switch(choice) {
			    
			    case 1: {
			    	addSong();
			    	break;
			    }
			    
			    case 2:{
			    	removeSong() ;
			    	break;
			    }
			    
			    case 3: {
			    	searchSong();
			    	break;
			    	
			    }
			    
			    case 4:{
			    	displaySongs();
			    	break;
			    }
			    
			    case 5:{
			    	shuffleSongs();
			    	break;
			    }
			    
			    case 6:{
			    	
			    	System.out.println("Thanks for Listening !!");
			    	return;
			    }
			    
			    default: {
			    	System.out.println("Invalid Input!!");
			    }
	}
		}
		
	}

	private static void addSong() {
    System.out.print("Enter song title: ");
    String title = scanner.nextLine();
    scanner.nextLine();
    System.out.print("Enter artist: ");
    String artist = scanner.nextLine();
    System.out.print("Enter duration (in minutes): ");
    double duration = Double.parseDouble(scanner.nextLine());

    Song newSong = new Song(title, artist, duration);

    if (playlist.contains(newSong)) {
        System.out.println("Song already exists!");
    } else {
        playlist.add(newSong);
        System.out.println("Song added!");
    }
}
	
	private static void removeSong() {
	    System.out.print("Enter title to remove: ");
	    String title = scanner.nextLine().toLowerCase();
	    scanner.nextLine();

	    boolean removed = playlist.removeIf(song -> song.getTitle().equals(title));
	    if (removed) {
	        System.out.println("Song removed.");
	    } else {
	        System.out.println("Song not found.");
	    }
	}	
	

	private static void searchSong() {
	    System.out.print("Enter title to search: ");
	    String title = scanner.nextLine().toLowerCase();
	    scanner.nextLine();
	    boolean found = false;
	    for (Song song : playlist) {
	        if (song.getTitle().contains(title)) {
	            System.out.println(song);
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println("No songs found.");
	    }
	}
	
	private static void displaySongs() {
	    if (playlist.isEmpty()) {
	        System.out.println("Playlist is empty.");
	    } else {
	        System.out.println("Playlist:");
	        for (Song song : playlist) {
	            System.out.println(song);
	        }
	    }
	}
	
	private static void shuffleSongs() {
	    if (playlist.isEmpty()) {
	        System.out.println("Playlist is empty.");
	    } else {
	        Collections.shuffle(playlist);
	        System.out.println("Playlist shuffled.");
	        displaySongs();
	    }
	}
	
	} 
