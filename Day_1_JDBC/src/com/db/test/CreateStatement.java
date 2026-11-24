package com.db.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DBConnect;

public class CreateStatement {
	public static void main(String[] args) {

		System.out.println("------------------------------");

		// Creating a Statement for Selecting Or Read

		try (Connection conn = DBConnect.getConnection()) {

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from dept");

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));

				System.out.println("------------------------------");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Creating a Statement for Inserting

		try (Connection conn = DBConnect.getConnection()) {

			int deptno = 1;
			String dname = "lab";
			String loc = "pune";
			String pwd = "pank@12";
			String startedon = "24/11/2026";

			Statement st = conn.createStatement();

			String query = "INSERT INTO DEPT VALUES(" + deptno + ",'" + dname + "','" + loc + "','" + pwd + "','"
					+ startedon + "')";

			int i = st.executeUpdate(query);

			if (i > 0) {
				System.out.println("Data Insert SuccessFully");
			} else {
				System.out.println("Something went wrong on Server");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Creating a Statement for Updating

		try (Connection conn = DBConnect.getConnection()) {

			int deptno = 1;
			String dname = "CSE";
			String loc = "pune";
			String pwd = "pank@123";
			String startedon = "24/11/2026";
			Statement st = conn.createStatement();

			String query = "UPDATE DEPT SET DNAME = '" + dname + "', LOC = '" + loc + "', PWD = '" + pwd
					+ "', STARTEDON = '" + startedon + "' WHERE DEPTNO = " + deptno;

			int i = st.executeUpdate(query);

			if (i > 0) {
				System.out.println("Data Updated SuccessFully");
			} else {
				System.out.println("Something went wrong on Server");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Creating a Statement for DELETE

		try (Connection conn = DBConnect.getConnection()) {

			int deptno = 1;
			Statement st = conn.createStatement();
			String query = "DELETE FROM DEPT WHERE DEPTNO =" + deptno;

			int i = st.executeUpdate(query);

			if (i > 0) {
				System.out.println("Data Delete Successfully");
			} else {
				System.out.println("Data not Found");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
