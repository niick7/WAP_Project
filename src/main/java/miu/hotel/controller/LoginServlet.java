package miu.hotel.controller;

import miu.hotel.database.Login;
import miu.hotel.database.Users;
import miu.hotel.model.User;

import javax.servlet.ServletException;
import javax.servlet.WriteListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        System.out.println ("doPost");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        User u = Users.userList.get(0);
        if ((username.equals(u.getUserName())) && (password.equals(u.getPassword()))){
            session.setAttribute("username", username);
            response.sendRedirect("room.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<font color = 'red'> Either username or password is not correct</font>");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        doPost(request, response);
    }
}
