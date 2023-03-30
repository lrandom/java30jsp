package com.example.javaweb30jsp.servlet.auth;

import com.example.javaweb30jsp.Config;
import com.example.javaweb30jsp.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletProfile", value = "/profile")
public class ServletProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("user") == null) {
            response.sendRedirect(Config.BASE_URL+"login");
        } else {
            User user = (User) httpSession.getAttribute("user");
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
