<%@ page import="miu.hotel.service.RoomService" %>
<%@ page import="miu.hotel.database.Menus" %><%--
  Created by IntelliJ IDEA.
  User: nhanxautrai
  Date: 10/21/20
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Booked Rooms</title>
    <%@include file="partial/header_assests.jsp" %>
    <script src="js/order_dish.js" type="application/javascript"></script>
  </head>

  <body>
    <%@include file="partial/top.jsp" %>
    <div class="container-fluid">
      <div class="row">
        <%@include file="partial/left.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
          <h2>Booked Rooms</h2>
          <div class="table-responsive mt-5">
            <table id="booked_rooms" class="table table-hover">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Type</th>
                  <th>Price</th>
                  <th>Ordered Items</th>
                </tr>
              </thead>
              <tbody>
                <% request.setAttribute("bookedRooms", RoomService.getBookedRooms());%>
                <% request.setAttribute("menus", Menus.menuList);%>
                <c:forEach var="room" items="${bookedRooms}">
                  <tr>
                    <td>${room.roomNo}</td>
                    <td>${room.type}</td>
                    <td>${String.format("%.2f", room.price)}</td>
                    <td>
                      <select class="form-control w-50 d-inline" id="select_${room.roomNo}">
                        <c:forEach var="menu" items="${menus}">
                          <option value="${menu.id}">${menu.item_name}</option>
                        </c:forEach>
                      </select>
                      <form class="order_dish d-inline" action="order_dish" method="post">
                        <input type="hidden" name="room_no" value="${room.roomNo}">
                        <input type="hidden" name="menu_id" value="">
                        <input type="submit" value="Add" class="btn btn-primary" style="margin-top: -4px;">
                      </form>
                      <ol id="ol_${room.roomNo}" class="pl-4 pt-1">
                        <c:forEach var="m" items="${room.orderedItems}">
                          <li class="pb-1">
                            ${m.item_name} - <a href="unOrderDish?room_no=${room.roomNo}&menu_id=${m.id}" onclick="return confirm('Are you sure?');">Remove</a>
                          </li>
                        </c:forEach>
                      </ol>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </main>
      </div>
    </div>
  </body>
</html>
