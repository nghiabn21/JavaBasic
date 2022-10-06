package learn.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import learn.models.Course;
import learn.models.CourseTitleCompare;
import learn.models.Student;
import learn.utils.InvalidIdException;
import learn.utils.Validator;

public class CourseService {

	public List<Course> createCourse(Scanner sc){ 
		String id , loop, title, credit, enrollment ;  
		double doCredit ;
		int intEnrollment ; 
		Course course; 
		Set<Student> students = new HashSet<Student>();
		List<Course> courses = new ArrayList<Course>();
		StudentService studentService = new StudentService(); 
		 
		do {  
			course = new Course(); 
			
			 do { 
				System.out.println("Nhập ID:"); 
				id = sc.nextLine();  
				try {
					course.setId(id);
				} catch (InvalidIdException e) {
				//	e.printStackTrace(); 
					continue;
				} 
				break ;
			 }while(true); 
			  
			 System.out.println("Nhập Title:"); 
			 title = sc.nextLine(); 
			 course.setTitle(title); 
			  
			 do { 
				 System.out.println("Nhập credit: "); 
				 credit = sc.nextLine(); 
				 try {
					  doCredit = Validator.isCredit(credit);
					  course.setCredit(doCredit);
					  } catch (NumberFormatException e) {
					 continue; 
					  } 
				 break ;
			 }while(true);  
			  
			 do {
				  System.out.println("Enter course enrollment:");
				  enrollment = sc.nextLine();	 
				  try { 
					  intEnrollment = Validator.isEnrollment(enrollment);
					  course.setEnrollment(intEnrollment);	 
				  }catch (NumberFormatException e) {
						 continue; 
				  } 
				  break ;
				  
				  } while (true);
			  
			// Set student to the course
			  System.out.println("----Enter Student in the Course----");
			  students = studentService.createStudent(sc, intEnrollment);
			  course.setStudents(students);
			 
			  // Add course to list
			  courses.add(course);
			 
			  // Do you want to continue?
			  System.out.println("Do you want continue to input course (Y/N)?: ");
			  loop = sc.nextLine();
			  		
		}while(loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');  	 
		return courses;	
	}  
	 
	public String save(List<Course> courses) throws IOException { 
		ObjectOutputStream objectOutputStream = null ; 
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream("course.dat")); 
			objectOutputStream.writeObject(courses);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(objectOutputStream != null) { 
				objectOutputStream.close();
			}
		} 
		return "success" ;	
	} 
	  
	
	@SuppressWarnings("unchecked")
	public List<Course> getAll() throws ClassNotFoundException, IOException{ 
		ObjectInputStream inputStream = null ;  
		List<Course> courses = null ;
		try {
			inputStream = new ObjectInputStream( new FileInputStream("course.dat")); 
			courses = (List<Course>) inputStream.readObject() ; // khai báo supressWarning
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(inputStream != null) { 
				inputStream.close();
			}
		}	
		return courses; 
		
	} 
	 
	public void sortAndDisplay(List<Course> courses) { 
		Collections.sort(courses, new CourseTitleCompare()); 
		 
		for(Course cou : courses) { 
			System.out.format("%s%20s%12.3f%5d%100s%n", cou.getId(),
					 cou.getTitle(), cou.getCredit(), cou.getEnrollment(), cou.getStudents());				 
		}	
	} 
	 
	public List<Course> getByStudent(String studentID) throws ClassNotFoundException, IOException{  
		List<Course> courses = getAll() ; 
		List<Course> courses2 = new ArrayList<Course>(); 
		 
		if(courses != null) {  // kiểm tra xem mảng rỗng hay k
			for(Course course : courses) {   // không rỗng thì duyệt
				for(Student st : course.getStudents()) {  
					if(studentID.equalsIgnoreCase(st.getId())) { 
						courses2.add(course);
					}
					
				}
			}
		}	
		return courses2; 
		
	} 

	public String remove(String id) throws Exception {
		boolean removed = false;

		List<Course> courses = getAll();
		if (courses == null) {
			throw new IOException();
		}
		Iterator<Course> iterator = courses.iterator();
		while (iterator.hasNext()) {
			Course course = iterator.next();
			if (id.equalsIgnoreCase(course.getId())) {
				iterator.remove();
				removed = true;
				break;
			}
		}

		if (removed) {
			try {
				// update list
				save(courses);
			} catch (Exception e) {
				throw new Exception();
			}

			return "success"; 
		}
		return "failed";
	}

}

 
 



