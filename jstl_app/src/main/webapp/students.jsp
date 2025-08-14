<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>JSTL Core Tags Example</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f7f7f7; }
        h2 { color: #333; }
        table { border-collapse: collapse; width: 60%; background: #fff; box-shadow: 0 0 5px #ccc; }
        th, td { padding: 8px 12px; border: 1px solid #ddd; }
        th { background-color: #333; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .highlight { background-color: #dff0d8; }
    </style>
</head>
<body>

<h2>JSTL Core Tags Demonstration</h2>

<!-- 1. Setting variables -->
<c:set var="courseName" value="Information Technology" />
<p>Course Name: <c:out value="${courseName}" /></p>

<!-- 2. Conditional check -->
<c:if test="${courseName eq 'Information Technology'}">
    <p style="color:green;">You are enrolled in the Computer Science course.</p>
</c:if>

<!-- 3. Choose / When / Otherwise -->
<c:set var="score" value="85" />
<c:choose>
    <c:when test="${score >= 90}">
        <p>Grade: A</p>
    </c:when>
    <c:when test="${score >= 75}">
        <p>Grade: B</p>
    </c:when>
    <c:otherwise>
        <p>Grade: C</p>
    </c:otherwise>
</c:choose>

<!-- 4. Loop through a list -->
<c:set var="students">
    <c:out value="${null}" /> <!-- Placeholder -->
</c:set>
<c:set var="students" value="${['Hemanshi', 'Deep', 'Harsh', 'Dharmi']}" />

<h3>Student List</h3>
<table>
    <tr>
        <th>Index</th>
        <th>Name</th>
    </tr>
    <c:forEach var="student" items="${students}" varStatus="status">
        <tr class="${status.index % 2 == 0 ? 'highlight' : ''}">
            <td><c:out value="${status.index}" /></td>
            <td><c:out value="${student}" /></td>
        </tr>
    </c:forEach>
</table>

<!-- 5. Building a URL with parameters -->
<c:url var="profileUrl" value="profile.jsp">
    <c:param name="student" value="Hemanshi" />
    <c:param name="course" value="${courseName}" />
</c:url>

<p>
    Profile Link for Hemanshi: 
    <a href="${profileUrl}">${profileUrl}</a>
</p>

<!-- 6. Delayed redirect to Google -->
<p style="color:red;">You will be redirected to Google in 5 seconds...</p>
<script>
    setTimeout(function() {
        window.location.href = "https://www.google.com";
    }, 5000); // 5 seconds
</script>	 

</body>
</html>