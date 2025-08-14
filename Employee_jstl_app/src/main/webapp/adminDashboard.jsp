<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tss.model.LeaveRequest" %>
<%
    List<LeaveRequest> leaveRequests = (List<LeaveRequest>) request.getAttribute("leaveRequests");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body { font-family: Arial; background: #eef2f3; }
        table {
            width: 80%; margin: 20px auto; border-collapse: collapse; background: white;
        }
        table, th, td { border: 1px solid #ccc; }
        th, td { padding: 10px; text-align: center; }
        th { background: #007bff; color: white; }
        .btn {
            padding: 5px 10px; color: white; border: none; cursor: pointer;
        }
        .approve { background: #28a745; }
        .reject { background: #dc3545; }
    </style>
</head>
<body>
    <h2 style="text-align:center;">Leave Requests</h2>
    <table>
        <tr>
            <th>Request ID</th>
            <th>Employee ID</th>
            <th>From</th>
            <th>To</th>
            <th>Reason</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <%
            if (leaveRequests != null && !leaveRequests.isEmpty()) {
                for (LeaveRequest lr : leaveRequests) {
        %>
        <tr>
            <td><%= lr.getRequestId() %></td>
            <td><%= lr.getEmpId() %></td>
            <td><%= lr.getStartDate() %></td>
            <td><%= lr.getEndDate() %></td>
            <td><%= lr.getReason() %></td>
            <td><%= lr.getStatus() %></td>
            <td>
                <form action="leaveAction" method="post" style="display:inline;">
                    <input type="hidden" name="requestId" value="<%= lr.getRequestId() %>">
                    <input type="hidden" name="action" value="approve">
                    <button type="submit" class="btn approve">Approve</button>
                </form>
                <form action="leaveAction" method="post" style="display:inline;">
                    <input type="hidden" name="requestId" value="<%= lr.getRequestId() %>">
                    <input type="hidden" name="action" value="reject">
                    <button type="submit" class="btn reject">Reject</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">No leave requests found.</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
