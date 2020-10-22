package miu.hotel.controller;

import miu.hotel.database.Menus;
import miu.hotel.model.Menu;
import miu.hotel.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/delete_menu")
public class DeleteMenuServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = Integer.parseInt(req.getParameter("id"));HttpSession session = req.getSession();
    List<Menu> menus = Menus.menuList;
    Menu menu = MenuService.findById(id);
    menus.remove(menu);

    resp.sendRedirect("menu.jsp");
  }
}
