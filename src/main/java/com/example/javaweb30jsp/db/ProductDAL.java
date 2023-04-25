package com.example.javaweb30jsp.db;

import com.example.javaweb30jsp.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAL extends DB {
    public static final String TABLE_NAME = "products";

    public ArrayList<Product> getList() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        ArrayList<Product> list = new ArrayList<>();
        Connection connection = this.connect();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setPath(resultSet.getString("path"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getById(String id) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE id=" + id;
        Connection connection = this.connect();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            Product product = new Product();
            while (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setPath(resultSet.getString("path"));
            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
