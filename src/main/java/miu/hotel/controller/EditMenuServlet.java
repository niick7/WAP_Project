package miu.hotel.controller;

import miu.hotel.model.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@WebServlet("/edit_menu")
public class EditMenuServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = Integer.parseInt(req.getParameter("id"));
    HttpSession session = req.getSession();
    List<Menu> menus = (List<Menu>) session.getAttribute("menus");
    Menu menu = menus.stream()
                     .filter(x -> id.equals(x.getId()))
                     .findAny()
                     .orElse(null);
    req.setAttribute("menu", menu);
    req.getRequestDispatcher("edit_menu.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = Integer.parseInt(req.getParameter("id"));
    HttpSession session = req.getSession();
    List<Menu> menus = (List<Menu>) session.getAttribute("menus");
    Menu menu = menus.stream()
      .filter(x -> id.equals(x.getId()))
      .findAny()
      .orElse(null);
    String item_name = req.getParameter("item_name");
    Double price = Double.parseDouble(req.getParameter("price"));
    menu.setItem_name(item_name);
    menu.setPrice(price);

    resp.sendRedirect("menu.jsp");
  }
}
