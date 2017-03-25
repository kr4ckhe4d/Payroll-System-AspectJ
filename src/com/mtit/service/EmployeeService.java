package com.mtit.service;

import java.util.List;

import com.mtit.dataaccess.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee emp);
	public Employee getEmployee(int id);
	public boolean deleteEmployee(Employee emp);
	public List<Employee> getEmployees();
	public void createEmployeeTbl();
}
