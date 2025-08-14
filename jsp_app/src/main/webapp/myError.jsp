<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="myHeader.jsp">
    <jsp:param name="pageTitle" value="Error" />
</jsp:include>

<h2 style="color:red;"><%= request.getParameter("msg") %></h2>

<a href="myLogin.jsp">Try Again</a>

<jsp:include page="myFooter.jsp" />
