<%--
  Created by IntelliJ IDEA.
  User: nhanxautrai
  Date: 10/21/20
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <h2>Menus</h2>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Item Name</th>
                                    <th>Price</th>
                                    <th>Actions</th>
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
