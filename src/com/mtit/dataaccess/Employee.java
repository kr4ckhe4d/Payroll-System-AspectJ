package com.mtit.dataaccess;

public class Employee {
	private int eID;
	private String fullName;
	private String eDesignation;
	private double eSalary;
	private double eEPF;
	
	public Employee(int id, String fName, String designation, double salary, double epf) {
		this.eID = id;
		this.fullName = fName;
		this.eDesignation = designation;
		this.eSalary = salary;
		this.eEPF = epf;
	}

	public int getID() {
		return eID;
	}

	public void setID(int id) {
		this.eID = id;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fName) {
		this.fullName = fName;
	}

	public String getDesignation() {
		return eDesignation;
	}

	public void setDesignation(String designation) {
		this.eDesignation = designation;
	}

	public double getSalary() {
		return eSalary;
	}
	
	public double getNetSalary(int hours){
		return this.getSalary() + hours*1000.00 - this.getSalary() * this.getEPF();
	}
	
	public double getEPFAmt() {
		return eEPF * getSalary();
	}
	
	public void setSalary(double salary) {
		this.eSalary = salary;
	}

	public double getEPF() {
		return eEPF;
	}

	public void setEPF(double epf) {
		this.eEPF = epf;
	}

}
