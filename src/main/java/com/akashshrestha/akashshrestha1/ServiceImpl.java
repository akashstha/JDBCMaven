package com.akashshrestha.akashshrestha1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.akashshrestha.akashshrestha1.DBConnection;

public class ServiceImpl implements Services {

	private DAO dao = new DAO();

	@Override
	public void createEmployee(Employee employee) {
		try {
			dao.createEmployee(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Employee findEmployee(int empId) {
		Employee e;

		try {
			e = dao.findEmployee(empId);
			return e;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Employee> findAll() {
		List<Employee> e = new ArrayList<>();
		try {
			e = dao.findAll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		try {
			if (dao.deleteEmployee(empId))
				return true;
			else {
				throw new Exception("Employee ID not found");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
		return false;

	}

	@Override
	public boolean updateEmployee(Employee employee) {

		try {
			if (dao.updateEmployee(employee))
				return true;
			else {
				throw new Exception("Employee ID not found");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
		return false;
	}

	@Override
	public double displayHRA(int empId) {
		double hra = 0.0;
		try {
			hra = dao.displayHRA(empId);

			/*
			 * if (HRA <= 0.0) throw new Exception("HRA could not be calculated.");
			 */
		} catch (Exception e) {
			System.err.println(("test"));
		}
		return hra;
	}

	@Override
	public double calculateGrossSal(int empId) {
		double grossSalary = 0.0;
		try {
			grossSalary = dao.calculateGrossSal(empId);

			/*
			 * if (HRA <= 0.0) throw new Exception("HRA could not be calculated.");
			 */
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return grossSalary;

	}

	@Override
	public List<Employee> sortbyid() {
		List<Employee> e = new ArrayList<>();
		try {
			e = dao.sortbyid();
		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		}
		return e;
	}

	@Override
	public List<Employee> sortbysalary() {
		List<Employee> e = new ArrayList<>();
		try {
			e = dao.sortbysalary();
		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		}
		return e;
	}

	@Override
	public List<Employee> sortbyFirstname() {
		List<Employee> e = new ArrayList<>();
		try {
			e = dao.sortbyFirstname();
		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		}
		return e;
	}

	@Override
	public Map<String, Double> groupbyAverageSalary() {
		Map<String, Double> avgSalary = null;
		try {
			avgSalary = dao.groupbyAverageSalary();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return avgSalary;
	}

	@Override
	public Double calculateGrossSal() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public Map<Gender, List<Employee>> groupbyGender() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
