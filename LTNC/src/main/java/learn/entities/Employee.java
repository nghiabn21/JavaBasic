package learn.entities;

public class Employee { 
	private int employeeID, salary, supervisorID;  
	private String employeeName ;
	public Employee(int employeeID, int salary, int supervisorID, String employeeName) {
		super();
		this.employeeID = employeeID;
		this.salary = salary;
		this.supervisorID = supervisorID;
		this.employeeName = employeeName;
	}
	public Employee() {
		super();
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSupervisorID() {
		return supervisorID;
	}
	public void setSupervisorID(int supervisorID) {
		this.supervisorID = supervisorID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	} 
	 
	
	

}
