package com.customer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionCustomer {
	static String drivername="com.mysql.cj.jdbc.Driver";
	static String username="root";
	static String userpass="root";
	static String url="jdbc:mysql://localhost:3306/book";
	static Connection conn;

	public static Connection getConnect() {
		try {
			Class.forName(drivername);
			System.out.println("Driver loded");
			conn=DriverManager.getConnection(url, username, userpass);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
