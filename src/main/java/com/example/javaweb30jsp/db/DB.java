package com.example.javaweb30jsp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public  Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/java30?useSSL=false", "root", "koodinh@");
        } catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        return null;
    }
}
