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
    <title>Manage Menus</title>
    <%@include file="partial/header_assests.jsp" %>
  </head>

  <body>
    <%@include file="partial/top.jsp" %>
    <div class="container-fluid">
      <div class="row">
        <%@include file="partial/left.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
          <h2>Edit Menu</h2>
          <div class="mt-4 mb-5">
            <form action="edit_menu" method="post">
              <input type="hidden" name="id" value="${menu.id}" />
              <input class="form-control col-md-3 d-inline" name="item_name" placeholder="Item name" value="${menu.item_name}" required>
              <input class="form-control col-md-3 d-inline" type="number" name="price" value="${menu.price}" placeholder="Price" required>
              <br />
              <input class="btn btn-primary mt-3" type="submit" value="Update">
            </form>
          </div>
        </main>
      </div>
    </div>
  </body>
</html>
