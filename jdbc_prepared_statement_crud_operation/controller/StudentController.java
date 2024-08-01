package com.jspider.jdbc_prepared_statement_crud_operation.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_crud_operation.Service.StudentService;
import com.jspider.jdbc_prepared_statement_crud_operation.dto.Student;
import com.jspider.jdbc_statement_crud_operation.dao.StudentDao;

public class StudentController {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Enter your option: " );
			System.out.println("1.Insert\n2.Display\n3.Update\n4.Delete\n5.SaveMultipleStudent");
			int input = sc.nextInt();
			
			switch(input) {
			
			case 1: {
				
				System.out.println("Enter the name:");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter the Email:");
				String email = sc.nextLine();
				System.out.println("Enter the Phone:");
				long phone =  sc.nextLong();
				sc.nextLine();
				System.out.println("Enter the Date Of Birth:");
				String dob =  sc.nextLine();
				System.out.println("Enter the Gender:");
				String gender = sc.nextLine();
		
//				String name = "Harsh";
//				String email = "harsh123@gmail.com";
//				long phone = 8866552857L;
//				String dob = "2002-08-05";
//				String gender = "male";
				
				Student student = new Student(name,email,phone,LocalDate.parse(dob),gender);
				
				StudentService service = new StudentService();
				
				Student student2 = service.saveStudentService(student);
				
				
				if(student2 != null) {
					System.out.println("Data Stored");
				}
				else {
					System.out.println("Data is Not Stored Please check your Code");
					System.out.println("Please Enter Only 8 Charactor");
				}
			 } break;
			
			 case 2: {
				
				Student [] student = dao.displayAllStudentDao(); 
				for (Student student2 : student) {
					
					if(student2 != null) {
						System.out.println(student2);
					}
				}
			} break;
			
			 case 3:{
				 
				 System.out.println("Enter Student id to Update student name");
				 int id = sc.nextInt();
				 System.out.println("Enter Student new name to Update");
				 String name = sc.next();
				 
				 int value = dao.updateStudentNameByStudentIdDao(name, id);
				 if(value == 1)
					 System.out.println("Data Updated");
				 else
					 System.out.println("Invalid Id");
			 } break;
			 
			 case 4: {
				 
				 System.out.println("Enter Student id to delete ");
				 int id = sc.nextInt();
				 
				 int value  = dao.deleteStudentByIdDao(id);
				 if(value==1)
					 System.out.println("Data Deleted");
				 else
					 System.out.println("Invalid Id");
			} break;
			 
			 case 5: {
				 
				 System.out.println("How Students You want to add");
				 int size = sc.nextInt();
				 
				 List<Student> student = new ArrayList<Student>();
				 
				 int j=1;
				 List<Student> students = null;
				for(int i=0;i<size;i++) {
					 System.out.println("Enter student" +j+ "name");
					 String name = sc.next();
					 System.out.println("Enter student" +j+ "email");
					 sc.next();
					 String email = sc.next();
					 System.out.println("Enter student" +j+ "gender");
					 String gender = sc.next();
					 System.out.println("Enter student" +j+ "phone");
					 long phone = sc.nextLong();
					 System.out.println("Enter student" +j+ "dob");
					 // YYYY-MM-DD
					 String dob = sc.next();
					 
					 Student student1 = new Student(name,email,phone,LocalDate.parse(dob),gender);
					 
					 students.add(student1);
					 
					 j++;
				}
				 
			   dao.saveMultipleStudentDao(students);
				 
			 } break;
				
		 }
	}
  }
}
