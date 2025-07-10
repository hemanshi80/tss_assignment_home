package com.tss.test;

import java.io.File;

public class FileMetaDataTest {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\hemanshi.chotaliya\\Desktop\\TSS\\Assignment\\filehandling\\src\\Example");
		
		if (file.isFile()) {
			System.out.println("Its a file.");
			System.out.println("length :" +file.length());
		}
		
		if(file.isDirectory()) {
			System.out.println("Its a directory.");
			System.out.println("Directory name :" + file.getName());
			File[] fileArray = file.listFiles();
			displayDir(fileArray);
			return;
		}
	}
	
	public static void displayDir(File [] fileArray) {
		for(File f : fileArray) 
		{
			if(f.isDirectory()) {
				File fileArray2 [] = f.listFiles();
				displayDir(fileArray2);
			}
			System.out.println(f.getName());
		}
	}


}
