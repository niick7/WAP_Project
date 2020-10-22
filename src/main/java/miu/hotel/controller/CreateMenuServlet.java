package miu.hotel.controller;

import com.google.gson.Gson;
import miu.hotel.database.Menus;
import miu.hotel.model.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/menus")
public class CreateMenuServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String item_name = req.getParameter("item_name");
    double price = Double.parseDouble(req.getParameter("price"));

    List<Menu> menus = Menus.menuList;
    menus.add(new Menu(item_name, price));
    Gson json = new Gson();

    PrintWriter out = resp.getWriter();
    resp.setContentType("application/json");
    out.write(json.toJson(menus));
  }
}
