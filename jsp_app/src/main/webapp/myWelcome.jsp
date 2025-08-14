<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="com.tss.model.MyUser" scope="session" />
<jsp:include page="myHeader.jsp">
    <jsp:param name="pageTitle" value="Welcome" />
</jsp:include>

<h2><%= request.getParameter("msg") %></h2>
<p>Welcome, <jsp:getProperty name="user" property="username" />!</p>

<jsp:include page="myFooter.jsp" />
