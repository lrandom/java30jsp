package com.example.javaweb30jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletHome", value = "/ServletHome")
public class ServletHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] listName = {"Nguyen Van A", "Nguyen Van B", "Nguyen Van C"};
        request.setAttribute("list", listName);
        request.setAttribute("age", 18);
        String language = "en";
        if (request.getSession().getAttribute("language") != null) {
            language = (String) request.getSession().getAttribute("language");
        }
        request.setAttribute("language", language);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = (String) request.getParameter("language");
        request.getSession().setAttribute("language", language);
        response.sendRedirect("ServletHome");
    }
}
