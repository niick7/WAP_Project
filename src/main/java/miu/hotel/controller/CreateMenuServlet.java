package miu.hotel.controller;

import com.google.gson.Gson;
import miu.hotel.database.Menus;
import miu.hotel.model.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/menus")
public class CreateMenuServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String item_name = req.getParameter("item_name");
    double price = Double.parseDouble(req.getParameter("price"));

    HttpSession session = req.getSession();
    List<Menu> menus = new ArrayList<>();
    if(session.getAttribute("menus") != null) {
//      menus = ((List<Menu>) session.getAttribute("menus"));
      menus = Menus.menuList;
    }
    Menu menu = new Menu(item_name, price);
    menus.add(menu);
    session.setAttribute("menus", menus);
    Gson json = new Gson();

    PrintWriter out = resp.getWriter();
    resp.setContentType("application/json");
    out.write(json.toJson(menus));
  }
}
