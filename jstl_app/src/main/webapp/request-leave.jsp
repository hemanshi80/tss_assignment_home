<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Request Leave</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body class="page">

<div class="nav">
    <a href="${pageContext.request.contextPath}/employee/dashboard">Dashboard</a>
    <a href="${pageContext.request.contextPath}/employee/requests">My Leave Requests</a>
    <a class="right" href="${pageContext.request.contextPath}/employee/logout">Logout</a>
</div>

<div class="card">
    <h2>Request Leave</h2>

    <c:if test="${not empty error}">
        <div class="alert">${error}</div>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/employee/request-leave">
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required>

        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required>

        <label for="leaveType">Leave Type:</label>
        <select id="leaveType" name="leaveType" required>
            <option value="PLANNED">Planned</option>
            <option value="UNPLANNED">Unplanned</option>
        </select>

        <label for="duration">Duration:</label>
        <select id="duration" name="duration" required>
            <option value="FULL">Full Day</option>
            <option value="HALF_UPPER">Half Day (Morning)</option>
            <option value="HALF_LOWER">Half Day (Afternoon)</option>
        </select>

        <label for="reason">Reason:</label>
        <textarea id="reason" name="reason" rows="4" placeholder="Enter reason for leave" required></textarea>

        <button type="submit" class="btn success">Submit Request</button>
    </form>
</div>

</body>
</html>
