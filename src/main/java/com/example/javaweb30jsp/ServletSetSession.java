package com.example.javaweb30jsp;

import com.example.javaweb30jsp.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletSetSession", value = "/ServletSetSession")
public class ServletSetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = new User();
        user.setId("1");
        user.setEmail("Luann4099@gmail.com");
        user.setPassword("ahihi");
        session.setAttribute("user", user);
        session.setAttribute("abc", "abc");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
