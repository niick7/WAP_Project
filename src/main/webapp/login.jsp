<%--
  Created by IntelliJ IDEA.
  User: Thai Nguyen
  Date: 10/20/2020
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
    <script type="application/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="application/javascript" src="js/bootstrap.bundle.js"></script>

    <link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
</head>

<body>
<form action = "LoginServlet" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Username</label>
        <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name ="password" class="form-control" id="exampleInputPassword1">
    </div>
    <input type="submit" class="btn btn-primary">Submit</input>
</form>

</body>
</html>
