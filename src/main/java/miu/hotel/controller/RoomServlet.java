package miu.hotel.controller;

import com.google.gson.Gson;
import miu.hotel.database.Rooms;
import miu.hotel.model.Room;

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

@WebServlet(name = "RoomServlet", urlPatterns = {"/RoomServlet"})
public class RoomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost of RoomServlet");
        String roomNo = request.getParameter("roomno");
        String roomType = request.getParameter("roomtype");
        float  roomPrice= Float.parseFloat(request.getParameter("roomprice"));
        int maxGuest = Integer.parseInt(request.getParameter("maxguest"));
        Room room = new Room(roomNo, roomType, roomPrice, maxGuest);
        System.out.println(room.getRoomNo());
        HttpSession session = request.getSession();
        List<Room> list = new ArrayList<Room>();
        if (session.getAttribute("rooms") == null){
            System.out.println("Firsttime");
            list.add(room);
            Rooms.roomList.add(room);
            session.setAttribute("rooms", list);
        } else {
           System.out.println("Not Firsttime");
           list = (List<Room>)session.getAttribute("rooms");
           list.add(room);
           Rooms.roomList.add(room);
           session.setAttribute("rooms", list);
        }
        String jSon = null;
        jSon = new Gson().toJson(list);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        System.out.println(jSon);
        out.write(jSon);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
