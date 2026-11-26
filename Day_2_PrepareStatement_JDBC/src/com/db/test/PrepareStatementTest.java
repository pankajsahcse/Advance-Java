package com.db.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.db.DBConnect;

public class PrepareStatementTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice = -1;

		do {
			System.out.println("""
					1. INSERT
					2. SELECT
					3. Exit
					Enter Your Choice
					""");

			choice = sc.nextInt();

			switch (choice) {
			case 1 -> {
				System.out.println("Enter your User Name");
				String u = sc.next();

				

				System.out.println("Enter your Password");
				String p = sc.next();

				String query = "INSERT INTO USER (UNAME,PASSWD) VALUES(?,?)";
				try (Connection conn = DBConnect.getConnection()) {
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, u);
					pst.setString(2, p);

					int i = pst.executeUpdate();

					if (i > 0) {
						System.out.println("Insert Successfully ");
					} else {
						System.out.println("Something Wrong");
					}

				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			case 2 -> {

				System.out.println("Enter your User Name");
				String u = sc.next();


				System.out.println("Enter your Password");
				String p = sc.next();

				String q = "SELECT * FROM USER WHERE UNAME = ? AND PASSWD = ?";

				try (Connection conn = DBConnect.getConnection()) {
					PreparedStatement pst = conn.prepareStatement(q);
					pst.setString(1, u);
					pst.setString(2, p);

					ResultSet rs = pst.executeQuery();

					while (rs.next()) {
						System.out.println(rs.getString(2));
						System.out.println(rs.getString(3));
						System.out.println("User Auntheticated");
					}

				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

			}
		} while (choice != 3);

	}

}
