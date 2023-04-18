package com.example.javaweb30jsp;

import com.example.javaweb30jsp.db.ProductDAL;
import com.example.javaweb30jsp.models.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletHome", value = "/ServletHome")
public class ServletHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAL productDAL = new ProductDAL();
        ArrayList<Product> products = productDAL.getList();
        request.setAttribute("products", products);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = (String) request.getParameter("language");
        request.getSession().setAttribute("language", language);
        response.sendRedirect("ServletHome");
    }
}
