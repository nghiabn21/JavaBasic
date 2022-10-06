package bai1;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Book extends Publication{ 
	private String isbn;   // số tiêu chuẩn của sách 
	private Set<String> author = new HashSet<String>() ;   // tên tác giả 
	private String publicationPlace ;  //
	 
	public Book() { 
		super(); 
	}

	public Book(String publisher) {
		super(publisher);
	}

	@Override
	public void display() {	  
		
		System.out.println(super.toString() + " Author: "+ author +" Mã sách: " + isbn + " Nơi phát hành: " + publicationPlace + " ");
	} 

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<String> getAuthor() {
		return author;
	}

	public void setAuthor(Set<String> author) {
		this.author = author;
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}

	public Book(String publisher, String isbn, Set<String> author, String publicationPlace) {
		super(publisher);
		this.isbn = isbn;
		this.author = author;
		this.publicationPlace = publicationPlace;
	} 
	 
	public void nhap() throws ParseException { 
		Scanner sc = new Scanner(System.in);  
		super.nhap();
		System.out.println("Nhập isbn: "); 
		isbn = sc.nextLine() ; 
	//
		sc.nextLine();  
//		System.out.println("Nhập Author: "); 
//		author = sc.nextLine() ; 
	//	sc.nextLine();   
		System.out.print("nhập Set(Author):"); 
        String setAu = sc.nextLine();   
        if(setAu.isEmpty()) { 
         author.add(null);
        }else { 
         author.add(setAu);
        }
       
		System.out.println("Nhập publicationPlace: "); 
		publicationPlace = sc.nextLine() ; 
	//	sc.nextLine(); 
	} 
	 
	
	 

}
