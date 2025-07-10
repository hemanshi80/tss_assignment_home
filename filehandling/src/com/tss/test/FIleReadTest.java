package com.tss.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FIleReadTest {

	public static void main(String[] args) {
		
		try (FileReader reader = new FileReader("input.txt");
				FileWriter writer = new FileWriter("output.txt"))
		{
			int ch;
			while((ch = reader.read())!=-1) {
				writer.write((char)ch);
			}
			System.out.println("Output copied successfully!!");
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
