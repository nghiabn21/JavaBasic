package learn.entities;

import java.util.Scanner;

public class HourlyEmployee extends Employee{ 
	private double rate, workingHours ;

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	public HourlyEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email,
			double rate, double workingHours) {
		super(ssn, firstName, lastName, birthDate, phone, email);
		this.rate = rate;
		this.workingHours = workingHours;
	} 
	 
	public HourlyEmployee(){ 
		
	}

	@Override
	public String toString() {
		return "HourlyEmployee [rate=" + rate + ", workingHours=" + workingHours + "]";
	}

	public HourlyEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
		super(ssn, firstName, lastName, birthDate, phone, email);
	}

	@Override
	public void display() {
		System.out.println("Số điện thoại: " + getPhone());
		
	} 
	  
	public void nhap() { 
		Scanner sc = new Scanner(System.in);  
		super.nhap();
		System.out.println("Nhập rate: "); 
		rate = sc.nextDouble() ; 
	
		System.out.println("Nhập workingHours: "); 
		workingHours = sc.nextDouble() ; 

	}
	

}
