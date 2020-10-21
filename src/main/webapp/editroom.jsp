<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<head>
    <title>Edit Rooms</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <%@include file="partial/header_assests.jsp" %>
    <script src="js/room.js"></script>
</head>
<body>

<%@include file="partial/top.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="partial/left.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="container">
                <h1> Edit Room</h1>
                <div class="row">
                    <form action="RoomServlet" method="post">
                        <div class="form-row">
                            <div class="col-md-4 mb-3">
                                <label for="roomNo">Room No</label>
                                <input type="text" class="form-control" id="roomNo" name="roomNo" value="${room.roomNo}" readonly>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="roomType">Room Type</label>
                                <select class="custom-select" id="roomType" name="roomType" required>
                                    <option selected value="">Choose...</option>
                                    <c:forEach var="roomType" items="${roomTypes}">
                                        <option value="${roomType}" ${roomType == room.type? 'selected' : ''} >${roomType}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="price">Price</label>
                                <input type="text" class="form-control" id="price" name="price" value="${room.price}" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-6 mb-3">
                                <label for="maxGuest">Max Guest</label>
                                <input type="text" class="form-control" id="maxGuest" name="maxGuest" value="${room.guestNum}" required>
                            </div>
                        </div>
                        <input type="hidden" name="actionCommand" value="edit">
                        <button class="btn btn-primary" type="submit">Update</button>
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>


</body>
</html>
