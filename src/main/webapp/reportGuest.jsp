<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Guest Report</title>

    <%@include file="partial/header_assests.jsp" %>
    <script src="js/guestInfo.js"></script>
</head>
<body>
<%@include file="partial/top.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="partial/left.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="msg"></div>
            <div class="container">
                <form>

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">New Guest for the last 30 days</label>
                    </div>
                    <div class="form-group row">
                        <label for="from" class="col-sm-2 col-form-label">From</label>
                        <div class="col-sm-10">
                            <input type="date" id="from" min="1980-01-01" required/>
                            <script>
                              document.getElementById('from').value = new Date().toISOString().slice(0, 10);
                            </script>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="to" class="col-sm-2 col-form-label">To</label>
                        <div class="col-sm-10">
                            <input type="date" id="to" min="1980-01-01" required/>
                            <script>
                              document.getElementById('to').value = new Date().toISOString().slice(0, 10);
                            </script>
                        </div>
                    </div>

                    <button id="btnGuestReport" class='btn btn-success'> Report</button>
                </form>
            </div>
            <hr>
            <div id="guestreportdisplay" class="container">
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
        </main>
    </div>
</div>


</body>
</html>