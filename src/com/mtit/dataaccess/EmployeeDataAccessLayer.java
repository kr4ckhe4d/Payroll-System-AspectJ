package com.mtit.dataaccess;

import java.util.List;
import java.sql.SQLException;

public interface EmployeeDataAccessLayer {
	public Employee getEmployee(int id) throws SQLException;
	public void createEmployeeTable() throws SQLException;
	public boolean insertEmployee(Employee employee) throws SQLException;
	public boolean updateEmployee(Employee employee) throws SQLException;
	public boolean deleteEmployee(Employee employee) throws SQLException;
	public List<Employee> getAllEmployees() throws SQLException;
}
