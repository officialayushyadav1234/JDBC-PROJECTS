package com.jspider.jdbc_prepared_statement_crud_operation.Service;

import com.jspider.jdbc_prepared_statement_crud_operation.dto.Student;
import com.jspider.jdbc_statement_crud_operation.dao.StudentDao;

public class StudentService {

	StudentDao dao = new StudentDao();
	
	public Student saveStudentService(Student student) {
		
		if(student.getName().length() <= 8) {
			return dao.saveStudentDao(student);
		}
		else {
			return null;
		}
	}
}