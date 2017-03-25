package com.mtit.service;

import java.sql.SQLException;
import java.util.List;

import com.mtit.dataaccess.Employee;
import com.mtit.dataaccess.EmployeeDataAccessLayer;
import com.mtit.dataaccess.EmployeeDataAccessLayerImpl;

public class EmployeeServiceImpl implements EmployeeService{

private EmployeeDataAccessLayer mEmployeeDataAccess = null;
	
	public EmployeeServiceImpl() {
		mEmployeeDataAccess = new EmployeeDataAccessLayerImpl();
	}
	
	@Override
	public boolean addEmployee(Employee emp) {
		try {
			return mEmployeeDataAccess.insertEmployee(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public void createEmployeeTbl(){
		try {
			mEmployeeDataAccess.createEmployeeTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployee(int id) {
		try {
			return mEmployeeDataAccess.getEmployee(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		try {
			return mEmployeeDataAccess.deleteEmployee(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Employee> getEmployees() {
		try {
			System.out.println("Get All Movies Called");
			return mEmployeeDataAccess.getAllEmployees();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
