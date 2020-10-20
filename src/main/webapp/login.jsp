<%--
  Created by IntelliJ IDEA.
  User: Thai Nguyen
  Date: 10/20/2020
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = "LoginServlet" method = "post">
    Username: <input type = "text" required id= "username" name= "username"><br>
    Password: <input type = "text" required id= "password" name= "password"><input type= "submit" value = "Login">
</form>

</body>
</html>
