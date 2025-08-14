<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="com.tss.model.MyUser" scope="session" />

<jsp:setProperty name="user" property="*" />

<%
    String uname = request.getParameter("username");
    String pass = request.getParameter("password");

    if ("hemanshi".equals(uname) && "123".equals(pass)) {
%>
        <jsp:forward page="myWelcome.jsp">
            <jsp:param name="msg" value="Login Successful!" />
        </jsp:forward>
<%
    } else {
%>
        <jsp:forward page="myError.jsp">
            <jsp:param name="msg" value="Invalid username or password" />
        </jsp:forward>
<%
    }
%>
