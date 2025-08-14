<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Hii , Hemanshi this sidee!!!</b>
<%
int num1 = 10;
int num2 = 20;

java.util.Date date = new java.util.Date();

%>
<%= num1+num2 %>
<br><br>
<%= date %>

<%! double pi = 3.14; %>
<br><br>
Pi = <%= pi %>
<br><br><br>
<%@ include file="import.jsp" %>
</body>
</html>