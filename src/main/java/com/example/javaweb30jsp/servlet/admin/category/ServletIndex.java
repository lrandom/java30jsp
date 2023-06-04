package com.example.javaweb30jsp.servlet.admin.category;

import com.example.javaweb30jsp.db.CategoryDAL;
import com.example.javaweb30jsp.models.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCategoryIndex", value = "/admin-category")
public class ServletIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAL categoryDAL = new CategoryDAL();
        ArrayList<Category> categories = categoryDAL.getList();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("WEB-INF/jsp/admin/categories/index.jsp").forward(req, resp);
    }
}
