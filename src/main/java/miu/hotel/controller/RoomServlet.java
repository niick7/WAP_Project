package miu.hotel.controller;

import com.google.gson.Gson;
import miu.hotel.database.Rooms;
import miu.hotel.enums.RoomType;
import miu.hotel.model.Room;
import miu.hotel.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("doPost of RoomServlet");
//        String roomNo = request.getParameter("roomno");
//        String roomType = request.getParameter("roomtype");
//        float  roomPrice= Float.parseFloat(request.getParameter("roomprice"));
//        int maxGuest = Integer.parseInt(request.getParameter("maxguest"));
//        Room room = new Room(roomNo, roomType, roomPrice, maxGuest);
//        System.out.println(room.getRoomNo());
//        HttpSession session = request.getSession();
//        List<Room> list = new ArrayList<Room>();
//        if (session.getAttribute("rooms") == null){
//            System.out.println("Firsttime");
//            list.add(room);
//            session.setAttribute("rooms", list);
//        } else {
//           System.out.println("Not Firsttime");
//           list = (List<Room>)session.getAttribute("rooms");
//           list.add(room);
//           session.setAttribute("rooms", list);
//        }
//        String jSon = null;
//        jSon = new Gson().toJson(list);
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        System.out.println(jSon);
//        out.write(jSon);
//
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomNo = req.getParameter("roomno");
        String actionCommand = req.getParameter("actionCommand");

        if ("add".equals(actionCommand)) {
            String roomTypeString = req.getParameter("roomtype");
            RoomType roomType = RoomType.from(roomTypeString);
            Float price = Float.valueOf(req.getParameter("roomprice"));
            Integer maxguest = Integer.valueOf(req.getParameter("maxguest"));

            Room r = new Room();
            r.setRoomNo(roomNo);
            r.setType(roomType.getName());
            r.setPrice(price);
            r.setGuestNum(maxguest);

            RoomService.add(r);
        }

        if ("delete".equals(actionCommand)) {
            RoomService.delete(roomNo);
        }

        if ("edit".equals(actionCommand)) {
            String roomTypeString = req.getParameter("roomtype");
            RoomType roomType = RoomType.from(roomTypeString);
            Float price = Float.valueOf(req.getParameter("roomprice"));
            Integer maxguest = Integer.valueOf(req.getParameter("maxguest"));

            Room room = new Room();
            room.setRoomNo(roomNo);
            room.setType(roomType.getName());
            room.setPrice(price);
            room.setGuestNum(maxguest);
            RoomService.edit(room);
        }

        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("roomList", Rooms.roomList);

        response.sendRedirect("room.jsp");
    }
}
