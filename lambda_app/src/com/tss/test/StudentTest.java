package com.tss.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.tss.model.Student;

public class StudentTest {

	public static void main(String[] args) {
		
		List<Student> student = Arrays.asList(
			
				new Student("a",1,80),
				new Student ("b",2,90),
				new Student ("c",3,70),
				new Student ("d",4,75),
				new Student ("e",5,84),
				new Student ("f",6,60),
				new Student ("g",7,50),
				new Student ("d",8,90),
				new Student ("n",9,55),
				new Student ("m",10,30)
	);
		
	Predicate<Student> isScore = students -> students.getMarks() > 75;
	
	Consumer<Student> congrats = students -> 
	System.out.println("Congratulation "+ students.getName()+ " your score " + students.getMarks());
	
	System.out.println("Student who scored above 75 : ");
	student.stream().filter(isScore).forEach(congrats);
	}

}
