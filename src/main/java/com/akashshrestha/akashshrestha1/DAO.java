package com.akashshrestha.akashshrestha1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {
	Connection conn = DBConnection.getConnection();

	public void createEmployee(Employee employee) throws SQLException {

		PreparedStatement post = conn.prepareStatement("INSERT INTO employees VALUES (?,?,?,?,?)");
		post.setInt(1, employee.getId());
		post.setString(2, employee.getFirstName());
		post.setString(3, employee.getLastName());
		post.setString(4, "" + employee.getGender());
		post.setDouble(5, employee.getSalary());
		post.executeUpdate();

	}

	public boolean deleteEmployee(int empId) throws SQLException {
		PreparedStatement post = conn.prepareStatement("DELETE FROM employees WHERE Id=?");
		post.setInt(1, empId);
		int rst = post.executeUpdate();
		if (rst == 0) {
			return false;
		}
		return true;

	}

	public Employee findEmployee(int empId) throws SQLException {
		PreparedStatement post = conn.prepareStatement("SELECT * FROM employees WHERE Id=?");
		post.setInt(1, empId);
		ResultSet rset = post.executeQuery();
		// checkresultset(rset);
		Employee e = null;
		while (rset.next()) {

			e = new Employee(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble("Salary"));

			return e;
		}
		return null;
	}

	public void checkresultset(ResultSet rset) throws SQLException {
		ResultSetMetaData rsmd = rset.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rset.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				if (i > 1)
					System.out.print(",  ");
				String columnValue = rset.getString(i);
				System.out.print(columnValue + " " + rsmd.getColumnName(i));
			}
			System.out.println("");
		}
	}

	public List<Employee> findAll() throws SQLException {
		List<Employee> employeelist = new ArrayList<>();
		PreparedStatement post = conn.prepareStatement("SELECT * FROM employees ");
		ResultSet rset = post.executeQuery();
		Employee emp;
		while (rset.next()) {
			emp = new Employee(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble("Salary"));

			employeelist.add(emp);
		}
		return employeelist;

	}

	public boolean updateEmployee(Employee employee) throws SQLException {
		PreparedStatement post = conn
				.prepareStatement("UPDATE employees SET FirstName=?, SecondName=?, Salary=? WHERE Id = ?;");
		post.setString(1, employee.getFirstName());
		post.setString(2, employee.getLastName());
		post.setDouble(3, employee.getSalary());
		post.setInt(4, employee.getId());
		int rst = post.executeUpdate();
		if (rst == 0) {
			return false;
		}
		return true;

	}

	public double calculateGrossSal(int empId) throws SQLException {

		double cHRA = 0.0;
		PreparedStatement post = conn
				.prepareStatement("SELECT Salary*(20.00/100.00) AS GrossSalary FROM employees where Id=?;");
		post.setInt(1, empId);
		ResultSet rst = post.executeQuery();
	//	checkresultset(rst);

		if (rst.next()) {
			cHRA = rst.getDouble("Gross Salary");

		}
		return cHRA;

	}

	public double displayHRA(int empId) throws SQLException {
		double cHRA = 0.0;
		PreparedStatement post = conn.prepareStatement("SELECT (Salary)+Salary*0.15 AS HRA FROM employees where Id=?;");
		post.setInt(1, empId);
		ResultSet rst = post.executeQuery();
		//checkresultset(rst);

		if (rst.next()) {
			cHRA = rst.getDouble("HRA");

		}
		return cHRA;
	}

	public List<Employee> sortbyid() throws SQLException {
		List<Employee> employeelist = new ArrayList<>();
		PreparedStatement post = conn.prepareStatement("SELECT * FROM employees ORDER BY ID; ");
		ResultSet rset = post.executeQuery();
		Employee emp;
		while (rset.next()) {
			emp = new Employee(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble("Salary"));

			employeelist.add(emp);
			//System.out.println("TEST");
		}
		return employeelist;

	}
	public List<Employee> sortbysalary() throws SQLException {
		List<Employee> employeelist = new ArrayList<>();
		PreparedStatement post = conn.prepareStatement("SELECT * FROM employees ORDER BY Salary; ");
		ResultSet rset = post.executeQuery();
		Employee emp;
		while (rset.next()) {
			emp = new Employee(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble("Salary"));

			employeelist.add(emp);
			
		}
		return employeelist;
	}
	public List<Employee> sortbyFirstname() throws SQLException {
		List<Employee> employeelist = new ArrayList<>();
		PreparedStatement post = conn.prepareStatement("SELECT * FROM employees ORDER BY FirstName; ");
		ResultSet rset = post.executeQuery();
		Employee emp;
		while (rset.next()) {
			emp = new Employee(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble("Salary"));

			employeelist.add(emp);
			
		}
		return employeelist;
		
	}
	public Map<String, Double> groupbyAverageSalary() throws SQLException {
		double avg=0.0;
		PreparedStatement post = conn.prepareStatement("Select avg(Salary) from employees");
		ResultSet rset = post.executeQuery();
		
		if (rset.next()) {
			
			avg=rset.getDouble(1);
		}
		Map<String, Double> avmap = new HashMap<>();
		avmap.put("Avergae", avg);
		return avmap;
		
	
	}
	


}
