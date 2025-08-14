package com.tss.controller;

import java.util.List;
import java.util.Scanner;

import com.tss.model.Student;
import com.tss.service.StudentService;

public class StudentController {
	
	private StudentService studentService;
	Scanner scanner = new Scanner(System.in);

	public StudentController() {
		super();
		this.studentService = new StudentService();
	}
	
	public void readAllRecords() {
	    List<Student> students = studentService.readAllStudent();

	    for (Student student : students) {
	        System.out.println(
	            "Student ID: " + student.getStudentId() + " | " +
	            "Name: " + student.getStudentName() + " | " +
	            "Age: " + student.getAge() + " | " +
	            "Percentage: " + student.getPercentage() + " | " +
	            "Roll No: " + student.getRollno()
	        );
	    }
	}
	
	public void addNewStudent() {
		
		System.out.println("Enter Student ID :");
		int studentid = scanner.nextInt();
		
		System.out.println("Enter Student Rollnumber :");
		int rollnumber = scanner.nextInt();
		
		System.out.println("Enter Student Name :");
		String studentName = scanner.nextLine();
		
		System.out.println("Enter Student Age :");
		int age = scanner.nextInt();
		
		System.out.println("Enter Student Percentage :");
		double percentage = scanner.nextDouble();
		
		Student student = new Student(studentid , rollnumber , studentName , age , percentage);
		studentService.addNewStudent(student);
	}

	
	public void ReadStudent() {
		System.out.println("Enter Student Id :");
		int studentId = scanner.nextInt();
		
		Student student = studentService.ReadStudent(studentId);
		
		if (student != null) {
			System.out.println("Student ID: " + student.getStudentId() + " | " + "Name: " + student.getStudentName()
            + " | " + "Age: " + student.getAge() + " | " + "Percentage: " + student.getPercentage() + " | "
            + "Roll No: " + student.getRollno());
           } 
		else {
			System.out.println(" Student with ID " + studentId + " not found.");
		}
		}
	
	public void updateStudentPercentage() {
        System.out.println("Enter Student ID:");
        int studentId = scanner.nextInt();
        System.out.println("Enter Student Percentage:");
        double percentage = scanner.nextDouble();
        
        studentService.updateStudentPercentage(studentId, percentage);
        
    }
    
    public void deleteStudent() {
        System.out.println("Enter Student ID:");
        int studentId = scanner.nextInt();
        
        studentService.deleteStudent(studentId);
        
    }
}


