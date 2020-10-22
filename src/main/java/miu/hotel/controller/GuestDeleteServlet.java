package miu.hotel.controller;

import com.google.gson.Gson;
import miu.hotel.database.Guests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GuestDeleteServlet", urlPatterns = {"/GuestDeleteServlet.ajax"})
public class GuestDeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestId = request.getParameter("guestid");
//        List<Guest> list = Guests.guestlist;
//        if (list==null) {
//            list = new ArrayList<>();
//   }
//        Guests.guestlist = list.stream().filter( e -> !e.getId().equals(guestId)).collect(Collectors.toList());
        Guests.removeById(guestId);

//        Guests.guestlist.remove(guestId);
        String json ="";
        json = new Gson().toJson(Guests.guestlist);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write(json);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
