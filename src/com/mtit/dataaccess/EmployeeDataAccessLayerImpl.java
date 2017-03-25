package com.mtit.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class EmployeeDataAccessLayerImpl implements EmployeeDataAccessLayer{
	
	@Override
	public Employee getEmployee(int id) throws SQLException {
		
		Connection connection = DatabaseConnection.getConnection();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee WHERE id = " + id);
		//int id, String fName, String designation, double salary, double epf
		while(resultSet.next()) {
			Employee emp = getEmployeeFromResultSet(resultSet);
			resultSet.close();
			statement.close();
			DatabaseConnection.closeConnection();
			return emp;
		}

		throw new SQLException();
	}

	@Override
	public boolean insertEmployee(Employee emp) throws SQLException {
		
		Connection connection = DatabaseConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO Employee VALUES (NULL, ?, ?, ?, ?)");
		//int id, String fName, String designation, double salary, double epf

		statement.setString(1, emp.getFullName());
		statement.setString(2, emp.getDesignation());
		statement.setDouble(3, emp.getSalary());
		statement.setDouble(4, emp.getEPF());
        
        int result = statement.executeUpdate();
        statement.close();
        DatabaseConnection.closeConnection();
        
        if(result == 1)
        	return true;
		
		throw new SQLException();
	}

	@Override
	public boolean updateEmployee(Employee emp) throws SQLException {
		
		Connection connection = DatabaseConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("UPDATE Employee SET fName=?, designation=?, salary=?, epf=? WHERE id=?");
		statement.setString(1, emp.getFullName());
		statement.setString(2, emp.getDesignation());
		statement.setDouble(3, emp.getSalary());
		statement.setDouble(4, emp.getEPF());
		statement.setInt(5, emp.getID());
        
        int result = statement.executeUpdate();
        statement.close();
        DatabaseConnection.closeConnection();
        
        if(result == 1)
        	return true;
        
        throw new SQLException();
	}

	@Override
	public boolean deleteEmployee(Employee emp) throws SQLException {
		
		Connection connection = DatabaseConnection.getConnection();
		
		Statement statement = connection.createStatement();
		boolean result = statement.execute("DELETE FROM Employee WHERE id = " + emp.getID());
	
        statement.close();
        DatabaseConnection.closeConnection();
		
        return true;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		
		Connection connection = DatabaseConnection.getConnection();
		
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Employee");
		
		List<Employee> list = new Vector<Employee>();
		
		while(rs.next()) {
			Employee emp = getEmployeeFromResultSet(rs);
			list.add(emp);
		}
		
		rs.close();
		statement.close();
		DatabaseConnection.closeConnection();

		return list;
	}
	
	@Override
	public void createEmployeeTable() throws SQLException{
		//int id, String fName, String designation, double salary, double epf

		Connection connection = DatabaseConnection.getConnection();
		
		Statement statement = connection.createStatement();
		statement.executeUpdate(
				"CREATE TABLE 'Employee' "
				+ "( `id` INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "`fName` TEXT, "
				+ "`designation` TEXT, "
				+ "`salary` NUMERIC, "
				+ "`epf` NUMERIC )");
		
		statement.close();
		DatabaseConnection.closeConnection();
	}

	private Employee getEmployeeFromResultSet(final ResultSet resultSet) throws SQLException {
		
		int id = resultSet.getInt("id");
		String fName = resultSet.getString("fName");
		String designation = resultSet.getString("designation");
		double salary = resultSet.getDouble("salary");
		double epf = resultSet.getDouble("epf");
		//int id, String fName, String designation, double salary, double epf
		return new Employee(id, fName, designation, salary, epf);
	}
}
