package miu.hotel.controller;

import com.google.gson.Gson;
import miu.hotel.database.Guest;
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
import java.util.stream.Collectors;

@WebServlet(name = "GuestReportServlet", urlPatterns = {"/GuestReportServlet.ajax"})
public class GuestReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int frommonth = (LocalDate.parse(request.getParameter("from")).getMonthValue());
        int fromday = (LocalDate.parse(request.getParameter("from")).getDayOfMonth());
        int fromyear = (LocalDate.parse(request.getParameter("from")).getYear());


        int tomonth = (LocalDate.parse(request.getParameter("to")).getMonthValue());
        int today = (LocalDate.parse(request.getParameter("to")).getDayOfMonth());
        int toyear = (LocalDate.parse(request.getParameter("to")).getYear());
        response.setContentType("application/json");
    List<Guest> list= Guests.guestlist.stream()
            .filter(e -> e.getCreatedMonth()>=frommonth)
            .filter(e -> e.getCretedDay()>=fromday)
            .filter(e -> e.getCreatedYear()>=fromyear)
            .filter(e -> e.getCreatedMonth()<=tomonth)
            .filter(e -> e.getCretedDay()<=today)
            .filter(e -> e.getCreatedYear()<=toyear)
            .collect(Collectors.toList());
        //   System.out.println("address: "+address +" " + guestId +" " + firstname + " "+ lastname +" "+address +" "+ dob +" "+ gender);

        String json = "";
        json = new Gson().toJson(list);
        System.out.println("json: " + json);
        response.setContentType("application/json");
        out.write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
