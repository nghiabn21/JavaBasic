package finalExam.entity;

import java.time.LocalDate;
import java.util.Scanner;

import finalExam.utils.Validation;

public abstract class GiaoDich {
	private String maID;
	private double price, area;
	private LocalDate day; 
	Scanner sc  = new Scanner(System.in); 
	 
	

	public String getMaID() {
		return maID;
	}

	public void setMaID(String maID) {
		this.maID = maID;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public GiaoDich(String maID, double area, double price, LocalDate day) {
		super();
		this.maID = maID;
		this.area = area;
		this.price = price;
		this.day = day;
	}

	public GiaoDich() {
		super();
	}

	@Override
	public String toString() {
		return "Mã giao dịch: " + maID + ", diện tích: " + area + ", đơn giá: " + price + ", ngày giao dịch: " + day ;
	} 
	 
	public double tinhVat() {  
		double vat = price * area * 0.1;
		return vat ;
	} 
	 
	public void nhap() { 
	        System.out.println("Nhập mã giao dịch: ");
	        maID = sc.nextLine();	       
	        do {  
	        	try { 
	        		 System.out.println("Nhập ngày giao dịch (ngày/tháng/năm): "); 
		 	         String daytime = sc.nextLine() ;   
		 	         day = Validation.isDate(daytime) ;
	        	}catch (Exception e) {
					System.out.println("Lỗi !!! yêu cầu nhập đúng định dạng (dd/MM/yyyy)"); 
					continue ;
				}
	        	break ;      
	        }while(true) ;
	       
	        System.out.println("Nhập đơn giá: "); 
	        String gia = sc.nextLine() ;
	        price = Double.parseDouble(gia) ;
	        System.out.println("Nhập diện tích: ");
	        String dt = sc.nextLine() ; 
	        area = Double.parseDouble(dt) ;
	    
	}

}
