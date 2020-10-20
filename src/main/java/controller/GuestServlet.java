
package controller;


import app.Guest;
import com.google.gson.Gson;

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
import java.util.Date;
import java.util.List;


@WebServlet(name = "GuestServlet", urlPatterns = {"*.ajax"})
public class GuestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Go in Guest Servlet");
        LocalDate dob=null;
        if (request.getParameter("dob")!=null)
            dob=(LocalDate.parse(request.getParameter("dob")));
        String guestId = request.getParameter("guestid");
        String firstname= request.getParameter("firstname");
        String lastname= request.getParameter("lastname");
        String address= request.getParameter("address");
        String gender = request.getParameter(("gender"));

        System.out.println("Go in Guest Servlet");

        HttpSession session = request.getSession();

        List<Guest> list = (List<Guest>) session.getAttribute(("guestlist"));
        if (list==null) {
            list = new ArrayList<>();

            session = request.getSession();
            session.setAttribute("guestlist", list);

        }
      //  long guestid = list.size()+1;
        System.out.println("address: "+address +" " + guestId +" " + firstname + " "+ lastname +" "+address +" "+ dob +" "+ gender);

        list.add(new Guest(guestId,firstname,lastname,dob,address,gender));
        session.setAttribute("guestlist", list);
        System.out.println("address: "+address +" " + guestId +" " + firstname + " "+ lastname +" "+address +" "+ dob +" "+ gender);

        System.out.println("List guest: "+list.size());
        String json ="";
        json = new Gson().toJson(list);
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
