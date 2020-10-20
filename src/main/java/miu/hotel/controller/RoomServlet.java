package miu.hotel.controller;

import com.google.gson.Gson;
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

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost of RoomServlet");
        String roomNo = request.getParameter("roomno");
        String roomType = request.getParameter("roomtype");
        float  roomPrice= Float.parseFloat(request.getParameter("roomprice"));
        int maxGuest = Integer.parseInt(request.getParameter("maxguest"));
        Room room = new Room(roomNo, roomType, roomPrice, maxGuest);
        HttpSession session = request.getSession();
        List<Room> list = new ArrayList<Room>();
        if (session.getAttribute("listroom") == null){
            list.add(room);
            session.setAttribute("list", room);
        } else {
           list = (List<Room>)session.getAttribute("listroom");
           list.add(room);
           session.setAttribute("list", room);
        }
        String jSon = null;
        jSon = new Gson().toJson(list);
        PrintWriter out = response.getWriter();
        out.write(jSon);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
