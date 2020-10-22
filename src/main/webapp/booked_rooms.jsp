<%--
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
    <%--          <c:forEach var="menu" items="${sessionScope.menus}">--%>
    <%--            <tr>--%>
    <%--              <td>${menu.id}</td>--%>
    <%--              <td>${menu.item_name}</td>--%>
    <%--              <td>${String.format("%.2f", menu.price)}</td>--%>
    <%--              <td>--%>
    <%--                <a href="edit_menu?id=${menu.id}" type="button" class="btn btn-warning">Edit</a>--%>
    <%--                <a href="delete_menu?id=${menu.id}" type="button" class="btn btn-danger ml-1" onclick="return confirm('Are you sure?')">Delete</a>--%>
    <%--              </td>--%>
    <%--            </tr>--%>
    <%--          </c:forEach>--%>
              </tbody>
            </table>
          </div>
        </main>
      </div>
    </div>
  </body>
</html>
