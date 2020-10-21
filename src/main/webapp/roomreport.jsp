<%@ page import="miu.hotel.model.RoomLog" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <script src="js/jquery-3.5.1.js"></script>
    <script src="js/bootstrap.bundle.js"></script>

    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/sign_in.css"/>
</head>
<body>
<div class="container">
    <%
        List<RoomLog> list = new ArrayList<RoomLog>();
        if (session.getAttribute("roomLogs") != null)
            list = (List<RoomLog>) session.getAttribute("roomLogs");
    %>
    <script src="https://apps.elfsight.com/p/platform.js" defer></script>
    <div class="elfsight-app-06e4f94e-8432-4af1-b582-95f775405096"></div>

    <form  action="RoomReportServlet" method="get">
        <h1 class="h3 mb-3 font-weight-normal">Please search here!</h1>
        <input type="date" id="date" name="date" value=<%=session.getAttribute("dateSearch")%> required>
        <input type="submit" class="btn btn-primary"  value="Search">
        <button type="button" class="btn btn-primary" onclick="window.print()">Print Report</button>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">No</th>
                <th scope="col">Type</th>
                <th scope="col">Price</th>
                <th scope="col">Date</th>
            </tr>
            </thead>
            <tbody>
            <%
                float sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    RoomLog roomlLog = list.get(i);
                    sum += roomlLog.getPrice();
            %>
            <tr>
                <th scope="row"><%=i + 1%>
                </th>
                <td><%=roomlLog.getRoomNo()%>
                </td>
                <td><%=roomlLog.getType()%>
                </td>
                <td><%=roomlLog.getPrice()%>
                </td>
                <td><%=roomlLog.getDateUsing()%>
                </td>
            </tr>
            <% }%>
            </tbody>
            <tfoot>
            <tr>
                <th id="total" colspan="3">Total revenue:</th>
                <th id="sum" colspan="2"><%=sum%>
                </th>
            </tr>
            </tfoot>
        </table>
    </form>
</div>

</body>
</html>
