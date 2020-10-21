package miu.hotel.controller;

import miu.hotel.database.Rooms;
import miu.hotel.model.Room;
import miu.hotel.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(name = "BookedServlet", urlPatterns = {"/BookingServlet"})
public class BookingServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String roomNo = req.getParameter("roomNo");
    String isCheckInString = req.getParameter("isCheckIn");

    RoomService.findRoomByRoomNum(roomNo)
        .filter(Room::isActive)
        .ifPresent(room -> {
          boolean isCheckIn = Boolean.valueOf(isCheckInString);
          room.setAvailable(isCheckIn);
        }); // find and uncheck

    req.getRequestDispatcher("RoomServlet").forward(req, resp);
  }
}
