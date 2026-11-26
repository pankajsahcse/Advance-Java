package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	static Connection conn;

	public static Connection getConnection() {

		String url = "jdbc:mysql://192.168.10.115:3306/dac54";
		try {

			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url, "dac54", "welcome");
			}
			return conn;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
}
