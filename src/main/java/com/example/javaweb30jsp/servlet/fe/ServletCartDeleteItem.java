package com.example.javaweb30jsp.servlet.fe;

import com.example.javaweb30jsp.Config;
import com.example.javaweb30jsp.models.CartItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCartDeleteItem", value = "/delete-cart-item")
public class ServletCartDeleteItem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute(Config.CART_NAME) != null) {
            ArrayList<CartItem> cartItems = (ArrayList<CartItem>) httpSession.getAttribute(Config.CART_NAME);
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId() == productId) {
                    cartItems.remove(cartItem);
                    break;
                }
            }
        }
        response.sendRedirect("cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
