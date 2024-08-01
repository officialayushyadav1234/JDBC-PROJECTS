package com.jspider.jdbc_prepared_statement_crud_operation.dto;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.Objects;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11;
	private int id;
	private String name;
	private String email;
	private long phone;
	private LocalDate dob;
	private String gender;
	
	// Alt+s+a parameterized and non parameterized constructor
	
	public Student() {
		super();
	}
	
	
	
    public Student(int id, String name, String email, long phone, LocalDate dob, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
	}



	public Student(String name,String email,long phone,LocalDate dob,String gender) {
		
		super();
		this.name=name;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.dob=dob;
		this.gender=gender;
	}
	
    
	//Alt+S+R to generate getter and setter method
	

	
	public Student(String name2, String email2, long phone2, String dob2, LocalDate localDate, String gender2) {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	// Alt+shft+s+h for hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(dob, email, gender, id, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(name, other.name)
				&& phone == other.phone;
	}

	
	// toString() Alt+shift+S+S+H
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob
				+ ", gender=" + gender + "]";
	}

	
}
