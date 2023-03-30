package com.example.javaweb30jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAddCookie", value = "/ServletAddCookie")
public class ServletAddCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("school", "niit");
        cookie.setMaxAge(60 * 60 * 24 * 7);// 7 days
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
