package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tss.database.DBConnection;
import com.tss.model.Student;

public class StudentDao {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public StudentDao() {
        this.connection = DBConnection.connect();
    }


    public List<Student> readAllStudents()
    {
        List<Student> students = new ArrayList<Student>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from student");
            
            while(result.next())
            {
                Student student = new Student();
                student.setStudentId(result.getInt("studentid"));
                student.setAge(result.getInt("age"));
                student.setPercentage(result.getDouble("percentage"));
                student.setStudentName(result.getString("name"));
                student.setRollno(result.getInt("rollnumber"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public void addNewStudent(Student student) {
    	try {
    		preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?,?)");
    		preparedStatement.setInt(1, student.getStudentId());
    		preparedStatement.setString(3, student.getStudentName());
    		preparedStatement.setDouble(5, student.getPercentage());
    		preparedStatement.setInt(2, student.getRollno());
    		preparedStatement.setInt(4, student.getAge());
    		
    	}
    	
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    
    }
    
    public Student ReadStudent(int studentId) {
    	Student student1 = null;
    	try {
			preparedStatement = connection.prepareStatement("select * from student where studentid = ?");
			preparedStatement.setInt(1, studentId);
			
			ResultSet  result = preparedStatement.executeQuery();
			
			if (result.next()) {
				
				student1 = new Student();
                student1.setStudentId(result.getInt("studentid"));
                student1.setAge(result.getInt("age"));
                student1.setPercentage(result.getDouble("percentage"));
                student1.setStudentName(result.getString("name"));
                student1.setRollno(result.getInt("rollnumber"));
                
                
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return student1;
    	
    }
    
    
    public void updateStudentPercentage(int studentId, double percentage) {
        try {
            preparedStatement = connection.prepareStatement("Update students set percentage = ? where studentid = ?");
            preparedStatement.setDouble(1, percentage);
            preparedStatement.setInt(2, studentId);
            
            int updates = preparedStatement.executeUpdate();

            if (updates > 0) {
                System.out.println(" Record added successfully.");
            }
            else {
                System.out.println("student id not fount");
            }

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(" SQL error during insert.");
            e.printStackTrace();
        }

    }
    
    public void deleteStudent(int studentId) {
        try {
            preparedStatement = connection.prepareStatement("delete from  students where studentid = ?");
            
            preparedStatement.setInt(1, studentId);
            

            int updates = preparedStatement.executeUpdate();

            if (updates > 0) {
                System.out.println(" Record deleted successfully.");
            }
            else {
                System.out.println("student id not fount");
            }

            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(" SQL error during insert.");
            e.printStackTrace();
        }

    }
    
}