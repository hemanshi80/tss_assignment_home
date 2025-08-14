<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Portal</title>

</head>
<body>
<h2>Welcome to Student Portal</h2>
<p><b>Current Date & Time:</b> <%= new java.util.Date() %></p>

    <%!
        String studentName = "Hemanshi Chotaliya";
        String course = "B.Tech Information & Technology";
        int marks = 90;
        String grade;
    %>

 <%
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 75 && marks < 90) {
            grade = "B";
        } else if (marks >= 50 && marks < 75) {
            grade = "C";
        } else {
            grade = "F";
        }
    %>
    
    <h2>Student Information</h2>
    <p><b>Name:</b> <%= studentName %></p>
    <p><b>Course:</b> <%= course %></p>
    <p><b>Marks:</b> <%= marks %></p>
    <p><b>Grade:</b> <%= grade %></p>
</body>
</html>