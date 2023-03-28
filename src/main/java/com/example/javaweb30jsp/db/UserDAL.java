package com.example.javaweb30jsp.db;

import com.example.javaweb30jsp.helpers.Helper;
import com.example.javaweb30jsp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAL extends DB{
    public static final String TABLE_NAME = "users";
    public User getUserByEmailAndPassword(String email, String password) {
        try {
            Connection connection = this.connect();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE email = ? AND password = ?");
            preparedStatement.setString(1, email);
            String encryptPassword = Helper.MD5(Helper.MD5(password+"abc"));
            System.out.println("PASSWORD ENCRYPT");
            System.out.println(encryptPassword);
            preparedStatement.setString(2, encryptPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
