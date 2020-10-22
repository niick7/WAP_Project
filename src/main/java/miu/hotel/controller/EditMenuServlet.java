package miu.hotel.controller;

import miu.hotel.model.Menu;
import miu.hotel.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit_menu")
public class EditMenuServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = Integer.parseInt(req.getParameter("id"));
    Menu menu = MenuService.findById(id);
    req.setAttribute("menu", menu);
    req.getRequestDispatcher("edit_menu.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = Integer.parseInt(req.getParameter("id"));
    Menu menu = MenuService.findById(id);
    String item_name = req.getParameter("item_name");
    Double price = Double.parseDouble(req.getParameter("price"));
    menu.setItem_name(item_name);
    menu.setPrice(price);

    resp.sendRedirect("menu.jsp");
  }
}
