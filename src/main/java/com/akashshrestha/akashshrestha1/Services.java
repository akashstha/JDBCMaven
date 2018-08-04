package com.akashshrestha.akashshrestha1;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Manohar on 4/21/2017.
 */
public interface Services {

    void createEmployee(Employee employee) throws SQLException;

    Employee findEmployee(int empId);

    List<Employee> findAll();

    boolean deleteEmployee(int empId);

    boolean updateEmployee(Employee employee);

    double displayHRA(int empId);

    double calculateGrossSal(int empId);
    
    public List<Employee> sortbyid();
    
    public List<Employee> sortbysalary();
    
    public List<Employee> sortbyFirstname();
    
	Map<String, Double> groupbyAverageSalary();

	Double calculateGrossSal();

//	Map<Gender, List<Employee>> groupbyGender();
}
