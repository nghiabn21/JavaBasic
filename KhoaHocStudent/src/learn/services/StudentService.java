package learn.services;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import learn.models.Student;
import learn.utils.InvalidIdException;
import learn.utils.PhoneFormatException;
import learn.utils.Validator;

public class StudentService { 
	 
	
	public Set<Student> createStudent(Scanner sc , int maxStudent){ 
		String id, name, phone, gender, gpa; 
		String loop = ""; // ng dùng nhập có muốn tiếp tục hay k  
		Student student ; 
		boolean addStudent = false ; //xem xét thêm vào hay chưa 
		 
		Set<Student> students = new HashSet<Student>(); 
		 
		do {  
			 student = new Student(); 
			 // thêm id
			do { 
				System.out.println("Nhập ID: "); 
				id = sc.nextLine(); 
				try {
					student.setId(id);
				} catch (InvalidIdException e) {
					e.printStackTrace(); 
					continue ;
				} 
				break ; // nếu mà nhận id thành công thì thoát khỏi vòng lặp
			}while(true); 
			 
			// tên 
			System.out.println("Nhập tên "); 
			name = sc.nextLine(); 
			student.setName(name);  
			 
			// gender
			System.out.println("Nhập gender "); 
			gender = sc.nextLine(); 
			student.setGender(gender); 
			 
			// gpa 
			System.out.println("Nhập GPA "); 
			gpa = sc.nextLine(); 
			student.setGpa(Double.parseDouble(gpa));  
			 
			//phone 
			do { 
				System.out.println("Nhập phone: "); 
				phone = sc.nextLine(); 
					try {
						student.setPhone(phone);
					} catch (PhoneFormatException e) {
						
						continue ;
					}
				break ; // nếu mà nhận phone thành công thì thoát khỏi vòng lặp
			}while(true);  
			 
			addStudent = students.add(student) ; 
			 
			if( !addStudent) { 
				System.out.println("Student đã tồn tại"); 
				
			} 
			 
			if(students.size() < maxStudent) { 
				System.out.println("bạn có muốn tiếp tục thêm không (Y/N) ?"); 
				loop = sc.nextLine();
			}else { 
				loop = "N" ;
			} 
			 
			// Reset the set
			 if (loop.charAt(0) != 'Y' && loop.charAt(0) != 'y') {
			 Validator.getIds().clear();
			 }
			 			
		}while(loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		 
		
		return students; 
		
	}

}
