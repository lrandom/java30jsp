package com.example.javaweb30jsp;

import com.example.javaweb30jsp.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletGetSession", value = "/ServletGetSession")
public class ServletGetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("user") != null){
            User user = (User) httpSession.getAttribute("user");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("<h1>" + user.getId() + "</h1>");
            response.getWriter().write("<h1>" + user.getEmail() + "</h1>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
