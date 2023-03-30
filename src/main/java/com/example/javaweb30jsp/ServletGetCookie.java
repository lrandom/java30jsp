package com.example.javaweb30jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletGetCookie", value = "/ServletGetCookie")
public class ServletGetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter prp= response.getWriter();
        Cookie[] cookies = request.getCookies();
        Cookie cookie= getCookie(cookies,"school");
        response.setContentType("text/html;charset=UTF-8");
        if (cookie != null) {
            prp.write("<h1>" + cookie.getValue() + "</h1>");
        } else {
            prp.write("<h1>Cookie not found</h1>");
        }
    }

    private Cookie getCookie(Cookie[] cookies,String name) {
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals(name)) {
                    return cookie;
                }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
