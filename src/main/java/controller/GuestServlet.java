
package controller;


import app.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet(name = "GuestInfoServlet", urlPatterns = {"*.ajax"})
public class GuestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Go in Guest Servlet");
        Date dob=null;
//        if (request.getParameter("dob")!=null)
//            dob=(LocalDate.parse(request.getParameter("dob")));
        String guestId = request.getParameter("guestid");
        String firstname= request.getParameter("firstname");
        String lastname= request.getParameter("lastname");
        String address= request.getParameter("address");
        String status = request.getParameter(("status"));
        HttpSession session = request.getSession();
        List<Guest> list = (List<Guest>) session.getAttribute(("guestlist"));
        if (list==null) {
            list = (List<Guest>) session.getAttribute(("guestlist"));
            session = request.getSession();

        }
        long guestid = list.size()+1;
        list.add(new Guest(guestId,firstname,lastname,null,address,status));
        session.setAttribute("guestlist", list);


        request.getRequestDispatcher("guest.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
