package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VoteridController {

	public static void main(String[] args) {
		
		try {
			//Step 1: Load And Register Driver
		    Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2: Create Statement
			String url = "jdbc:mysql://localhost:3306/jdbc-a3";
		    String username = "root";
		    String password = "Tiger";
		   
		    //Create connection
		  Connection connection = DriverManager.getConnection(url, username, password);
		  Statement statement = connection.createStatement();
		  Scanner sc = new Scanner (System.in);
		  System.out.println("Enter Your age:");
		  int age = sc.nextInt();
		  // Check if age is 18 or Above
		  
		  if(age>=18) {
			  //Construct SQL
			  System.out.println("Enter Id:");
			  int id =sc.nextInt();
			  System.out.println("Enter Name:"); 
			  sc.nextLine();
			  String name = sc.nextLine();
			  System.out.println("Enter Date Of Birth:(YYYY-MM-DD)");
			  String dob = sc.nextLine();
			  System.out.println("Enter Address:");
			  String add = sc.nextLine();
			  System.out.println("Enter Father's Name: ");
			  String fname = sc.nextLine();
			  System.out.println("Enter Gender:");
			  String gender = sc.nextLine();
			  String insertQuery = "insert into voterid (id,name,dob,add,fname,gender) VALUES(?,?,?,?,?,?)";
			  
			  //Step 4: Execute Query
			  try (PreparedStatement pstmt=connection.prepareStatement(insertQuery)){
				 
				  pstmt.setInt(1, id);
				  pstmt.setString(2, name);
				  pstmt.setString(3, dob);
				  pstmt.setString(4, add);
				  pstmt.setString(5, fname);
				  pstmt.setString(6, gender);
				  System.out.println("Data Inserted Successfully");
			  } catch(Exception e) {
				  System.out.println("Error Executing Query");
			  }
		  } else {
			  System.out.println("Sorry You are Not eligible to vote");
		  }
		  
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Data is Not stored");
		}
	}
	
}
