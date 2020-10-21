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
        <script src="js/menus.js" type="application/javascript"></script>
    </head>

    <body>
        <%@include file="partial/top.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <%@include file="partial/left.jsp" %>
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                    <h2>Menus</h2>
                    <div class="mt-4 mb-5">
                        <form id="menus">
                            <input class="form-control col-md-3 d-inline" name="item_name" placeholder="Item name" required>
                            <input class="form-control col-md-3 d-inline" type="number" name="price" placeholder="Price" required>
                            <br />
                            <input class="btn btn-primary mt-3" type="submit" value="Create">
                        </form>
                    </div>
                    <div class="table-responsive">
                        <table id="list_menus" class="table table-striped table-sm">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Item Name</th>
                                    <th>Price(USD)</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="menu" items="${sessionScope.menus}">
                                    <tr>
                                        <td>${menu.id}</td>
                                        <td>${menu.item_name}</td>
                                        <td>${String.format("%.2f", menu.price)}</td>
                                        <td></td>
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
