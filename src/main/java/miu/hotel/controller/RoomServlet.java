package miu.hotel.controller;

import com.google.gson.Gson;
import miu.hotel.database.Rooms;
import miu.hotel.enums.RoomType;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomNo = req.getParameter("roomNo");
        Optional<Room> roomOptional = RoomService.findRoomByRoomNum(roomNo);

        String isDeleteString = req.getParameter("isDelete"); data: {

        }
        boolean isDelete = Boolean.valueOf(isDeleteString);
        if (isDelete) {
            roomOptional.ifPresent(r -> r.setActive(false));
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
