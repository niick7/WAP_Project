package miu.hotel.controller;


import com.google.gson.Gson;
import miu.hotel.model.Guest;
import miu.hotel.database.Guests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "GuestUpdateServlet", urlPatterns = {"/GuestUpdateServlet.ajax"})
public class GuestUpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Reprot form");
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        HttpSession session =  request.getSession();
     //   List<Guest> list = (List<Guest>) session.getAttribute("guestlist");
        List<Guest> list = Guests.guestlist;
        LocalDate dob=null;
        if (request.getParameter("dob")!=null)
            dob=(LocalDate.parse(request.getParameter("dob")));

        String guestId = request.getParameter("guestid");
        String firstname= request.getParameter("firstname");
        String lastname= request.getParameter("lastname");
        String address= request.getParameter("address");
        String gender = request.getParameter(("gender"));
        LocalDate finalDob = dob;
        Guest guest=list.stream().filter(a -> a.getId().equals(guestId)).findFirst().get();
        System.out.println(guest);
        guest.setAddress(address);
        guest.setDob(finalDob);
        guest.setFirsName(firstname);
        guest.setGender(gender);
        guest.setLastName(lastname);
        String json = "";
        json = new Gson().toJson(list);
        System.out.println("json: " + json);
        response.setContentType("application/json");
        out.write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
