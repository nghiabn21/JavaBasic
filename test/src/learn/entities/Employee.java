package learn.entities;

import java.text.ParseException;
import java.util.Scanner;

import learn.utils.ValidationRules;

public abstract class Employee { 
	private String ssn, firstName, lastName, birthDate, phone, email;

	@Override
	public String toString() {
		return "Employee [ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", phone=" + phone + ", email=" + email + "]";
	}

	public Employee(String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
	}

	public Employee() {
		super();
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
	 
	public abstract void display();

	public void nhap() {
		Scanner sc = new Scanner(System.in);  
		System.out.println("Nhập ssn: "); 
		ssn = sc.nextLine() ; 
	  
		System.out.println("Nhập firstName: "); 
		firstName = sc.nextLine() ; 
	 
		System.out.println("Nhập lastName: "); 
		lastName = sc.nextLine() ;  
		
		System.out.println("Nhập birthDate: "); 
		birthDate = sc.nextLine() ;     
		ValidationRules valid = new ValidationRules(); 
		try {
			valid.StringToDate(birthDate);
		} catch (ParseException e) {
			System.out.println("Không hợp lệ!!");
			e.printStackTrace();
		}
		
		System.out.println("Nhập phone: ");  
		phone = sc.nextLine() ;    
		try {
			if(valid.inValidNumber(phone)) { 
				System.out.println("Đúng định dạng!");
			}else { 
				System.out.println("Không đúng định dạng!");
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Nhập email: "); 
		email = sc.nextLine() ; 	 
		try {		
			if(valid.isValidEmail(email)) { 
				System.out.println("Đúng định dạng!");
			}else { 
				System.out.println("Không đúng định dạng!");
			}
		} catch (ParseException e) { 
			System.out.println("Không hợp lệ!!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
