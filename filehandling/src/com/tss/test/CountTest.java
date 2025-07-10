package com.tss.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountTest {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("input.txt"))
		{
			int ch , charCount =0, lineCount = 0 , wordCount =0;
			boolean word = false;
			while((ch = reader.read())!=-1) {
				
				
				if (ch != ' ' && ch!= '\n' && ch!='\t' && ch!='\r') {
					charCount++;
				}
				
				if (Character.isWhitespace(ch)) {
					word = false;
				}
				else if(!word) {
					wordCount++;
					word = true;
				}
				
				if (ch == '\n') {
					lineCount++;
				}
				
			}
			System.out.println("Total Word :" + wordCount );
			System.out.println("Total Character :" + charCount);
			System.out.println("Total Line :" + (lineCount + 1) );

			
		}
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
