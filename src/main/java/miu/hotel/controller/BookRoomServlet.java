package miu.hotel.controller;

import miu.hotel.database.RoomLogs;
import miu.hotel.database.Rooms;
import miu.hotel.model.Menu;
import miu.hotel.model.Room;
import miu.hotel.model.RoomLog;
import miu.hotel.service.RoomLogService;
import miu.hotel.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String roomNo = req.getParameter("roomNo");
    String checkin = req.getParameter("checkin");
    String guestId = req.getParameter("guestId");

    RoomService.findRoomByRoomNum(roomNo)
        .filter(Room::isActive)
        .ifPresent(room -> {
          boolean isCheckIn = "checkin".equals(checkin);
          room.setAvailable(!isCheckIn);

          if(isCheckIn){
            RoomLog roomLog = new RoomLog();

            roomLog.setRoomNo(room.getRoomNo());
            roomLog.setType(room.getType());
            roomLog.setPrice(room.getPrice());
            roomLog.setGuestNum(room.getGuestNum());

            roomLog.setDateUsing(LocalDate.now());
            roomLog.setGuestId(guestId);
            RoomLogService.add(roomLog);
          } else {
            // Checkout case
            RoomLog roomLog = RoomLogService.getLatestRoomLogByRoomNo(room.getRoomNo());
            double serviceFee = 0.0;
            for(Menu menu : room.getOrderedItems()) {
              serviceFee += menu.getPrice();
            }
            roomLog.setServiceFee(serviceFee);
            // Reset room ordered items
            room.resetOrderedItems();
          }
        }); // find and uncheck

    resp.sendRedirect("RoomServlet");
  }
}

