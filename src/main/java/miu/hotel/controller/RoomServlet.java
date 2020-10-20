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
        String roomNo = req.getParameter("roomNo");
        String addString = req.getParameter("add");
        boolean isAdd = Boolean.valueOf(addString);
        if (isAdd) {
            String roomTypeString = req.getParameter("roomType");
            RoomType roomType = RoomType.from(roomTypeString);
            Float price = Float.valueOf(req.getParameter("price"));

            Room r = new Room();

            r.setRoomNo(roomNo);
            r.setType(roomType.getName());
            r.setPrice(price);
        }

        Optional<Room> roomOptional = RoomService.findRoomByRoomNum(roomNo);

        String deleteString = req.getParameter("delete");
        boolean isDelete = Boolean.valueOf(deleteString);
        if (isDelete) {
            roomOptional.ifPresent(r -> r.setActive(false));
        }

        String editString = req.getParameter("edit");
        boolean isEdit = Boolean.valueOf(editString);
        if (isEdit) {
            String roomTypeString = req.getParameter("roomType");
            RoomType roomType = RoomType.from(roomTypeString);
            Float price = Float.valueOf(req.getParameter("price"));

            roomOptional.ifPresent(r -> {
                r.setType(roomType.getName());
                r.setPrice(price);
            });
        }

        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("roomList", Rooms.roomList);

        response.sendRedirect("room.jsp");
    }
}
