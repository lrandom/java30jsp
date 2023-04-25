package com.example.javaweb30jsp.servlet.fe;

import com.example.javaweb30jsp.Config;
import com.example.javaweb30jsp.db.ProductDAL;
import com.example.javaweb30jsp.models.CartItem;
import com.example.javaweb30jsp.models.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletAddToCart", value = "/add-to-cart")
public class ServletAddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductDAL productDAL = new ProductDAL();
        Product product = productDAL.getById(id);
        HttpSession httpSession = request.getSession();
        ArrayList<CartItem> cartItems = new ArrayList<>();
        if (product != null) {
            //check xem có giỏ hàng hay chưa
            if (httpSession.getAttribute(Config.CART_NAME) == null) {
                //chưa có giỏ hàng
                CartItem cartItem = new CartItem(product, 1);
                cartItems.add(cartItem);
            } else {
                //đã có giỏ hàng
                //lấy ngược sản phẩm từ giỏ hàng ra gán vào biến để check
                cartItems = (ArrayList<CartItem>) httpSession.getAttribute(Config.CART_NAME);
                //check xem đã có sp trong giỏ hàng hay chưa
                int foundItemIndex = -1;
                for (int i = 0; i < cartItems.size(); i++) {
                    CartItem checkCartItem = cartItems.get(i);
                    if (checkCartItem.getProduct().getId() == product.getId()) {
                        foundItemIndex = i;
                        break;
                    }
                }
                if (foundItemIndex != -1) {
                    //tìm thầy 1 sản phẩm trong giỏ hanng tương ứng
                    cartItems.get(foundItemIndex).setQuantity(cartItems.get(foundItemIndex).getQuantity() + 1);
                } else {
                    cartItems.add(new CartItem(product, 1));
                }
            }//end if
            httpSession.setAttribute(Config.CART_NAME, cartItems);
        }

        response.sendRedirect("ServletHome");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
