<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body class="page">
<div class="card">
    <h2>Admin Login</h2>
    <c:if test="${not empty error}">
        <div class="alert-error">${error}</div>
    </c:if>
<form method="post" action="${pageContext.request.contextPath}/admin/login">
        <label>Username</label>
        <input type="text" name="username" required>
        <label>Password</label>
        <input type="password" name="password" required>
        <button type="submit" class="btn">Login</button>
    </form>
</div>
</body>
</html>
