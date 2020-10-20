package miu.hotel.controller;

import miu.hotel.database.Rooms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "BookedServlet", urlPatterns = {"/BookingServlet"})
public class BookingServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String roomNo = req.getParameter("roomNo");
    String isCheckIn = req.getParameter("isCheckIn");

    Rooms.roomList.stream()
        .filter(room -> room.getRoomNo().equals(roomNo))
        .findFirst()
        .ifPresent(room -> room.setAvailable(Boolean.valueOf(isCheckIn))); // find and uncheck

    req.getRequestDispatcher("RoomServlet").forward(req, resp);
  }
}
