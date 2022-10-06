package learn.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

import bai1.Book;
import bai1.Magazine;
import learn.entities.Department;
import learn.entities.Employee;
import learn.entities.HourlyEmployee;
import learn.entities.SalariedEmployee;

public class Functional {    
	List<Department> list = new ArrayList<Department>();
	
	public void main() throws ParseException { 	
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Menu");
			System.out.println("====== EMPLOYEE MANAGEMENT SYSTEM =====");
			System.out.println("1. Add an employee");
			System.out.println("2. Display employees");
			System.out.println("3. Classify employees");
			System.out.println("4. Search book by (department)"); 
			System.out.println("5. Search book by (emp’s name)");
			System.out.println("Please choose function you'd like to do:");
			int sc1 = sc.nextInt();
			switch (sc1) {
			case 1:
				Department d = new Department(); 
				d.nhap();  
				list.add(d); 			
				break;
			case 2:
				displayEmployeee();
				break;
			case 3:
                phanLoai();
				break;
			case 4:
                searchByDepartmentName();
				break; 
			case 5:
				searchByEMployeeName();
				break; 
			case 6:  
				
				break ;
			default: 
				System.out.println("Lỗi!!!");
				break;
			}
		} while (true);
	}

	public void searchByDepartmentName() { 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Nhập tên DP cần tìm: "); 
		String nameD = sc.nextLine(); 
		Department d = null ;  
		for(Department de : list) { 
			if(de.getDepartmentName().equals(nameD)) { 
				d = de ; 
				break; 
			}
		} 
		if( d != null) {  
			System.out.println(	d.getListOfEmployee().toString());
		}else { 
			System.out.println("Không tìm thấy Nhân viên");
		}		
	} 
	 
	public void searchByEMployeeName() { 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Nhập tên Employee Name cần tìm: "); 
		String nameD = sc.nextLine(); 
		List<Department> d = new ArrayList<Department>() ;  
		for(Department de : list) {  
			for(Employee e : de.getListOfEmployee()) { 
				if(e.getFirstName().equals(nameD)) { 
					d.add(de); 
					break; 
				}
			}	
		} 
		if( d != null) {  
			for(int i = 0 ; i < d.size(); i++) { 
				System.out.println(d.get(i));
			}
		}else { 
			System.out.println("Không tìm thấy NHÂN VIÊN");
		}		
	} 
	 
	public void phanLoai() { 
		 Scanner sc = new Scanner(System.in); 
		 System.out.println("Đối tượng cần phân loại: "); 
		 String doiTuong = sc.nextLine();  
		 for(Department d : list) { 
			 for(Employee em : d.getListOfEmployee()) {  
				    if(em.getFirstName().equals(doiTuong)) { 
				    	System.out.println("Xác định đối tượng tồn tại:");
				    	if(em instanceof SalariedEmployee) { 		
						System.out.println(((SalariedEmployee)em).toString()) ; 
						break ;
						} 
						if(em instanceof HourlyEmployee) { 	
						System.out.println(((HourlyEmployee)em).toString()); 
						break ;
						}
				    }
			 } 
		 }
		
		} 
	 
	public void displayEmployeee() { 
		for(Department em : list) {  
			for(Employee e : em.getListOfEmployee()) { 
				if(e instanceof SalariedEmployee) {  				
				System.out.println(((SalariedEmployee)e).toString());				
				} 
				if(e instanceof HourlyEmployee) {  	
				System.out.println(((HourlyEmployee)e).toString());				
				}
			}		
		}
	} 
	 
   
}
