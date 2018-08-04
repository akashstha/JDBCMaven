package com.akashshrestha.akashshrestha1;

public class Employee {
private int id;
	private String firstName;
	private String lastName;
	private double salary;
	private String gender = "male";
	
	public Employee getHighSalaryEmployee(Employee e) {
		return this.salary > e.salary ? this : e;
	}
	public Employee() {
		super();
	}



	public Employee(int id, String firstName, String lastName, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		
	}
	public Employee(int id) {
		super();
		this.id = id;
	}


	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Employee(int id, String firstName, String lastName, double salary,int gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		/*this.address = address;
		this.manager = manager;
		this.period = period;
		this.gender = gender;*/
		
	}

	
	

	public double calculateHRA(){
		//System.out.println(salary);
		double hra = (salary)*(20.00/100.00);
		//System.out.println(hra);
		return hra;	
		
	}
	
	public double calculateGrossSal(){
		
		double grossSal = this.salary + calculateHRA();
		return grossSal;
		
		
	}
	
	
	



	@Override
	public String toString() {
		return "trng.Employee [id=" + id + ", firstName=" + firstName + ", LastName=" + lastName + ", salary=" + salary
				+ ", gender=" + gender + "]\n";
	}
	

	
}
