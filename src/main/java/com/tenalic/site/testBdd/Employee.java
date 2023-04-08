package com.tenalic.site.testBdd;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Column(name = "employee_name")
	private String employeeName;

	@Id
	@Column(name = "employee_id")
	private String employeeId;

	@Column(name = "employee_address")
	private String employeeAdress;

	@Column(name = "employee_email")
	private String employeEmail;

	public Employee() {

	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeAdress() {
		return employeeAdress;
	}

	public void setEmployeeAdress(String employeeAdress) {
		this.employeeAdress = employeeAdress;
	}

	public String getEmployeEmail() {
		return employeEmail;
	}

	public void setEmployeEmail(String employeEmail) {
		this.employeEmail = employeEmail;
	}
	
	

}
