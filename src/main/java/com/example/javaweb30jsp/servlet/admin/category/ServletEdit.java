package com.example.javaweb30jsp.servlet.admin.category;

import com.example.javaweb30jsp.db.CategoryDAL;
import com.example.javaweb30jsp.models.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletCategoryEdit", value = "/admin-category-edit")
public class ServletEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("messageSuccess") != null) {
            req.getSession().removeAttribute("messageSuccess");
        }
        if (req.getSession().getAttribute("messageError") != null) {
            req.getSession().removeAttribute("messageError");
        }
        String id = req.getParameter("id");
        CategoryDAL categoryDAL = new CategoryDAL();
        categoryDAL.getById(id);
        req.setAttribute("category", categoryDAL.getById(id));
        req.getRequestDispatcher("WEB-INF/jsp/admin/categories/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id"); //lấy id từ form
        String name = req.getParameter("name"); //lấy name từ form
        CategoryDAL categoryDAL = new CategoryDAL();
        if (categoryDAL.update(new Category(id, name))) {
            req.getSession().setAttribute("messageSuccess", "Sửa thành công");
        } else {
            req.getSession().setAttribute("messageError", "Sửa thất bại");
        }
        resp.sendRedirect(req.getContextPath() + "/admin-category-edit?id=" + id);
    }
}
