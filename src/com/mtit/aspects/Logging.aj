package com.mtit.aspects;

import java.sql.SQLException;

import com.mtit.dataaccess.Constants;
import com.mtit.dataaccess.Employee;

public aspect Logging {
	before() : execution(* getConnection()) {
		System.out.println("************************************************************************");
		System.out.println(Constants.LOG_TAG + "Accessing Database Connection..");
		System.out.println("************************************************************************");
	}
	
	after() : execution(* createEmployeeTable()) {
		System.out.println("************************************************************************");
		System.out.println(Constants.LOG_TAG + "Created Employee Table..");
		System.out.println("************************************************************************");
	}
	
	after() returning(Employee emp) : execution(* loginUser(..)) {
		
		System.out.println("************************************************************************");
		if(emp == null) {
			System.out.println(Constants.LOG_TAG + "User login failed.");
		} else {
			System.out.println(Constants.LOG_TAG + "User logged in : " + emp.getFullName());
		}
		System.out.println("************************************************************************");
	}
	//createEmployeeTable
	
	
	
	after() throwing(SQLException ex) : execution(* *(..)) {
		System.out.println("************************************************************************");
		System.out.println(Constants.LOG_TAG + "Exception thrown : ");
		ex.printStackTrace();
		System.out.println("************************************************************************");
	}
	
	before() : execution(* com.mtit.service.*.*(..)) {
		System.out.println("************************************************************************");
		System.out.println(Constants.LOG_TAG + "Accessing Service Layer..");
		System.out.println("************************************************************************");
	}
}
