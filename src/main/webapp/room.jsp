<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<head>
    <title>Rooms</title>
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
                <h1> Manage Rooms</h1>
                <div class="row">
                    <form action="RoomServlet" method="post">
                        <div class="form-row">
                            <div class="col-md-4 mb-3">
                                <label for="roomNo">Room No</label>
                                <input type="text" class="form-control" id="roomNo" name="roomNo" value="" required>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="roomType">Room Type</label>
                                <select class="custom-select" id="roomType" name="roomType" required>
                                    <option selected value="">Choose...</option>
                                    <c:forEach var="roomType" items="${roomTypes}">
                                        <option value="${roomType}">${roomType}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label for="price">Price</label>
                                <input type="text" class="form-control" id="price" name="price" value="" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-6 mb-3">
                                <label for="maxGuest">Max Guest</label>
                                <input type="text" class="form-control" id="maxGuest" name="maxGuest" value="" required>
                            </div>
                        </div>
                        <input type="hidden" name="actionCommand" value="add">
                        <button class="btn btn-primary" type="submit">Add New</button>
                        <input class="btn btn-secondary" type="reset" value="Cancel"/>

                    </form>
                </div>
            </div>

            <div class="container">
                <h1>List of Rooms</h1>
                <div class="row">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Room Number</th>
                            <th scope="col">Type</th>
                            <th scope="col">Price</th>
                            <th scope="col">Max guest</th>
                            <th scope="col">Book Room</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="room" items="${roomList}" varStatus="status">
                            <tr class="${room.active ? '' : 'table-secondary'}">
                                <th scope="row">${room.roomNo}</th>
                                <td>${room.type}</td>
                                <td>${room.price}</td>
                                <td>${room.guestNum}</td>
                                <td>
                                    <c:if test="${room.available}">
                                        <form action="BookRoomServlet" method="post">
                                            <input type="hidden" name="roomNo" value="${room.roomNo}">
                                            <input type="hidden" name="checkin" value="checkin">
                                            <input type="text"
                                                   name="guestId"
                                                   value=""
                                                   placeholder="Guest Id"
                                                ${ !room.active ? 'disabled="disabled"' : ''}>
                                            <button class="btn btn-primary"
                                                    type="submit"
                                                ${ !room.active ? 'disabled="disabled"' : ''} >
                                                Book Room
                                            </button>
                                        </form>
                                    </c:if>

                                    <c:if test="${!room.available}">
                                        <form action="BookRoomServlet" method="post">
                                            <input type="hidden" name="roomNo" value="${room.roomNo}">
                                            <input type="hidden" name="checkin" value="checkout">
                                            <button class="btn btn-success"
                                                    type="submit"
                                                ${ !room.active ? 'disabled="disabled"' : ''} >
                                                Return Room
                                            </button>
                                        </form>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${room.active}">
                                        <form action="RoomServlet" method="post">
                                            <input type="hidden" name="roomNo" value="${room.roomNo}">
                                            <input type="hidden" name="actionCommand" value="delete">
                                            <button class="btn btn-danger" type="submit">Delete</button>
                                        </form>

                                        <form action="EditRoomServlet" method="get">
                                            <input type="hidden" name="roomNo" value="${room.roomNo}">
                                            <input type="hidden" name="actionCommand" value="edit">
                                            <button class="btn btn-warning" type="submit">Edit</button>
                                        </form>

                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </main>
    </div>
</div>


</body>
</html>
