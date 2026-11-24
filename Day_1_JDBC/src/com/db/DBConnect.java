package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
    public static Connection getConnection() {
        String url = "jdbc:mysql://192.168.10.115:3306/dac54";

        try {
        	System.out.println("Connection Successfull");
            return DriverManager.getConnection(url, "dac54", "welcome");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
