<%@ page import="miu.hotel.model.RoomLog" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Thai Nguyen
  Date: 10/20/2020
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/sign_in.css" />
</head>
<body>
<%List<RoomLog> list = (List<RoomLog>)session.getAttribute("roomLog");%>
<form class="form-signin" action = "RoomReportServlet" method= "get">
    <input type="date" id="date" name= "date" required > <input type = "submit" value = "Search">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">RoomNo</th>
            <th scope="col">Type</th>
            <th scope="col">Price</th>
            <th scope="col">Rent Date</th>
        </tr>
        </thead>
        <tbody>
        <%
            float sum = 0;
            for (int i = 0; i < list.size(); i++){
                RoomLog roomlLog = list.get(i);
                sum += roomlLog.getPrice();
        %>
        <tr>
            <th scope="row"><%=i+1%></th>
            <td><%=roomlLog.getRoomNo()%></td>
            <td><%=roomlLog.getType()%></td>
            <td><%=roomlLog.getPrice()%></td>
            <td><%=roomlLog.getDateUsing()%></td>
        </tr>
        <% }%>
        </tbody>
        <tfoot>
        <tr>
            <th id="total" colspan="3">Total: </th>
            <th id="sum" colspan="2"><%=sum%></th>
        </tr>
        </tfoot>
    </table>
</form>

</body>
</html>
