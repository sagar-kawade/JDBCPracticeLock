package com.JDBCProject.in;

import java.sql.*;

public class StudentData {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String USER = "root";
	private static String PASS = "root";
	private static String URL = "jdbc:mysql://localhost:3306/StudentDetails";

	public static void main(String[] args) {
		System.out.println("Main start...");
		Connection conn = null;
		Statement stmt = null;
		try {
			System.out.println("Register Driver...");
			Class.forName(driverName);
			System.out.println("Create Connection...");

			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Create Statement...");

			stmt = conn.createStatement();
			System.out.println("Excute  FIRST Query...");

			String query = "select * from Studentdetail";
			System.out.println("Retrive in Result Set...");

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				int age = rs.getInt(2);
				String fName = rs.getString(3);
				String lName = rs.getString(4);

				System.out.print("studentDetails ->" + " " + id + " " + age + " " + fName + " " + lName);
				System.out.println();
			}
			System.out.println("Second query INSERT...");

			String sql = "INSERT INTO Studentdetail(ID,AGE,FIRST_NAME,LAST_NAME)" + "VALUES (108, 31, 'Anni','Jee')";
			stmt.execute(sql);

			System.out.println("insert successfully");

			System.out.println("Third query UPDATE...");
			String sql2 = "update Studentdetail set AGE=52 where id=102";
			stmt.executeUpdate(sql2);
			System.out.println("update successfully");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {

				e2.printStackTrace();

			}
			System.out.println("Finally Done ...");

		}
		System.out.println("Main ends...");

	}

}
