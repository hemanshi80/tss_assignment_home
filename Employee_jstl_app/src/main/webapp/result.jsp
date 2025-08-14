<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Result</title>
</head>
<body>
   <h2><%= request.getAttribute("message") %></h2>
    <a href="AdminLoginServlet?action=dashboard">Back to Dashboard</a>
</body>
</html>