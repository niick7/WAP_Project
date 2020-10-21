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

    <title>Guest Information</title>
<%--    <link rel="stylesheet" href="css/bootstrap.css" />--%>
<%--    <link rel="stylesheet" href="css/sign_in.css" />--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <script src="js/guestInfo.js"></script>
<%--    <script src="css/bootstrap.css"></script>--%>
<%--    <script src="js/bootstrap.js"></script>--%>
    <title>Title</title>
</head>
<body>
<br>
<div class="msg"></div>
<div>
    <div>ID: <input type="text" required id="guestid" value=""> </div>

    First Name: <input type="text" required id="guestfirstname" value=""><br>
    Last Name: <input type="text" required id="guestlastname" value=""> <br>
    Date of Birth: <input type="date" id ="dob"  min="1920-01-01" max="2005-12-31"  required/>
    <script>
        document.getElementById('dob').value = new Date().toISOString().slice(0, 10);
    </script>
    Address: <input type="text" required id="guestaddress" value=""> <br>
    Gnder: <select name="gender" id="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            </select>
    <button id="btnInsertGuest"> Insert</button>
    <button id="btnDeleteGuest">Delete</button>
</div>

<br>
<div id="guestdisplay">


  <!--  <ul id="guests"></ul> -->
   <table id="table_guests"  >
       <thead>
        <tr>
            <th>ID </th>
            <th>First Name   </th>
            <th>Last Name    </th>
            <th>Date of Birth</th>
            <th>Gender       </th>
            <th>Address       </th>
        </tr>
       </thead>
       <tbody>
        <tr class="a">
        </tr>
       </tbody>
   </table>

</div>



</body>
</html>