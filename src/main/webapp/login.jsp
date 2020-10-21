<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>

<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@include file="partial/header_assests.jsp" %>
</head>

<body>
<div class="container">

    <div class="row justify-content-md-center">
        <div class="col-md-auto">
            <h1>Login Form</h1>
            <form action="LoginServlet" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" name="username" class="form-control" id="username"
                           aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" id="password">
                </div>
                <input type="submit" class="btn btn-primary"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
