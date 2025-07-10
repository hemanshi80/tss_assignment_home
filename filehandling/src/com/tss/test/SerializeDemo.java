package com.tss.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.tss.model.Student;

public class SerializeDemo {

	public static void main(String[] args) {
	        Student s = new Student("Alice", 21);
	        try {
	            FileOutputStream fileOut = new FileOutputStream("student.ser");
	            ObjectOutputStream out = new ObjectOutputStream(fileOut);
	            out.writeObject(s);
	            out.close();
	            fileOut.close();
	            System.out.println("Object serialized and saved to student.ser");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
	}

}
