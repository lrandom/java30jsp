package com.example.javaweb30jsp.servlet.auth;

import com.example.javaweb30jsp.Config;
import com.example.javaweb30jsp.db.UserDAL;
import com.example.javaweb30jsp.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            resp.sendRedirect(Config.BASE_URL + "profile");
            return;
        }
        //load trang jsp lên khi vào trang login
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAL userDal = new UserDAL();
        User user = userDal.getUserByEmailAndPassword(email, password);
        if (user != null) {
            //login thành công
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(Config.BASE_URL + "profile");
        } else {
            //login thất bại
            //gui thong bao loi ve trang login
            req.setAttribute("error", "Email hoặc mật khẩu không đúng");
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }
}
