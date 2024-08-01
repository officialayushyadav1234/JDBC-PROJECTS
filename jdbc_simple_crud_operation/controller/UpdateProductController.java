package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProductController {
      public static void main(String[] args){
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
			String updateProductColorQuery = "update product set color = 'yellow' where id = 101";
//			this method will return 0 and 1
			int a = statement.executeUpdate(updateProductColorQuery);
			if(a == 1) {
				System.out.println("Data will be updated");
			}else {
				System.out.println("data will not be updated");
			}
			
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
