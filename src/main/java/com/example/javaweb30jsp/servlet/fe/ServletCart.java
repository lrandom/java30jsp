package com.example.javaweb30jsp.servlet.fe;

import com.example.javaweb30jsp.Config;
import com.example.javaweb30jsp.models.CartItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCart", value = "/cart")
public class ServletCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        ArrayList<CartItem> cartItems = new ArrayList<>();
        if (httpSession.getAttribute(Config.CART_NAME) != null) {
            cartItems = (ArrayList<CartItem>) httpSession.getAttribute(Config.CART_NAME);
        }
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
