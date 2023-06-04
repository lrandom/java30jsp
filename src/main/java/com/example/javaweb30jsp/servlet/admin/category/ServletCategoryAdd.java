package com.example.javaweb30jsp.servlet.admin.category;

import com.example.javaweb30jsp.Config;
import com.example.javaweb30jsp.db.CategoryDAL;
import com.example.javaweb30jsp.models.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//CRUD - C- Create, R- Read, U - Update, D- Delete
//CRUD các table
@WebServlet(name = "ServletAddCategory", value = "/admin-category-add")
public class ServletCategoryAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("messageSuccess") != null) {
            req.getSession().removeAttribute("messageSuccess");
        }
        if (req.getSession().getAttribute("messageError") != null) {
            req.getSession().removeAttribute("messageError");
        }
        req.getRequestDispatcher("WEB-INF/jsp/admin/categories/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        CategoryDAL categoryDAL = new CategoryDAL();

        if (categoryDAL.insert(new Category("", name))) {
            //FLASH SESSION - 1 session chỉ tồn tại trong 1 request
            req.getSession().setAttribute("messageSuccess", "Thêm thành công");
        } else {
            req.getSession().setAttribute("messageError", "Thêm thất bại");
        }
        //resp.sendRedirect(Config.BASE_URL + "/admin-category-add");
        req.getRequestDispatcher("WEB-INF/jsp/admin/categories/add.jsp").forward(req, resp);
    }
}
