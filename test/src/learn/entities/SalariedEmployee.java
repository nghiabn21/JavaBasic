package learn.entities;

import java.text.ParseException;
import java.util.Scanner;

public class SalariedEmployee extends Employee{ 
	private double commisstionRate, grossSales, basicSalary ;

	public double getCommisstionRate() {
		return commisstionRate;
	}

	public void setCommisstionRate(double commisstionRate) {
		this.commisstionRate = commisstionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

   public SalariedEmployee() { 
	   
   }

	public SalariedEmployee(String ssn, String firstName, String lastName, String birthDate, String phone,
			String email) {
		super(ssn, firstName, lastName, birthDate, phone, email);
	}

	@Override
	public String toString() {
		return "SalariedEmployee [commisstionRate=" + commisstionRate + ", grossSales=" + grossSales + ", basicSalary="
				+ basicSalary + "]";
	}

	@Override
	public void display() {
		System.out.println("Số điện thoại: " + getPhone());
		
	} 
	 
	public void nhap(){ 
		Scanner sc = new Scanner(System.in);  
		super.nhap();
		System.out.println("Nhập commisstionRate: "); 
		commisstionRate = sc.nextDouble() ; 
	
		System.out.println("Nhập grossSales: "); 
		grossSales = sc.nextDouble() ; 

		System.out.println("Nhập basicSalary: "); 
		basicSalary = sc.nextDouble() ; 
	
	}


}
