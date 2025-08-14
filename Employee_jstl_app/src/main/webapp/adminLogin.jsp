<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <title>Admin Login</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .login-box {
            width: 350px; margin: 100px auto; padding: 20px;
            background: #fff; box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 { text-align: center; }
        input[type=text], input[type=password] {
            width: 100%; padding: 8px; margin: 8px 0; box-sizing: border-box;
        }
        input[type=submit] {
            background-color: #28a745; color: white; padding: 10px;
            border: none; width: 100%; cursor: pointer;
        }
        input[type=submit]:hover { background-color: #218838; }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Admin Login</h2>
    <form action="AdminLoginServlet" method="post">
        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <input type="submit" value="Login">
    </form>
    <p style="color:red;">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>
</div>
</body>
</html>