<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.tss.model.LeaveRequest" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
    <title>My Leave Requests</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body class="page">

<div class="nav">
    <a href="${pageContext.request.contextPath}/employee/dashboard">Dashboard</a>
    <a href="${pageContext.request.contextPath}/employee/request-leave">Request Leave</a>
    <a class="right" href="${pageContext.request.contextPath}/employee/logout">Logout</a>
</div>

<c:if test="${not empty sessionScope.flash}">
    <div class="alert">${sessionScope.flash}</div>
    <c:remove var="flash" scope="session"/>
</c:if>

<div class="card">
    <h2>My Leave Requests</h2>

    <c:choose>
        <c:when test="${empty leaveRequests}">
            <p>You have not submitted any leave requests yet.</p>
        </c:when>
        <c:otherwise>
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Type</th>
                    <th>Duration</th>
                    <th>Days</th>
                    <th>Reason</th>
                    <th>Status</th>
                    <th>Processed By</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="r" items="${leaveRequests}">
                    <tr>
                        <td>${r.requestId}</td>
                        <td>${r.startDate}</td>
                        <td>${r.endDate}</td>
                        <td>${r.leaveType}</td>
                        <td>${r.duration}</td>
                        <td>${r.numberOfDays}</td>
                        <td title="${fn:escapeXml(r.reason)}">
                            <c:out value="${fn:length(r.reason) > 20 ? fn:substring(r.reason,0,20).concat('…') : r.reason}"/>
                        </td>
                        <td>${r.status}</td>
                        <td>
                            <c:choose>
                                <c:when test="${r.processedByAdmin != null}">${r.processedByAdmin}</c:when>
                                <c:otherwise>-</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:if test="${r.status == 'PENDING' || r.status == 'APPROVED'}">
                                <form method="post" action="${pageContext.request.contextPath}/employee/cancel-leave" style="display:inline;">
                                    <input type="hidden" name="requestId" value="${r.requestId}" />
                                    <button type="submit" class="btn btn-red">Cancel</button>
                                </form>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
