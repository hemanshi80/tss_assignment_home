<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body class="page">
<div class="nav">
    <a href="${pageContext.request.contextPath}/admin/requests">Pending Requests</a>
<a class="right" href="${pageContext.request.contextPath}/admin/logout">Logout</a>
</div>

<div class="card">
    <h2>Dashboard</h2>
    <p><strong>Welcome,</strong> ${adminName}</p>
    <p><strong>Pending Leave Requests:</strong> ${pendingCount}</p>
    <a class="btn" href="${pageContext.request.contextPath}/admin/requests">View Requests</a>
</div>
</body>
</html>
