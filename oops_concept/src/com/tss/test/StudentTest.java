package com.tss.test;

import java.util.Scanner;

import com.tss.model.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student student1 = new Student();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your Roll number:");
		int rollNumber = scanner.nextInt();
		
		System.out.println("Enter your age :");
		int age = scanner.nextInt();
		
		System.out.println("Enter your name :");
		String name = scanner.nextLine() ;

		System.out.println("Enter subject 1 mark :");
		int subject1 = scanner.nextInt();
		System.out.println("Enter subject 2 mark :");
		int subject2 = scanner.nextInt();
		System.out.println("Enter subject 3 mark :");
		int subject3 = scanner.nextInt();
		
		student1.setSubjectMarks(subject1,subject2,subject3);
		student1.setAge(age);
		student1.setName(name);
		student1.setRollNumber(rollNumber);
		
		Student student2 = new Student();
		
		System.out.println("Enter your Roll number:");
		int rollNumber2 = scanner.nextInt();
		
		System.out.println("Enter your age :");
		int age2 = scanner.nextInt();
		
		System.out.println("Enter your name :");
		String name2 = scanner.nextLine() ;

		System.out.println("Enter subject 1 mark :");
		int subject21 = scanner.nextInt();
		System.out.println("Enter subject 2 mark :");
		int subject22 = scanner.nextInt();
		System.out.println("Enter subject 3 mark :");
		int subject23 = scanner.nextInt();
		
		student2.setSubjectMarks(subject21,subject22,subject23);
		student2.setAge(age2);
		student2.setName(name2);
		student2.setRollNumber(rollNumber2);
		
		System.out.println(student1.averageOfMarks(student1.getSubject1Mark(),student1.getSubject2Mark(),student1.getSubject3Mark()));
		System.out.println(student2.averageOfMarks(student2.getSubject1Mark(),student2.getSubject2Mark(),student2.getSubject3Mark()));
		
		student1.display();
		student2.display();
	}

}
