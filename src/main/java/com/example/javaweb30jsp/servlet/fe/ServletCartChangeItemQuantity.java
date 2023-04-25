package com.example.javaweb30jsp.servlet.fe;

import com.example.javaweb30jsp.Config;
import com.example.javaweb30jsp.models.CartItem;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCartChangeItemQuantity", value = "/change-cart-item-quantity")
public class ServletCartChangeItemQuantity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        //check xem giỏ hàng có hay không
        if (httpSession.getAttribute(Config.CART_NAME) != null) {
            //lấy sp trong giỏ hàng ra
            ArrayList<CartItem> cartItems = (ArrayList<CartItem>) httpSession.getAttribute(Config.CART_NAME);
            //duyệt qua từng sp trong giỏ hàng
            for (CartItem cartItem : cartItems) {
                //nếu id của sp trong giỏ hàng = id của sp vừa thêm vào
                if (cartItem.getProduct().getId() == productId) {
                    //set lại số lượng của sp trong giỏ hàng
                    if (cartItem.getQuantity() + quantity <= 0) {
                        cartItem.setQuantity(1);
                    } else {
                        cartItem.setQuantity(cartItem.getQuantity() + quantity);
                    }
                    break;
                }
            }
            //set ngợc lại vào session
            httpSession.setAttribute(Config.CART_NAME, cartItems);
        }
        response.sendRedirect("cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
