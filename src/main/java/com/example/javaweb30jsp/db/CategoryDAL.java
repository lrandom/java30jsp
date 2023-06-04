package com.example.javaweb30jsp.db;

import com.example.javaweb30jsp.models.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDAL extends DB {
    public static final String TABLE_NAME = "categories";

    public ArrayList<Category> getList() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Category> list = new ArrayList<>();
        Connection connection = this.connect();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Category product = new Category();
                product.setId(resultSet.getString("id"));
                product.setName(resultSet.getString("name"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Category getById(String id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id=" + id;
        Connection connection = this.connect();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Category product = new Category();
            while (resultSet.next()) {
                product.setId(resultSet.getString("id"));
                product.setName(resultSet.getString("name"));
            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Category category) {
        try {
            String sql = "INSERT INTO " + TABLE_NAME + " (name) VALUES ('" + category.getName() + "')";
            Connection connection = this.connect();
            connection.createStatement().execute(sql);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public boolean deleteById(String id) {
        try {
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE id=" + id;
            Connection connection = this.connect();
            connection.createStatement().execute(sql);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public boolean update(Category category) {
        try {
            String sql = "UPDATE " + TABLE_NAME + " SET name='" + category.getName() + "' WHERE id=" + category.getId();
            Connection connection = this.connect();
            connection.createStatement().execute(sql);
            return true;
        } catch (Exception e) {

        }
        return false;
    }
}
