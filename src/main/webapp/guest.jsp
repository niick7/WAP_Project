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
    <script src="js/jquery-3.5.1.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
    <script src="js/guestInfo.js"></script>

    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Title</title>
</head>
<body>
<br>
<div class="msg"></div>

<div class="container">
<form>
    <div class="form-group row">
        <label for="guestid" class="col-sm-2 col-form-label">Guest ID</label>
        <div class="col-sm-10">
            <input type="text"  class="form-control" id="guestid" value="" required>
        </div>
    </div>
    <div class="form-group row">
        <label for="guestfirstname" class="col-sm-2 col-form-label">First Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="guestfirstname" required>
        </div>
    </div>

    <div class="form-group row">
        <label for="guestlastname" class="col-sm-2 col-form-label">Last Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="guestlastname" required>
        </div>
    </div>

    <div class="form-group row">
        <label for="guestaddress" class="col-sm-2 col-form-label">Address</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="guestaddress" required>
        </div>
    </div>

    <div class="form-group row">
        <label for="dob" class="col-sm-2 col-form-label">Date of Birth</label>
        <div class="col-sm-10">
            <input type="date" id ="dob"  min="1920-01-01" max="2005-12-31"  required/>
                <script>
                    document.getElementById('dob').value = new Date().toISOString().slice(0, 10);
                </script>
        </div>
    </div>

    <div class="form-group row">
        <label for="gender" class="col-sm-2 col-form-label">Gender</label>
        <div class="col-sm-10">
            <select name="gender" class="form-control" id="gender">
                <option value="Male">Male</option>--%>
               <option value="Female">Female</option>
               </select>
        </div>
    </div>
    <button id="btnInsertGuest" class='btn btn-primary'> Insert</button>
    <button id="btnUpdateGuest" class='btn btn-success'> Update</button>
</form>
</div>
<%--<form>--%>
<%--    <div class="form-group row">--%>

<%--&lt;%&ndash;    <div>ID: <input type="text" required id="guestid" value=""> </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;    First Name: <input type="text" required id="guestfirstname" value=""><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    Last Name: <input type="text" required id="guestlastname" value=""> <br>&ndash;%&gt;--%>
<%--    Date of Birth:
<input type="date" id ="dob"  min="1920-01-01" max="2005-12-31"  required/>--%>
<%--    <script>--%>
<%--        document.getElementById('dob').value = new Date().toISOString().slice(0, 10);--%>
<%--    </script>--%>
<%--&lt;%&ndash;    Address: <input type="text" required id="guestaddress" value=""> <br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    Gender: <select name="gender" id="gender" required>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <option value="Male">Male</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <option value="Female">Female</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </select>&ndash;%&gt;--%>
<%--    <button id="btnInsertGuest"> Insert</button>--%>
<%--    <button id="btnDeleteGuest">Delete</button>--%>
<%--    <button id="btnUpdateGuest">Update</button>--%>

<%--    </div>--%>
<%--</form>--%>
<hr>
<div id="guestdisplay" class="container">


  <!--  <ul id="guests"></ul> -->
   <table id="table_guests" class="table table-hover"  >
       <thead>
        <tr>
            <th scope="col">ID </th>
            <th scope="col">First Name   </th>
            <th scope="col">Last Name    </th>
            <th scope="col">Date of Birth</th>
            <th scope="col"> Gender       </th>
            <th scope="col">Address       </th>
            <th scope="col">Action       </th>
        </tr>
       </thead>
       <tbody>
<%--        <tr class="a">--%>
<%--        </tr>--%>
       </tbody>
   </table>

</div>



</body>
</html>