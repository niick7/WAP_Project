
package miu.hotel.controller;


import miu.hotel.model.Guest;
import com.google.gson.Gson;
import miu.hotel.database.Guests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


@WebServlet(name = "GuestServlet", urlPatterns = {"/GuestServlet.ajax"})
public class GuestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Go in Guest Servlet");
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
     //   List<Guest> db =  Guests.guestlist;
        List<Guest> list = Guests.guestlist;
        if (request.getParameter("guestid")!=null) {
            LocalDate dob = null;
            if (request.getParameter("dob") != null)
                dob = (LocalDate.parse(request.getParameter("dob")));
            String guestId = request.getParameter("guestid");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String address = request.getParameter("address");
            String gender = request.getParameter(("gender"));
            if (list.stream().filter(e -> e.getId().equals(guestId)).count()==1) {
                System.out.println("User Exists");
            }
            else
                list.add(new Guest(guestId, firstname, lastname, dob, address, gender));
        }

            String json = "";
            json = new Gson().toJson(list);
            System.out.println("json: " + json);
            response.setContentType("application/json");
            out.write(json);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
