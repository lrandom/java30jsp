package com.example.javaweb30jsp.servlet.admin.category;

import com.example.javaweb30jsp.Config;
import com.example.javaweb30jsp.db.CategoryDAL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletCategoryDelete", value = "/admin-category-delete")
public class ServletDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CategoryDAL categoryDAL = new CategoryDAL();
        categoryDAL.deleteById(id);
        resp.sendRedirect(Config.BASE_URL + "/admin-category");
    }
}
