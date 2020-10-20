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
    <title>Sign In</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/sign_in.css" />
</head>
<body>
<form class="form-signin" action = "LoginServlet" method= "post">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <input id="inputEmail" name= "username" class="form-control" placeholder="Username" required >
    <input type="password" name= "password" id="inputPassword" class="form-control" placeholder="Password" required>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">© 2020</p>
</form>

</body>
</html>
