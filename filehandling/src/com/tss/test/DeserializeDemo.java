package com.tss.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.tss.model.Student;

public class DeserializeDemo {

	public static void main(String[] args) {
		 Student s = null;

	        try {
	            FileInputStream fileIn = new FileInputStream("student.ser");
	            ObjectInputStream in = new ObjectInputStream(fileIn);
	            s = (Student) in.readObject();
	            in.close();
	            fileIn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        System.out.println("Deserialized Student: " + s.name + ", " + s.age);

	}

}
