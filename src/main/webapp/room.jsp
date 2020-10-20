<%--
  Created by IntelliJ IDEA.
  User: Thai Nguyen
  Date: 10/20/2020
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript"
            src="js/room.js">
    </script>
</head>
<body>
    <p> The rooms of Hotels</p>
    <fieldset>
        <legend>Room Information</legend>
        <span class = "label">Room No</span><input type="text" name="roomno" id="roomno" />
        <span class = "label">Type</span><select name = "roomtype" id = "roomtype">
            <option>Superior</option>
            <option>Deluxe</option>
            <option>Deluxe Villa</option>
            <option>Family Room</option>
        </select> <br>
        <span class = "label">Price</span> <input type="text" name="roomprice" id="roomprice" />
        <span class = "label">Max Guest</span> <input type="text" name="maxguest" id="maxguest" /> <br>
        <input type = "submit" id = "submitroom" value = "Add Room">
    </fieldset>
    <fieldset>
        <legend> List of Rooms</legend>
        <div id="listroom"></div>
    </fieldset>
</body>
</html>
