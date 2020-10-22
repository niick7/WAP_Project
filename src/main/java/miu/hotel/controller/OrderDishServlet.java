package miu.hotel.controller;

import miu.hotel.model.Menu;
import miu.hotel.model.Room;
import miu.hotel.service.MenuService;
import miu.hotel.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order_dish")
public class OrderDishServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String roomNo = req.getParameter("room_no");
    Room room = RoomService.findByRoomNo(roomNo);
    Integer menuId = Integer.parseInt(req.getParameter("menu_id"));
    Menu menu = MenuService.findById(menuId);
    room.getOrderedItems().add(menu);

    resp.sendRedirect("booked_rooms.jsp");
  }
}
