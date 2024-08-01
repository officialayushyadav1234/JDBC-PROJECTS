package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductInsertController {
	public static void main(String[] args) {
		Connection connection = null;
//		step 1: load|register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Step 2: create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-a3";
			String username = "root";
			String password = "Tiger";
		    connection = DriverManager.getConnection(url, username, password);
//			step 3: create statement
			Statement statement = connection.createStatement();
//			Step 4: execute query
			String insertQuery = "insert into product(id, name, color, price) values (103, 'marker', 'black', 30),(104, 'marker','blue',45)";
			statement.execute(insertQuery);
			System.out.println("Data is stored");
			System.out.println(connection);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Data not stored");
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
