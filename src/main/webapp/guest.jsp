<%--
  Created by IntelliJ IDEA.
  User: hanhnguyen
  Date: 10/20/20
  Time: 12:28 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>

    <script src="js/guestInfo.js"></script>
    <title>Title</title>
</head>
<body>
<div>
    ID: <input type="text" required id="guestid" value=""><br>
    First Name: <input type="text" required id="guestfirstname" value=""><br>
    Last Name: <input type="text" required id="guestlastname" value=""> <br>
    Date of Birth: <input type="text" required id="guestdob" value=""> <br>
    Address <input type="text" required id="guestaddress" value=""> <br>
    <button id="btnInsertGuest"> Insert</button>
</div>
<div id="guestdisplay"></div>
</body>
</html>