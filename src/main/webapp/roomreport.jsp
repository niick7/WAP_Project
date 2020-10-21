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
    <%@include file="partial/header_assests.jsp" %>

</head>
<body>
<%@include file="partial/top.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="partial/left.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="container">
                <%
                    List<RoomLog> list = new ArrayList<RoomLog>();
                    if (session.getAttribute("roomLogs") != null)
                        list = (List<RoomLog>) session.getAttribute("roomLogs");
                %>
                <script src="https://apps.elfsight.com/p/platform.js" defer></script>
                <div class="elfsight-app-05671b58-d6b9-41df-ab32-0779428eb750"></div>

                <form action="RoomReportServlet" method="get">
                    <h1 class="h3 mb-3 font-weight-normal">Please search here!</h1>
                    <input type="date" id="date" name="date" value=<%=session.getAttribute("dateSearch")%> required>
                    <input type="submit" class="btn btn-primary" value="Search">
                    <button type="button" class="btn btn-primary" onclick="window.print()">Print Report</button>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">No</th>
                            <th scope="col">Type</th>
                            <th scope="col">Room Fee</th>
                            <th scope="col">Service Fee</th>
                            <th scope="col">Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            float sum = 0;
                            for (int i = 0; i < list.size(); i++) {
                                RoomLog roomlLog = list.get(i);
                                sum += roomlLog.getPrice() + roomlLog.getServiceFee();
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
                            <td><%=roomlLog.getServiceFee()%>
                            </td>
                            <td><%=roomlLog.getDateUsing()%>
                            </td>
                        </tr>
                        <% }%>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th id="total" colspan="3">Total revenue:</th>
                            <th id="sum" colspan="3"><%=sum%>
                            </th>
                        </tr>
                        </tfoot>
                    </table>
                </form>
            </div>
        </main>
    </div>
</div>

</body>
</html>
