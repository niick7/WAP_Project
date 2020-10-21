<%--
  Created by IntelliJ IDEA.
  User: nhanxautrai
  Date: 10/21/20
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="miu.hotel.model.Menu" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  if(session.getAttribute("menus") == null) {
    List<Menu> menus = new ArrayList();
    menus.add(new Menu("Coffee", 3.43));
    menus.add(new Menu("Milk Coffee", 5.15));
    menus.add(new Menu("Coca", 1.89));
    menus.add(new Menu("Pepsi", 1.89));
    menus.add(new Menu("Heineken", 3.23));
    menus.add(new Menu("BudLight", 2.98));
    menus.add(new Menu("Orange Juice", 4.53));
    menus.add(new Menu("Lemon Juice", 3.68));
    menus.add(new Menu("Pilau", 4.28));
    menus.add(new Menu("Beef Rice", 10.32));
    menus.add(new Menu("Beef Rice and Egg", 14.74));
    menus.add(new Menu("Egg Rice", 5.15));
    menus.add(new Menu("Soup Noodle", 3.48));
    menus.add(new Menu("Beef Noodle", 8.23));
    menus.add(new Menu("Beef Noodle and Egg", 10.23));

    session.setAttribute("menus", menus);
  }
%>