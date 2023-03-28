package com.example.javaweb30jsp.servlet;

import com.example.javaweb30jsp.db.UserDAL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "loginServlet", value = "/do-login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println("EMAIL");
        System.out.println("email");
        System.out.println("PASSWORD");

        UserDAL userDal = new UserDAL();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        if (userDal.getUserByEmailAndPassword(email, password) != null) {
            out.println("Login success");
        } else {
            out.println("Login failed");
        }
    }
}
