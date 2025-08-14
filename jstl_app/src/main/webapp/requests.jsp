<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
    <title>Pending Leave Requests</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body class="page">
<div class="nav">
    <a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a>
<a class="right" href="${pageContext.request.contextPath}/admin/logout">Logout</a>
</div>

<c:if test="${not empty sessionScope.flash}">
    <div class="alert">${sessionScope.flash}</div>
    <c:remove var="flash" scope="session"/>
</c:if>

<div class="card">
    <h2>Pending Leave Requests</h2>

    <c:choose>
        <c:when test="${empty requests}">
            <p>No pending requests.</p>
        </c:when>
        <c:otherwise>
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Employee</th>
                    <th>Dept</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Type</th>
                    <th>Duration</th>
                    <th>Days</th>
                    <th>Reason</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="r" items="${requests}">
                    <tr>
                        <td>${r.requestId}</td>
                        <td>${fn:escapeXml(r.empName)}</td>
                        <td>${r.empName != null ? r.empName : '-'}</td>
                        <td>${r.startDate}</td>
                        <td>${r.endDate}</td>
                        <td>${r.leaveType}</td>
                        <td>${r.duration}</td>
                        <td>${r.numberOfDays}</td>
                        <td title="${fn:escapeXml(r.reason)}">
                            <c:out value="${fn:length(r.reason) > 20 ? fn:substring(r.reason,0,20).concat('…') : r.reason}"/>
                        </td>
                        <td class="actions">
							<form method="post" action="${pageContext.request.contextPath}/admin/decision">
                                <input type="hidden" name="requestId" value="${r.requestId}">
                                <button name="action" value="approve" class="btn success">Approve</button>
                                <button name="action" value="reject" class="btn danger">Reject</button>
                            </form>
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
