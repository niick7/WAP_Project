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
    <%@include file="partial/header_assests.jsp" %>
    <script src="js/guestInfo.js"></script>

    <title>Guest Information</title>
</head>
<body>
<%@include file="partial/top.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="partial/left.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="msg"></div>
            <div class="container">
                <h1>Manage Guest</h1>
                <form>
                    <div class="form-group row">
                        <label for="guestid" class="col-sm-2 col-form-label">Guest ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="guestid" value="" required>
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
                            <input type="date" id="dob" min="1920-01-01" max="2005-12-31" required/>
                            <script>
                              document.getElementById('dob').value = new Date().toISOString().slice(0, 10);
                            </script>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="gender" class="col-sm-2 col-form-label">Gender</label>
                        <div class="col-sm-10">
                            <select name="gender" class="form-control" id="gender">
                                <option value="Male">Male</option>
                                --%>
                                <option value="Female">Female</option>
                            </select>
                        </div>
                    </div>
                    <button id="btnInsertGuest" type="submit" class='btn btn-primary'> Insert</button>
                </form>
            </div>
        </main>
    </div>
</div>

<hr>
<div id="guestdisplay" class="container">

    <table id="table_guests" class="table table-hover">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Date of Birth</th>
                <th scope="col"> Gender</th>
                <th scope="col">Address</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>

</div>


</body>
</html>