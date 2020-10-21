package miu.hotel.controller;

import miu.hotel.database.Rooms;
import miu.hotel.enums.RoomType;
import miu.hotel.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name = "EditRoomServlet", urlPatterns={"/EditRoomServlet"})
public class EditRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomNo = request.getParameter("roomNo");
        Optional<Room> room = Rooms.roomList.stream()
                                .filter(room1 -> room1.getRoomNo().equals(roomNo)).findFirst();
        request.setAttribute("room", room.orElse(null) );
        request.setAttribute("roomTypes", Arrays.stream(RoomType.values()).map(RoomType::getName).collect(Collectors.toList()));
        request.getRequestDispatcher("editroom.jsp").forward(request, response);
    }
}
