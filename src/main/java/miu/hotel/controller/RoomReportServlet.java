package miu.hotel.controller;

import miu.hotel.database.RoomLogs;
import miu.hotel.database.Rooms;
import miu.hotel.model.RoomLog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@WebServlet(name = "RoomReportServlet", urlPatterns = {"/RoomReportServlet"})
public class RoomReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Room> rooms = Rooms.roomList.stream().filter(room -> room.)
        String dateSearch = request.getParameter("date");
        LocalDate searchDate = LocalDate.parse(dateSearch);
        System.out.println(searchDate);
        List<RoomLog> list = RoomLogs.roomList.stream()
                .filter(roomLog -> roomLog.getDateUsing().isAfter(searchDate)).collect(Collectors.toList());
        System.out.println(list);
        HttpSession session = request.getSession();
        session.setAttribute("roomLogs", list);
        session.setAttribute("dateSearch", dateSearch);
        response.sendRedirect("roomreport.jsp");
    }
}
