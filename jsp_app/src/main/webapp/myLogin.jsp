<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<jsp:include page="myHeader.jsp">
    <jsp:param name="pageTitle" value="Login Page" />
</jsp:include>

<h2>Login Form</h2>
<form action="myProcessLogin.jsp" method="post">
    Username: <input type="text" name="username" /><br><br>
    Password: <input type="password" name="password" /><br><br>
    <input type="submit" value="Login" />
</form>

<jsp:include page="myFooter.jsp" />

</body>
</html>
