<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.tss.model.Employee, com.tss.model.LeaveRequest" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Employee Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body class="page">

<div class="nav">
    <a href="${pageContext.request.contextPath}/employee/request-leave">Request Leave</a>
    <a class="right" href="${pageContext.request.contextPath}/employee/logout">Logout</a>
</div>

<div class="card">
    <h2>Dashboard</h2>
    <c:set var="emp" value="${sessionScope.employee}" />

    <p><strong>Welcome,</strong> ${emp.empName}</p>
    <p><strong>Department:</strong> ${emp.department}</p>

    <h3>Leave Balances</h3>
    <ul>
        <li>Planned Leave: ${emp.plannedLeaveBalance}</li>
        <li>Unplanned Leave: ${emp.unplannedLeaveBalance}</li>
        <li>Total Leave: ${emp.totalLeaveBalance}</li>
    </ul>

    <h3>Your Leave Requests</h3>
    <table class="table">
        <thead>
            <tr>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Type</th>
                <th>Duration</th>
                <th>Days</th>
                <th>Status</th>
                <th>Processed By</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="lr" items="${leaveRequests}">
            <tr>
                <td>${lr.startDate}</td>
                <td>${lr.endDate}</td>
                <td>${lr.leaveType}</td>
                <td>${lr.duration}</td>
                <td>${lr.numberOfDays}</td>
                <td>${lr.status}</td>
                <td><c:choose>
                        <c:when test="${lr.processedByAdmin != null}">${lr.processedByAdmin}</c:when>
                        <c:otherwise>-</c:otherwise>
                    </c:choose></td>
                <td>
                    <c:if test="${lr.status == 'PENDING' || lr.status == 'APPROVED'}">
                        <form action="${pageContext.request.contextPath}/employee/cancel-leave" method="post" style="display:inline;">
                            <input type="hidden" name="requestId" value="${lr.requestId}" />
                            <button type="submit" class="btn btn-red">Cancel</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
