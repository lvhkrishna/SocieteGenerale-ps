package com.SGenerale.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String fName;
	private String lName;
	private String gender;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	private String dept;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String fName, String lName, String gender, LocalDate dob, String dept) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.dob = dob;
		this.dept = dept;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", dob=" + dob + ", dept="
				+ dept + "]";
	}
	
}
