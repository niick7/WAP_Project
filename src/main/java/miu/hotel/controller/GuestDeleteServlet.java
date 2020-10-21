package miu.hotel.controller;

import com.google.gson.Gson;
import miu.hotel.database.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "GuestDeleteServlet", urlPatterns = {"/GuestDeleteServlet.ajax"})
public class GuestDeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String guestId = request.getParameter("guestid");
        System.out.println("GuestDeleteServlet");

        HttpSession session = request.getSession();

        List<Guest> list = (List<Guest>) session.getAttribute(("guestlist"));
        if (list==null) {
            list = new ArrayList<>();

            session = request.getSession();
            session.setAttribute("guestlist", list);

        }
        //  long guestid = list.size()+1;

        List<Guest> ll = list.stream().filter( e -> !e.getId().equals(guestId)).collect(Collectors.toList());
        session.setAttribute("guestlist", ll);
        //   System.out.println("address: "+address +" " + guestId +" " + firstname + " "+ lastname +" "+address +" "+ dob +" "+ gender);

        System.out.println("List guest: "+list.size());
        String json ="";
        json = new Gson().toJson(ll);
        System.out.println("json: "+ json);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write(json);

        //  request.getRequestDispatcher("guest.jsp").forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
