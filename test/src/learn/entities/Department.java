package learn.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Department { 
	private String departmentName ; 
	private List<Employee> listOfEmployee = new ArrayList<Employee>() ; 
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}
	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}
	public Department(String departmentName, List<Employee> listOfEmployee) {
		super();
		this.departmentName = departmentName;
		this.listOfEmployee = listOfEmployee;
	}
	public Department() {
		super();
	} 
	 
	private void display() { 
		System.out.println();
	} 
	 
	public void nhap() { 
		Scanner sc = new Scanner(System.in); 
		System.out.println("===== Nhập departmentName:  "); 
		departmentName = sc.nextLine();  
		SalariedEmployee e = new SalariedEmployee();  
		System.out.println("===== Nhập SalariedEmployee ===== "); 
		e.nhap();  
		HourlyEmployee h = new HourlyEmployee();  
		System.out.println("===== Nhập HourlyEmployee ===== "); 
		h.nhap(); 
		listOfEmployee.add(e); 
		listOfEmployee.add(h);
		} 
	 

}
