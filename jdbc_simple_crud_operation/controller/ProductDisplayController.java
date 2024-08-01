package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDisplayController {

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
			String  ProductDisplayQuery = "select * from product";
			ResultSet rs = statement.executeQuery(ProductDisplayQuery);
			
			rs.next();
			int id = rs.getInt("id");
			System.out.println("Product id is: " +id);
			
			String name = rs.getString("name");
			System.out.println("Name is :"+name);
			
			String color = rs.getString("color");
			System.out.println("Color is :"+color);
			
			String price = rs.getString("price");
			System.out.println("Price is:" +price);
			
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
