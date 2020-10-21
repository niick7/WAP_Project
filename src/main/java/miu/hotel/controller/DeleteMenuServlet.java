package miu.hotel.controller;

import miu.hotel.model.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/delete_menu")
public class DeleteMenuServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = Integer.parseInt(req.getParameter("id"));
    HttpSession session = req.getSession();
    List<Menu> menus = (ArrayList<Menu>) session.getAttribute("menus");
    Menu menu = menus.stream()
      .filter(x -> id.equals(x.getId()))
      .findAny()
      .orElse(null);
    menus.remove(menu);
    session.setAttribute("menus", menus);

    resp.sendRedirect("menu.jsp");
  }
}
